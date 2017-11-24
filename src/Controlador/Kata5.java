/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Histogram;
import Vista.HistogramDisplay;
import Vista.MailHistogramBuilder;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import Vista.MailListReaderA;
import java.io.FileNotFoundException;
public class Kata5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, Exception {
        Kata5 kata = new Kata5();
        kata.input();
    }   
    private void input() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        ArrayList<String> mailArray = MailListReaderA.read();
        Histogram<String> histogram = MailHistogramBuilder.build(mailArray);
        new HistogramDisplay(histogram).execute(); 
    }
}