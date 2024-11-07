// package Pertemuan7.Membership.src.view.jenismember;

// import java.awt.event.*;
// import javax.swing.*;
// import javax.swing.table.*;
// import java.util.List;
// import Pertemuan7.Membership.src.model.*;
// import Pertemuan7.Membership.src.dao.JenisMemberDao;

// public class JenisMemberFrame extends JFrame{
//     private List<JenisMember> jenismemberList;
//     private JTextField JTextFieldNama;
//     private JenisMemberTableModel tableModel;
//     private JenisMemberDao jenisMemberDao;

//     public JenisMemberFrame(JenisMemberDao jenisMemberDao){
//         this.jenisMemberDao = jenisMemberDao;
//         this.jenisMemberList = jenisMemberDao.findAll();
//         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         JLabel labelInput = new JLabel("nama");
//         labelInput.setBounds(15,40,350,10);

//         textFieldNama = new JTextField();
//         textFieldNama.setBounds(15, 60, 350, 30);

//         JButton button = new JButton("Simpan");
//         button.setBounds(15,100,100,40);

//         javax.swing.JTable table = new JTable();
//         JScrollPane scrollabScrollTable  = new JScrollPane(table);
//         scrollabScrollTable.setBounds(15,150,350,200);

//         tableModel = new JenisMemberTableModel(jenisMemberList);
//         table.setModel(tableModel);

//         JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);

//         button.addActionListener(actionListener);

//         this.add(button);
//         this.add(textFieldNama);
//         this.add(labelInput);
//         this.add(scrollabScrollTable);

//         this.setSize(400,500);
//         this.setLayout(null);
//     }

//     public String getNama(){
//         return textFieldNama.getText();
//     }

//     public void addJenisMember(JenisMember jenisMember){
//         tableModel.add(jenisMember);
//         textFieldNama.setText(" ");
//     }
// }


package Pertemuan7.Membership.src.view.jenismember;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List; // Added import for List
import Pertemuan7.Membership.src.model.*;
import Pertemuan7.Membership.src.dao.JenisMemberDao;

public class JenisMemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private JTextField textFieldNama; // Fixed variable name to match the declaration below
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 20, 350, 10);

        textFieldNama = new JTextField(); // Corrected "JTextFieldNama" to "textFieldNama"
        textFieldNama.setBounds(15, 40, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 80, 100, 40);

        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table); // Fixed typo in variable name
        scrollableTable.setBounds(15, 130, 350, 200);

        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);

        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);
        button.addActionListener(actionListener);

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        this.setSize(400, 400);
        this.setLayout(null);
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}
