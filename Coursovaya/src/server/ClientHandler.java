package server;

import java.io.*;
import java.net.Socket;
import java.sql.*;
public class ClientHandler implements Runnable{
    private static Socket clientSocket;
    private static DataInputStream is;
    private static DataOutputStream os;
    private static Connection connection;

    public ClientHandler(Socket client, DataInputStream is, DataOutputStream os, Connection connection) {
        this.clientSocket = client;
        this.is = is;
        this.os = os;
        this.connection = connection;
    }

    @Override
    public void run() {
        try{
            String line;
            while((line=is.readUTF())!=null){
                System.out.println("Sent from client "+line);
                String val[] = line.split(" ");
                String query = "INSERT Users(Логин, Пароль) VALUES (?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, val[0]);
                statement.setString(2, val[1]);
                statement.execute();

                os.writeUTF("Command proceeded");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (os != null){
                    os.close();
                }
                if (is != null){
                    is.close();
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
