import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;

public class Tugas2 extends JFrame {
    
    // Constructor Layout & Componen
    public Tugas2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit app klika di close

        // Membuat label dan text field untuk input nama
        JLabel labelInputNama = new JLabel("Nama: "); // Label  nama
        labelInputNama.setBounds(20, 20, 150, 30); // Mengatur posisi dan ukuran label

        JTextField textFieldNama = new JTextField(); // Text field input nama
        textFieldNama.setBounds(180, 20, 150, 30); // Mengatur posisi dan ukuran text field

        // Membuat label dan text field untuk input nomor telepon
        JLabel labelInputTelp = new JLabel("Nomor Telepon: "); // Label nomor telepon
        labelInputTelp.setBounds(20, 60, 150, 30); // Mengatur posisi dan ukuran label

        JTextField textFieldTelp = new JTextField(); // Text field input nomor telepon
        textFieldTelp.setBounds(180, 60, 150, 30); // Mengatur posisi dan ukuran text field

        // Membuat radio button untuk memilih jenis kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:"); // Labe jenis kelamin
        labelRadio.setBounds(20, 100, 150, 30); // Mengatur posisi dan ukuran label

        JRadioButton radioButtonLK = new JRadioButton("Laki-Laki", true); // Radio button Laki-Laki (default)
        radioButtonLK.setBounds(180, 100, 100, 30); // Mengatur posisi dan ukuran radio button

        JRadioButton radioButtonPR = new JRadioButton("Perempuan"); // Radio button Perempuan
        radioButtonPR.setBounds(280, 100, 100, 30); // Mengatur posisi dan ukuran radio button

        ButtonGroup bg = new ButtonGroup(); // Group untuk radio button, agar cuman 1 yang dipilih
        bg.add(radioButtonLK); // add radio button laki laki ke group
        bg.add(radioButtonPR); // add radio button perempuan ke group

        //checkbox status WNA
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing"); // Checkbox WNA
        checkBoxWNA.setBounds(180, 140, 180, 30); // Mengatur posisi dan ukuran checkbox

        //JList memilih jenis tabungan
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:"); // Label jenis tabungan
        labelJenisTabungan.setBounds(20, 180, 150, 30); // Mengatur posisi dan ukuran label

        String[] jenisTabungan = {"Tabungan Reguler", "Tabungan Berjangka", "Tabungan Pendidikan", "Tabungan Haji"}; // Daftar tabungan
        JList<String> listTabungan = new JList<>(jenisTabungan); //JList pilihan tabungan
        listTabungan.setBounds(180, 180, 150, 60); // Mengatur posisi dan ukuran JList
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //cmn pilih 1 tabungan

        //JSpinner frekuensi transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi per Bulan:"); // Label frekuensi transaksi
        labelFrekuensi.setBounds(20, 250, 200, 30); // Mengatur posisi dan ukuran label

        SpinnerModel frekuensiModel = new SpinnerNumberModel(1, 1, 100, 1); //spinner 1 - 100
        JSpinner spinnerFrekuensi = new JSpinner(frekuensiModel); //spinner frekuensi transaksi
        spinnerFrekuensi.setBounds(220, 250, 50, 30); // Mengatur posisi dan ukuran spinner

        //JSpinner tgl lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:"); // Label tanggal lahir
        labelTanggalLahir.setBounds(20, 290, 150, 30); // Mengatur posisi dan ukuran label

        JSpinner spinnerTanggalLahir = new JSpinner(new SpinnerDateModel()); // Spinner input tanggal lahir
        spinnerTanggalLahir.setBounds(180, 290, 150, 30); // Mengatur posisi dan ukuran spinner
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy"); // Format tgl
        spinnerTanggalLahir.setEditor(dateEditor); //editor utk format tgl

        //JpasswordField utk password dan konfirmasinya
        JLabel labelPassword = new JLabel("Password:"); // Label password
        labelPassword.setBounds(20, 330, 150, 30); // Mengatur posisi dan ukuran label

        JPasswordField passwordField = new JPasswordField(); // Field input password
        passwordField.setBounds(180, 330, 150, 30); // Mengatur posisi dan ukuran password field

        JLabel labelConfirmPassword = new JLabel("Confirm Password:"); // Label konfirmasi password
        labelConfirmPassword.setBounds(20, 370, 150, 30); // Mengatur posisi dan ukuran label

        JPasswordField confirmPasswordField = new JPasswordField(); // Field input konfirmasi password
        confirmPasswordField.setBounds(180, 370, 150, 30); // Mengatur posisi dan ukuran confirm password field

        //JTextArea utk output
        JTextArea textFieldOutput = new JTextArea(); // Text area untuk output
        textFieldOutput.setBounds(20, 410, 400, 200); // Mengatur posisi dan ukuran text area
        textFieldOutput.setEditable(false); // Output tidak dapat diedit

        //tombol Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(180, 620, 150, 30); // Mengatur posisi dan ukuran tombol

        // ActionListener untuk tombol Simpan
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil data dari input
                String nama = textFieldNama.getText(); // ambil text dari textFieldNama
                String telp = textFieldTelp.getText(); // ambil teks dari textFieldTelp
                String jenisKelamin = radioButtonLK.isSelected() ? "Laki-Laki" : "Perempuan"; // Mendapatkan pilihan jenis kelamin
                String wna = checkBoxWNA.isSelected() ? "Iya" : "Tidak"; // Mendapatkan status WNA
                String jenisTabungan = listTabungan.getSelectedValue(); // Mendapatkan pilihan jenis tabungan
                int frekuensiTransaksi = (Integer) spinnerFrekuensi.getValue(); // Mendapatkan nilai frekuensi transaksi
                String tanggalLahir = dateEditor.getFormat().format(spinnerTanggalLahir.getValue()); // Mendapatkan tanggal lahir
                String password = new String(passwordField.getPassword()); // Mendapatkan password sebagai String
                String confirmPassword = new String(confirmPasswordField.getPassword()); // Mendapatkan confirm password

                // Validasi password
                String passwordStatus = password.equals(confirmPassword) ? "Password cocok" : "Password tidak cocok"; //password check

                //output pada TextArea
                textFieldOutput.setText("Nama: " + nama + "\n"
                                      + "Nomor HP: " + telp + "\n"
                                      + "Jenis Kelamin: " + jenisKelamin + "\n"
                                      + "WNA: " + wna + "\n"
                                      + "Jenis Tabungan: " + jenisTabungan + "\n"
                                      + "Frekuensi Transaksi per Bulan: " + frekuensiTransaksi + "\n"
                                      + "Tanggal Lahir: " + tanggalLahir + "\n"
                                      + passwordStatus); // Menampilkan hasil input pada textFieldOutput
            }
        });

        //menu bar
        JMenuBar menuBar = new JMenuBar(); // Menu bar utama
        
        // Membuat menu
        JMenu menu = new JMenu("Menu"); // Membuat menu "Menu"

        //Reset
        JMenuItem resetMenu = new JMenuItem("Reset"); // Membuat item "Reset"
        resetMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menghapus semua inputan dan output
                textFieldNama.setText(""); // Mengosongkan textFieldNama
                textFieldTelp.setText(""); // Mengosongkan textFieldTelp
                bg.clearSelection(); // Menghapus pilihan radio button
                checkBoxWNA.setSelected(false); // Mengosongkan checkbox WNA
                listTabungan.clearSelection(); // Menghapus pilihan JList
                spinnerFrekuensi.setValue(1); // Mereset spinner frekuensi ke 1
                spinnerTanggalLahir.setValue(Calendar.getInstance().getTime()); // Mereset spinner tanggal lahir ke tanggal sekarang
                passwordField.setText(""); // Mengosongkan password field
                confirmPasswordField.setText(""); // Mengosongkan confirm password field
                textFieldOutput.setText(""); // Mengosongkan text area output
            }
        });

        // Menu Item untuk Exit
        JMenuItem exitMenu = new JMenuItem("Exit"); // Membuat item "Exit"
        exitMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Keluar dari aplikasi
                System.exit(0); // Keluar dari program
            }
        });

        // Menambahkan menu item ke menu
        menu.add(resetMenu); // Menambahkan item reset ke menu
        menu.add(exitMenu); // Menambahkan item exit ke menu

        // Menambahkan menu ke menu bar
        menuBar.add(menu); // Menambahkan menu ke menu bar
        
        // Menambahkan menu bar ke frame
        this.setJMenuBar(menuBar); // Mengatur menu bar di JFrame

        //add smua fungsi ke JFrame
        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputTelp);
        this.add(textFieldTelp);
        this.add(labelRadio);
        this.add(radioButtonLK);
        this.add(radioButtonPR);
        this.add(checkBoxWNA);
        this.add(labelJenisTabungan);
        this.add(listTabungan);
        this.add(labelFrekuensi);
        this.add(spinnerFrekuensi);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(buttonSimpan);
        this.add(textFieldOutput);

        // Pengaturan JFrame
        this.setSize(500, 750); // Mengatur ukuran frame
        this.setLayout(null); //Null agar manual positioning
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas2 frame = new Tugas2();
                frame.setVisible(true); // Menampilkan frame
            }
        });
    }
}
