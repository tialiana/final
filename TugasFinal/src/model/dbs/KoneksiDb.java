/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class KoneksiDb {
    private static Connection koneksi;

    public static Connection getKoneksi() {

        try {
            if (koneksi == null ){
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbinternship", "root", "");
            }
            System.out.println("terkoneksi");
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koneksi;
    }

    public static void main(String[] args) {
        getKoneksi();
    }
}
