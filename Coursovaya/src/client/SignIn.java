package client;

import com.mysql.cj.x.protobuf.MysqlxExpr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

public class SignIn extends JFrame implements ActionListener, WindowListener {
    private JTextField passwordSignIn;
    private JButton sendSignIn;
    private JButton registerSignIn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField loginSignIn;
    private JPanel panel;
    private Socket sock;
    private int flag = 0;
    //private DataInputStream is = null;
    //private DataOutputStream os = null;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    private int [] id;
    private String[] login;
    private String[] password;

    public SignIn(Socket sock, ObjectOutputStream oos, ObjectInputStream ois){
        this.sock = sock;
        //this.is = is;
        //this.os = os;
        this.ois = ois;
        this.oos = oos;
        setTitle("����");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(510,210);
        //setLocationRelativeTo(null);
        setSize(500,400);
        panel = new JPanel();
        panel.setLayout(null);

        passwordSignIn = new JTextField();
        passwordSignIn.setSize(200, 40);
        passwordSignIn.setLocation(150, 160);
        passwordSignIn.setVisible(true);
        panel.add(passwordSignIn);
        loginSignIn = new JTextField();
        loginSignIn.setSize(200, 40);
        loginSignIn.setLocation(150, 80);
        loginSignIn.setVisible(true);
        panel.add(loginSignIn);

        jLabel1 = new JLabel("�����");
        jLabel1.setLocation(150, 50);
        jLabel1.setSize(50,20);
        jLabel1.setVisible(true);
        panel.add(jLabel1);
        jLabel2 = new JLabel("������");
        jLabel2.setSize(50, 20);
        jLabel2.setLocation(150, 130);
        jLabel2.setVisible(true);
        panel.add(jLabel2);

        sendSignIn = new JButton("�����");
        sendSignIn.setSize(120, 40);
        sendSignIn.setLocation(190, 220);
        sendSignIn.addActionListener(this::actionPerformed);
        sendSignIn.setVisible(true);
        panel.add(sendSignIn);
        registerSignIn = new JButton("�����������");
        registerSignIn.setSize(120, 40);
        registerSignIn.setLocation(190, 270);
        registerSignIn.addActionListener(this::actionRegPerfomed);
        registerSignIn.setVisible(true);
        panel.add(registerSignIn);

        setContentPane(panel);
        setVisible(true);
    }

    public void actionRegPerfomed(ActionEvent e){
        RegisterDialog rd = new RegisterDialog(panel, ois, oos);
        panel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!loginSignIn.getText().isEmpty() & !passwordSignIn.getText().isEmpty()) {
            try {
                //if (flag==0) {
                    Integer num = 1;
                    oos.writeUTF(num.toString());
                    oos.flush();
                    flag++;
                //}
                String log = new String();
                String pas = new String();
                String res = new String();
                log = loginSignIn.getText();
                pas = passwordSignIn.getText();
                res = log + " " + pas;
                oos.writeUTF(res);
                oos.flush();
                loginSignIn.setText("");
                passwordSignIn.setText("");
                String line = ois.readUTF();
                System.out.println(line);
                if (Integer.parseInt(line) == (Integer)1) {
                    System.out.println("here");
                    line = ois.readUTF();
                    System.out.println(line);
                    if (line.equals("A")){
                        Integer number = 0;
                        num = 3;
                        oos.writeUTF(num.toString());
                        oos.flush();
                        ResultSet rs = null;
                        Integer num1 = 0;
                        num1 = (Integer) ois.readObject();
                        System.out.println(num1);
                        server.User user = (server.User) ois.readObject();
                        AdminFrame af = new AdminFrame(panel, oos, ois, user, num1);
                        af.setVisible(true);
                    }
                } else {
                    WarningDialog wd = new WarningDialog(panel);
                    wd.setVisible(true);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try{
            sock.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
