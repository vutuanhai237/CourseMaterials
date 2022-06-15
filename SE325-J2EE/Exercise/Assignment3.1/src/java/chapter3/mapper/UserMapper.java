/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3.mapper;

import chapter3.dto.UserDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author mirushi
 */
public class UserMapper extends DBMapper {
    
    public UserMapper() throws Exception {
        super();
    }
    
    public Boolean checkLoginExist (String username, String password){
        Boolean exist = false;
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "SELECT 1 FROM jee_chapter3.USER_ACCOUNT WHERE username = " + username + " AND pass = " + password;
            ResultSet rs = stmt.executeQuery(sqlStr);
            
            int count = 0;
            while (rs != null && rs.next()){
                ++count;
            }
            
            if (count > 0)
                exist = true;
            else
                exist = false;
        }catch (Exception ex){
            ex.printStackTrace();
            exist = false;
        }
        return exist;
    }
    
    public Boolean createAccountForUser (String username, String password, String firstname, String lastname, String sex, String address, String email, String mobilePhone){
        Boolean success = false;
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "INSERT INTO USER_ACCOUNT VALUES (null, " + username + ", " + password + ", " + firstname + ", " + lastname + ", " + sex + ", " + address + ", " + email + ", " + mobilePhone + ", USER)";
            int count = stmt.executeUpdate(sqlStr);
            if (count > 0)
                success = true;
            else
                success = false;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return success;
    }
    
    public Integer getUserIDFromUsername (String username) {
        Integer userID = -1;
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "SELECT id FROM USER_ACCOUNT WHERE username = " + username;
            ResultSet rs = stmt.executeQuery(sqlStr);
            int count = 0;
            while (rs != null && rs.next()){
                userID = rs.getInt("id");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return userID;
    }
    
    public Boolean updateAccountForUser (Integer id, String username, String password, String firstname, String lastname, String sex, String address, String email, String mobilePhone){
        Boolean success = false;
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "UPDATE USER_ACCOUNT SET username = " + username + ", pass = " + password + ", firstname = " + firstname + ", lastname = " + lastname + ", sex = " + sex + ", address = " + address + ", email = " + email + ", mobile = " + mobilePhone + "WHERE id = " + id.toString();
            int count = stmt.executeUpdate(sqlStr);
            if (count > 0)
                success = true;
            else
                success = false;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return success;
    }
    
    public Boolean deleteAccountForUser (Integer id){
        Boolean success = false;
        
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "DELETE FROM USER_ACCOUNT WHERE id = " + id.toString();
            int count = stmt.executeUpdate(sqlStr);
            if (count > 0)
                success = true;
            else
                success = false;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return success;
    }
    
    public ArrayList<UserDTO> getAllUsers () {
        ArrayList<UserDTO> users = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "SELECT * FROM USER_ACCOUNT";
            ResultSet rs = stmt.executeQuery(sqlStr);
            int count = 0;
            while (rs != null && rs.next()){
                UserDTO user = new UserDTO();
                user.setId(rs.getInt("id"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setFirstname(rs.getString("firstname"));
                user.setGroupname(rs.getString("groupname"));
                user.setLastname(rs.getString("lastname"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("pass"));
                user.setSex("sex");
                user.setUsername("username");
                users.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return users;
    }
    
    public UserDTO getUserByID (Integer ID){
        UserDTO user = null;
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "SELECT * FROM USER_ACCOUNT WHERE id = " + ID;
            ResultSet rs = stmt.executeQuery(sqlStr);
            int count = 0;
            while (rs != null && rs.next()){
                user = new UserDTO();
                user.setId(rs.getInt("id"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setFirstname(rs.getString("firstname"));
                user.setGroupname(rs.getString("groupname"));
                user.setLastname(rs.getString("lastname"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("pass"));
                user.setSex("sex");
                user.setUsername("username");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return user;
    }
    
    public ArrayList<UserDTO> searchUsers (String username, String usergroup, String firstname, String lastname, String sex, String email, String address, String mobile) {
        ArrayList<UserDTO> users = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            String sqlStr = "SELECT * FROM USER_ACCOUNT ";
            
            int count = 0;
            
            if (username != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "USERNAME = " + username;
                ++count;
            }
            
            if (usergroup != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "USERGROUP = " + usergroup;
                ++count;
            }
                
            if (firstname != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "FIRSTNAME = " + firstname;
                ++count;
            }
            
            if (lastname != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "LASTNAME = " + lastname;
                ++count;
            }
            
            if (sex != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "SEX = " + sex;
                ++count;
            }
            
            if (email != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "EMAIL = " + email;
                ++count;
            }
            
            if (address != null) {
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "ADDRESS = " + address;
                ++count;
            }
            
            if (mobile != null){
                if (count == 0)
                    sqlStr += " WHERE ";
                else
                    sqlStr += " AND ";
                sqlStr += "MOBILE = " + mobile;
                ++count;
            }
            
            ResultSet rs = stmt.executeQuery(sqlStr);
            count = 0;
            while (rs != null && rs.next()){
                UserDTO user = new UserDTO();
                user.setId(rs.getInt("id"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setFirstname(rs.getString("firstname"));
                user.setGroupname(rs.getString("groupname"));
                user.setLastname(rs.getString("lastname"));
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("pass"));
                user.setSex("sex");
                user.setUsername("username");
                users.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return users;
    }
    
}
