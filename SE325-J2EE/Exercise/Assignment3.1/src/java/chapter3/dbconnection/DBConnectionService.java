/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import javax.naming.InitialContext;

/**
 *
 * @author mirushi
 */
public class DBConnectionService {
    
    protected static void LoadJDBCDriver() throws Exception {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            throw new Exception("SQL JDBC Driver not found ...");
        }
    }
    
    public static Connection getConnection () throws Exception {
        Connection connect = null;
        if (connect == null){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_chapter3?allowPublicKeyRetrieval=true&useSSL=false", "root", "123654");
            }catch (Exception e){
                throw new Exception ("Cannot access to DB Server ... " + e.getMessage());
            }
        }
        return connect;
    }
}
