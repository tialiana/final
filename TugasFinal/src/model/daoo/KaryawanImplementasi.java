/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.daoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dbs.Karyawan;
import model.dbs.KoneksiDb;

/**
 *
 * @author User
 */
public class KaryawanImplementasi implements KaryawanInterface {

    @Override
    public Karyawan create(Karyawan kyw) throws SQLException {
        PreparedStatement st = KoneksiDb.getKoneksi().prepareStatement("insert into karyawan values (?,?,?,?)");
        st.setString(1, kyw.getId());
        st.setString(2, kyw.getNama());
        st.setString(3, kyw.getPosisi());
        st.setString(4, kyw.getEmail());
        st.executeUpdate();

        return kyw;
    }

    @Override
    public void update(Karyawan kyw) throws SQLException {
        PreparedStatement st = KoneksiDb.getKoneksi().prepareStatement("update karyawan set nama=?, posisi=?, email=? where id=?");
        st.setString(4, kyw.getId());
        st.setString(1, kyw.getNama());
        st.setString(2, kyw.getPosisi());
        st.setString(3, kyw.getEmail());
        st.executeUpdate();
    
    }

    @Override
    public void delete(String id) throws SQLException {
        PreparedStatement st = KoneksiDb.getKoneksi().prepareStatement("delete from karyawan where id=?");
        st.setString(1, id);
        st.executeUpdate();
    
    }

    @Override
    public List retriveData() throws SQLException {
       Statement st = KoneksiDb.getKoneksi().createStatement();
       ResultSet rs = st.executeQuery("select * from karyawan");
       List list = new ArrayList();
       while (rs.next()){
                Karyawan kry = new Karyawan();
                kry.setId(rs.getString("id"));
                kry.setNama(rs.getString("nama"));
                kry.setPosisi(rs.getString("posisi"));
                kry.setEmail(rs.getString("email"));
                list.add(kry);
       }
       return list;
    }
    
}
