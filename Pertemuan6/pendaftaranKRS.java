import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pendaftaranKRS extends JFrame {
    private JTextField nama;
    private JTextArea alamat;
    private JRadioButton lkButton, prButton;
    private JComboBox<String> jurusan;
    private JList<String> mataKuliah;
    private JSlider umurSlider;
    private JSpinner semesterSpinner;
    private JCheckBox setujuCheckBox;
    private JTable dataMahasiswaTable;
    private DefaultTableModel tableModel;
    private ButtonGroup genderGroup;

    public pendaftaranKRS() {
        setTitle("Formulir Pendaftaran Mahasiswa");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar = berisi menu reset dan 
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset Form");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding untuk tiap komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama:"), gbc);

        gbc.gridx = 1;
        nama = new JTextField(20);
        formPanel.add(nama, gbc);

        // Alamat
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Alamat:"), gbc);

        gbc.gridx = 1;
        alamat = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(alamat), gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Jenis Kelamin:"), gbc);

        gbc.gridx = 1;
        lkButton = new JRadioButton("Laki-laki");
        prButton = new JRadioButton("Perempuan");
        genderGroup = new ButtonGroup();
        genderGroup.add(lkButton);
        genderGroup.add(prButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(lkButton);
        genderPanel.add(prButton);
        formPanel.add(genderPanel, gbc);

        // Jurusan
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Jurusan:"), gbc);

        gbc.gridx = 1;
        jurusan = new JComboBox<>(new String[]{"Teknik Informatika", "Sistem Informasi", "Teknik Elektro"});
        formPanel.add(jurusan, gbc);

        // Mata Kuliah
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Mata Kuliah:"), gbc);

        gbc.gridx = 1;
        mataKuliah = new JList<>(new String[]{"Matematika", "Pemrograman", "Basis Data", "Jaringan Komputer"});
        formPanel.add(new JScrollPane(mataKuliah), gbc);

        // Umur
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Umur:"), gbc);

        gbc.gridx = 1;
        umurSlider = new JSlider(17, 30, 20);
        umurSlider.setMajorTickSpacing(5);
        umurSlider.setMinorTickSpacing(1);
        umurSlider.setPaintTicks(true);
        umurSlider.setPaintLabels(true);
        formPanel.add(umurSlider, gbc);

        // Semester
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(new JLabel("Semester:"), gbc);

        gbc.gridx = 1;
        semesterSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 8, 1));
        formPanel.add(semesterSpinner, gbc);

        // Persetujuan
        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(new JLabel("Persetujuan:"), gbc);

        gbc.gridx = 1;
        setujuCheckBox = new JCheckBox("Saya Yakin Mendaftar");
        formPanel.add(setujuCheckBox, gbc);

        // Button Daftar
        gbc.gridx = 1;
        gbc.gridy = 8;
        JButton daftarButton = new JButton("Daftar");
        formPanel.add(daftarButton, gbc);

        // Table Panel
        String[] columnNames = {"Nama", "Alamat", "Gender", "Jurusan", "Mata Kuliah", "Umur", "Semester"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataMahasiswaTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(dataMahasiswaTable);

        // Action Listeners
        daftarButton.addActionListener(new SubmitButtonListener());
        resetMenuItem.addActionListener(e -> resetForm());
        exitMenuItem.addActionListener(e -> System.exit(0));

        // Main Layout
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.CENTER);
        add(tableScrollPane, BorderLayout.SOUTH);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (setujuCheckBox.isSelected()) {
                String namaMahasiswa = nama.getText();
                String alamatMahasiswa = alamat.getText();
                String gender = lkButton.isSelected() ? "Laki-laki" : "Perempuan";
                String jurusanMahasiswa = (String) jurusan.getSelectedItem();
                String mataKuliahTerpilih = String.join(", ", mataKuliah.getSelectedValuesList());
                int umur = umurSlider.getValue();
                int semester = (int) semesterSpinner.getValue();

                // Tambahkan data ke tabel
                tableModel.addRow(new Object[]{
                    namaMahasiswa, alamatMahasiswa, gender, jurusanMahasiswa, mataKuliahTerpilih, umur, semester
                });

                resetForm(); //form kososng setelah submit
            } else {
                JOptionPane.showMessageDialog(null, "Harap setujui syarat dan ketentuan.");
            }
        }
    }

    // Fungsi mereset form
    private void resetForm() {
        nama.setText("");
        alamat.setText("");
        genderGroup.clearSelection();
        jurusan.setSelectedIndex(0);
        mataKuliah.clearSelection();
        umurSlider.setValue(20);
        semesterSpinner.setValue(1);
        setujuCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new pendaftaranKRS().setVisible(true));
    }
}
