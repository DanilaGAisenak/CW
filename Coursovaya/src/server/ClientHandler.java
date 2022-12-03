package server;

import com.mysql.cj.protocol.Resultset;

import java.io.*;
import java.net.Socket;
import java.sql.*;
public class ClientHandler implements Runnable{
    private static Socket clientSocket;
    //private static DataInputStream is;
    //private static DataOutputStream os;
    private static ObjectInputStream ois;
    private static  ObjectOutputStream oos;
    private static Connection connection;
    private static ResultSet rs;
    private static Statement stmt;

    public ClientHandler(Socket client, Connection connection,
                         ObjectOutputStream oos, ObjectInputStream ois) {
        this.clientSocket = client;
        //this.is = is;
        //this.os = os;
        this.connection = connection;
        this.oos = oos;
        this.ois = ois;
        try {
            stmt = connection.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            String line; Integer num = 0;
            while (true/*(line=ois.readUTF())!=null*/) {
                System.out.println("Ожидание");
                line=ois.readUTF();
                //System.out.println(line);
                num = Integer.parseInt(line);
                System.out.println(num);
                switch (num) {
                    case 1/*Вход*/: {
                       line = ois.readUTF();
                       System.out.println("Sent from client " + line);
                       String val[] = line.split(" ");
                       String query = "select count(*) from users";
                       rs = stmt.executeQuery(query);
                       int number = 0;
                       while (rs.next()) {
                           number = rs.getInt(1);
                       }
                       query = "SELECT * FROM users";
                       rs = stmt.executeQuery(query);
                       int j = 0;
                       Integer result = 0;
                       int[] id = new int[number];
                       String[] login = new String[number];
                       String[] pass = new String[number];
                       while (rs.next()) {
                           id[j] = rs.getInt(1);
                           login[j] = rs.getString(2);
                           pass[j] = rs.getString(3);
                           j++;
                       }
                       for (int i = 0; i < login.length; i++) {
                           System.out.println(id[i] + " " + login[i] + " " + pass[i]);
                       }
                       int counter = 0;
                       for (int i = 0; i < login.length; i++) {
                           if (login[i].equals(val[0])) {
                               if (pass[i].equals(val[1])) {
                                   result = 1;
                                   System.out.println(result.toString());
                                   oos.writeUTF(result.toString());
                                   oos.flush();
                                   if (id[i] == 1) {
                                       oos.writeUTF("A");
                                       oos.flush();
                                       i = login.length;
                                       break;
                                   } else {
                                       oos.writeUTF("U");
                                       oos.flush();
                                   }
                               }
                           } else {
                               counter++;
                               //System.out.println(result.toString());
                               //os.writeUTF("0");
                               //os.flush();
                           }
                           if (counter == login.length - 1) {
                               oos.writeUTF(result.toString());
                               oos.flush();
                           }
                       }
                        System.out.println("Конец 1");
                    }break;
                    case 2:/*Регистрация*/ {
                        while((line= ois.readUTF())!=null) {
                            System.out.println("Sent from client " + line);
                            String val[] = line.split(" ");
                            String query = "INSERT Users(Логин, Пароль) VALUES (?,?)";
                            PreparedStatement statement = connection.prepareStatement(query);
                            statement.setString(1, val[0]);
                            statement.setString(2, val[1]);
                            statement.execute();
                            oos.writeUTF("Command proceeded");
                            oos.flush();
                            break;
                        }
                        System.out.println("Конец 2");
                    }break;
                    case 3/*Данные в таблицу*/:{
                        String query = "select count(*) from users";
                        rs = stmt.executeQuery(query);
                        Integer number = 0;
                        while (rs.next()) {
                            number = rs.getInt(1);
                        }
                        oos.writeObject(number);
                        oos.flush();
                        query = "select * from users";
                        rs = stmt.executeQuery(query);
                        User user = new User(rs);
                        oos.writeObject((User)user);
                        System.out.println("Конец 3");
                    }break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                stmt.close();
                if (oos != null){
                    oos.close();
                }
                if (ois != null){
                    ois.close();
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
