// package Pertemuan7.Membership.src.view.member;

// import javax.swing.*;
// import javax.swing.table.AbstractTableModel;

// import java.util.List;
// import Pertemuan7.Membership.src.model.Member;

// public class MemberTableModel extends AbstractTableModel{
//     private String[] columnNames = {"Nama", "Jenis Member"};
//     private List<Member> data;

//     public MemberTableModel(List<Member> data){
//         this.data = data;
//     }

//     public int getColumnCount(){
//         return columnNames.length;
//     }

//     public int getRowount(){
//         return data.size();
//     }

//     public String getColumnName(){
//         return columnNames[col];
//     }

//     public Object getValueAt(int row, int col){
//         Member rowItem = data.get(row);
//         String value = "";
//         switch (col)
//         {
//             case 0:
//                 value = rowItem.getNama();
//                 break;
//             case 1:
//             value = rowItem.getJenisMember().getNama();
//             break;
//         }
//         return value;
//     }

//     public boolean isCellEditable(int row , int col){
//     return false;
//     }

//     public void add(Member value){
//         data.add(value);
//         fireTableRowsInserted(data.size() -1,  data.size() -1);

//     }

// }

package Pertemuan7.Membership.src.view.member;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import Pertemuan7.Membership.src.model.Member;

public class MemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Jenis Member"};
    private List<Member> data;

    public MemberTableModel(List<Member> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() { // Fixed typo here
        return data.size();
    }

    @Override
    public String getColumnName(int col) { // Added 'int col' parameter
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Member rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getJenisMember().getNama();
                break;
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
