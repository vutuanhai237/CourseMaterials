/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3.mapper;

import chapter3.dbconnection.DBConnectionService;
import java.sql.Connection;

/**
 *
 * @author mirushi
 */
public class DBMapper {
    
    private Connection connection;
    
    public DBMapper() throws Exception {
        try{
            connection = DBConnectionService.getConnection();
        }catch (Exception ex){
            System.out.println("Constructor DBMapper has encountered exception");
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public DBMapper(Connection con){
        connection = con;
    }
    
    public void closeConnection() throws Exception {
        try{
            getConnection().close();
        }catch (Exception ex){
            System.out.println("closeConnection in DBMapper has encountered exception");
            throw ex;
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
}
