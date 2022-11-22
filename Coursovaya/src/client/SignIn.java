package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SignIn extends JFrame implements ActionListener, WindowListener {
    private JTextField passwordSignIn;
    private JButton sendSignIn;
    private JButton registerSignIn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField loginSignIn;
    private JPanel panel;

    public SignIn(){
        setTitle("Вход");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500,400);
        panel = new JPanel();
        panel.setLayout(null);

        passwordSignIn = new JTextField();
        //PasswordSignIn.setBounds(200, 250, 100, 40);
        passwordSignIn.setSize(200, 40);
        passwordSignIn.setLocation(150, 160);
        passwordSignIn.setVisible(true);
        panel.add(passwordSignIn);
        loginSignIn = new JTextField();
        //loginSignIn.setBounds(200, 100, 100, 40);
        loginSignIn.setSize(200, 40);
        loginSignIn.setLocation(150, 80);
        loginSignIn.setVisible(true);
        panel.add(loginSignIn);

        jLabel1 = new JLabel("Логин");
        //jLabel1.setBounds(200, 70, 50, 20);
        jLabel1.setLocation(150, 50);
        jLabel1.setSize(50,20);
        jLabel1.setVisible(true);
        panel.add(jLabel1);
        jLabel2 = new JLabel("Пароль");
        //jLabel2.setBounds(200, 220, 50, 20);
        jLabel2.setSize(50, 20);
        jLabel2.setLocation(150, 130);
        jLabel2.setVisible(true);
        panel.add(jLabel2);

        sendSignIn = new JButton("Войти");
        //sendSignIn.setBounds(250, 280, 65, 20);
        sendSignIn.setSize(120, 40);
        sendSignIn.setLocation(190, 220);
        sendSignIn.setVisible(true);
        panel.add(sendSignIn);
        registerSignIn = new JButton("Регистрация");
        //registerSignIn.setBounds(250, 310, 65, 20);
        registerSignIn.setSize(120, 40);
        registerSignIn.setLocation(190, 270);
        registerSignIn.setVisible(true);
        panel.add(registerSignIn);

        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
