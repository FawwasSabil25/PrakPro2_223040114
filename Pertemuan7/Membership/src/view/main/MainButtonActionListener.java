package Pertemuan7.Membership.src.view.main;

import java.awt.event.*;

public class MainButtonActionListener implements ActionListener{
    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mainFrame.getButtonjenisMember()){
            mainFrame.showJenisMemberFrame();
        }else{
            mainFrame.showMemberFrame();
        }
    }
}
