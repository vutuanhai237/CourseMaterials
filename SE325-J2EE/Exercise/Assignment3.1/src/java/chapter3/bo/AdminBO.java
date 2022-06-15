/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3.bo;

import chapter3.dto.UserDTO;
import chapter3.mapper.UserMapper;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author mirushi
 */
public class AdminBO {
    
    private ServletContext context;
    
    public AdminBO(ServletContext context){
        this.context = context;
    }
    
    public Boolean checkLoginInfo (String username, String password){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.checkLoginExist(username, password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public Boolean createUserAccount (String username, String password, String firstname, String lastname, String sex, String address, String email, String mobilePhone){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.createAccountForUser( username,  password,  firstname,  lastname,  sex,  address,  email,  mobilePhone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public Boolean updateUserAccount (Integer id, String username, String password, String firstname, String lastname, String sex, String address, String email, String mobilePhone){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.updateAccountForUser(id, username,  password,  firstname,  lastname,  sex,  address,  email,  mobilePhone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public Boolean deleteUserAccount (Integer id){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.deleteAccountForUser(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<UserDTO> getUsers(){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.getAllUsers();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<UserDTO> searchUsers (String username, String usergroup, String firstname, String lastname, String sex, String email, String address, String mobile){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.searchUsers(username, usergroup, firstname, lastname, sex, email, address, mobile);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Boolean checkPermission (Integer userID){
        try{
            UserMapper mapper = new UserMapper();
            UserDTO user = mapper.getUserByID(userID);
            if (user != null && user.getGroupname() == "ADMIN")
                return true;
            else
                return false;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
