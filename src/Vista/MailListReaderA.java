/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Entrar
 */
public class MailListReaderA {
    public static ArrayList<String> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        ArrayList<String> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:Kata.sDB");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT mail FROM MAIL");
        while(rs.next()){
            String mail = rs.getString("mail");
            if(!mail.contains("@")) continue;
            mailList.add(mail);
        }
        rs.close();
        statement.close();
        connection.close();
        return mailList;
    }   
}
