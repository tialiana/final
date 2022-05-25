/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.daoo;

import java.sql.SQLException;
import java.util.List;
import model.dbs.Karyawan;

/**
 *
 * @author User
 */
public interface KaryawanInterface {
    public Karyawan create(Karyawan kyw) throws SQLException;
    public void update(Karyawan kyw)throws SQLException;
    public void delete(String id)throws SQLException;
    public List retriveData()throws SQLException;
}
