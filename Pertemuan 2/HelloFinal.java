import java.awt.event.*;
import javax.swing.*;

public class HelloFinal extends JFrame {
    public HelloFinal() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputNama = new JLabel("Input Nama: ");
        labelInputNama.setBounds(20, 20, 150, 30);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(180, 20, 150, 30);

        JLabel labelInputTelp = new JLabel("Input Nomor Telepon: ");
        labelInputTelp.setBounds(20, 60, 150, 30);

        JTextField textFieldTelp = new JTextField();
        textFieldTelp.setBounds(180, 60, 150, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(20, 100, 150, 30);

        JRadioButton radioButtonLK = new JRadioButton("Laki-Laki", true);
        radioButtonLK.setBounds(180, 100, 100, 30);

        JRadioButton radioButtonPR = new JRadioButton("Perempuan");
        radioButtonPR.setBounds(280, 100, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonLK);
        bg.add(radioButtonPR);

        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(180, 140, 180, 30);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(180, 180, 150, 30);

        JTextArea textFieldOutput = new JTextArea();
        textFieldOutput.setBounds(20, 220, 400, 200);

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telp = textFieldTelp.getText();
                String jenisKelamin = radioButtonLK.isSelected() ? "Laki-Laki" : "Perempuan";
                String wna = checkBoxWNA.isSelected() ? "Iya" : "Tidak";

                textFieldOutput.setText("Nama: " + nama + "\n"
                                      + "Nomor HP: " + telp + "\n"
                                      + "Jenis Kelamin: " + jenisKelamin + "\n"
                                      + "WNA: " + wna);
            }
        });

        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputTelp);
        this.add(textFieldTelp);
        this.add(labelRadio);
        this.add(radioButtonLK);
        this.add(radioButtonPR);
        this.add(checkBoxWNA);
        this.add(buttonSimpan);
        this.add(textFieldOutput);

        this.setSize(450, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloFinal frame = new HelloFinal();
                frame.setVisible(true);
            }
        });
    }
}
