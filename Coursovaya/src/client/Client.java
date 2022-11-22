package client;

//import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Scanner;

public class Client {
    private boolean enter = false;
    private ResultSet rs = null;
    public static void main(String[] args) {
        DataInputStream is = null;
        DataOutputStream os = null;
        Socket sock = null;
        int choice = 0;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try{
            sock = new Socket("localhost", 1024);
            is = new DataInputStream(sock.getInputStream());
            os = new DataOutputStream(sock.getOutputStream());
            SignIn first = new SignIn();

            //while (choice != 3){
            //    System.out.println("1. Регистрация пользователя\n"
            //    +"2. Вход\n"
            //    +"3. Выход\n>> ");
            //    String ch = sc.readLine();
            //    choice = Integer.parseInt(ch);
            //    switch (choice){
            //        case 1: {
            //            String log = new String();
            //            String pass = new String();
            //            String res = new String();
            //            System.out.println("Введите логин: ");
            //            log = sc.readLine();
            //            System.out.println("Введите пароль: ");
            //            pass = sc.readLine();
            //            res = log + " " + pass;
            //            os.writeUTF(res);
            //        } break;
            //        case 2: {} break;
            //        case 3: break;
            //        default:
            //            System.out.println("Введите число от 1 до 3");
            //    }
            //}
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
