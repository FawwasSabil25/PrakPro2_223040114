import java.awt.event.*;
import javax.swing.*;

public class HelloTextAre2 extends JFrame{
    public HelloTextAre2(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputNama = new JLabel("input Nama : ");
        labelInputNama.setBounds(130,40,100,10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130,60,100,30);

        JLabel labelInputTelp = new JLabel("input Nomor Telepon ");
        labelInputTelp.setBounds(130,40,100,10);

        JTextField textFieldTelp = new JTextField();
        textFieldTelp.setBounds(130,60,100,30);

        JButton button = new JButton("Klik");
        button.setBounds(130,100,100,10);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130,150,100,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telepon = textFieldTelp.getText();
                txtOutput.append("Nama: " + nama + "\nNomor Telepon: " + telepon + "\n" + "==============" + "\n");
                textFieldNama.setText("");
                textFieldTelp.setText("");
            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInputNama);
        this.add(textFieldTelp);
        this.add(labelInputTelp);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                HelloTextArea h = new HelloTextArea();
                h.setVisible(true);
            }
        });
    }
}
