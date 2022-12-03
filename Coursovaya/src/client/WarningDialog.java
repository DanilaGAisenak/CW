package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WarningDialog extends JFrame implements ActionListener {

    private JPanel panel;
    private JPanel panel1;
    private JButton btn;
    private JLabel la;

    public WarningDialog(JPanel ePanel) {
        this.panel1 = ePanel;
        setTitle("Внимание");
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(350,200);
        panel = new JPanel();
        panel.setLayout(null);

        btn = new JButton("OK");
        btn.setLocation(125, 100);
        btn.setSize(100, 25);
        btn.addActionListener(this::actionPerformed);
        btn.setVisible(true);
        panel.add(btn);

        la = new JLabel("Логин или пароль введены неверно");
        la.setLocation(50, 60);
        la.setSize(250, 20);
        la.setVisible(true);
        panel.add(la);

        setContentPane(panel);
        setVisible(true);
    }
    public WarningDialog(JPanel epanel, String str){
        this.panel1 = epanel;
        setTitle("Внимание");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(350,200);
        panel = new JPanel();
        panel.setLayout(null);

        btn = new JButton("OK");
        btn.setLocation(125, 100);
        btn.setSize(100, 25);
        btn.addActionListener(this::actionPerformed);
        btn.setVisible(true);
        panel.add(btn);

        la = new JLabel(str);
        la.setLocation(50, 60);
        la.setSize(250, 20);
        la.setVisible(true);
        panel.add(la);

        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel1.setVisible(true);
        this.dispose();
    }

    //@Override
    //public void windowOpened(WindowEvent e) {}
//
    //@Override
    //public void windowClosing(WindowEvent e) {
    //    //panel.setVisible(false);
    //    //panel1.setVisible(true);
    //    //this.dispose();
    //}
//
    //@Override
    //public void windowClosed(WindowEvent e) {
    //    panel1.setVisible(true);
    //}
//
    //@Override
    //public void windowIconified(WindowEvent e) {}
//
    //@Override
    //public void windowDeiconified(WindowEvent e) {}
//
    //@Override
    //public void windowActivated(WindowEvent e) {}
//
    //@Override
    //public void windowDeactivated(WindowEvent e) {}
}
