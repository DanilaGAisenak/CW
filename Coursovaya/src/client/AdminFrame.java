package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminFrame extends JFrame implements ActionListener, WindowListener {
    private JPanel panel;
    private UsersTableModel utm = new UsersTableModel();
    private JScrollPane scroll;
    private JPanel ePanel;
    private JTable admTable;
    private JButton edit;
    private JButton delete;
    private JButton register;
    private JButton software;
    private JButton hardware;
    private JButton licences;

    private String[] columnNames = {
      "idПользователя",
      "Логин",
      "Пароль"
    };

    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    private server.User user;
    private ArrayList<Integer> id;
    private ArrayList<String> login;
    private ArrayList<String> pass;
    private Integer number;
    private int regId;
    private String regLog;
    private String regPas;
    public AdminFrame(JPanel epanel, ObjectOutputStream oos, ObjectInputStream ois,server.User user, Integer num){
        this.ePanel = epanel;
        this.oos = oos;
        this.ois = ois;
        this.id = user.getId();
        this.login = user.getLogin();
        this.pass = user.getPassword();
        this.number = num;

        setTitle("Администратор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(200, 0);
        setSize(1200, 800);
        addWindowStateListener(this::windowOpened);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        for (int i = 0; i < number; i++){
            String[] row = new String[3];
            row[0] = id.get(i).toString();
            row[1] = login.get(i);
            row[2] = pass.get(i);
            utm.addData(row);
        }
        admTable = new JTable(utm);
        admTable.setSize(300, 600);
        scroll = new JScrollPane(admTable);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll, BorderLayout.LINE_END);

        register = new JButton("Добавить пользователя");
        register.setSize(80,25);
        register.addActionListener(this::actionPerformed);
        panel.add(register, BorderLayout.CENTER);

        setContentPane(panel);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RegisterDialog rd = new RegisterDialog(panel, ois, oos);
        String log = rd.getLoginRegister();
        String pas = rd.getPasswordRegister();
        number++;
        String[] row = {
                number.toString(),
                log,
                pas
        };
        utm.addData(row);
        admTable = new JTable(utm);
        scroll = new JScrollPane(admTable);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll, BorderLayout.LINE_END);

        setContentPane(panel);
        //Integer numReg = 3;
        //try {
        //    oos.writeUTF(numReg.toString());
        //    oos.flush();
        //    Integer num1 = 0;
        //    num1 = (Integer) ois.readObject();
        //    this.user = (server.User) ois.readObject();
        //    this.id = this.user.getId();
        //    this.login = this.user.getLogin();
        //    this.pass = this.user.getPassword();
        //    String[] row = new String[3];
        //    row[0] = id.get(num1-1).toString();
        //    row[1] = login.get(num1-1);
        //    row[2] = pass.get(num1-1);
        //    utm.addData(row);
        //    admTable.repaint();
        //} catch (IOException ex) {
        //    ex.printStackTrace();
        //} catch (ClassNotFoundException ex) {
        //    ex.printStackTrace();
        //}
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
