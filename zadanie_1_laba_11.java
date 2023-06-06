import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class zadanie_1_laba_11 extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button;

    public zadanie_1_laba_11() {
        super("My window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel label1 = new JLabel("Enter text (max - 25 characters):");
        panel.add(label1);

        textField1 = new JTextField(25);
        panel.add(textField1);

        JLabel label2 = new JLabel("Specify the path to the file:");
        panel.add(label2);

        textField2 = new JTextField();
        panel.add(textField2);

        button = new JButton("Save");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                String fileName = textField2.getText();

                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(fileName);
                    fileWriter.write(text);
                    fileWriter.close();
                    JOptionPane.showMessageDialog(null, "The data is written to a file.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error writing to file!");
                }
            }
        });
        panel.add(button);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        zadanie_1_laba_11 window = new zadanie_1_laba_11();
    }
}
