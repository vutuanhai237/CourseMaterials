/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3.bo;

import chapter3.mapper.UserMapper;
import javax.servlet.ServletContext;

/**
 *
 * @author mirushi
 */
public class UserBO {
    
    private ServletContext context;
    
    public UserBO(ServletContext context){
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
    
    public Boolean updateUserAccount (Integer id, String username, String password, String firstname, String lastname, String sex, String address, String email, String mobilePhone){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.updateAccountForUser(id, username,  password,  firstname,  lastname,  sex,  address,  email,  mobilePhone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public Integer getUserIDFromUsername (String username){
        try{
            UserMapper mapper = new UserMapper();
            return mapper.getUserIDFromUsername(username);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
