/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3.controller;

import chapter3.bo.AdminBO;
import chapter3.bo.UserBO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mirushi
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AdminBO adminBO = new AdminBO(req.getServletContext());
        UserBO userBO = new UserBO(req.getServletContext());
        
        RequestDispatcher dispatchToHome = req.getRequestDispatcher("");
        
        HttpSession session = req.getSession();
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Boolean isAccountValid = userBO.checkLoginInfo(username, password);
        if (isAccountValid){
            synchronized (session){
                session.setAttribute("userID", userBO.getUserIDFromUsername(username));
            }
            dispatchToHome.forward(req, resp);
        }
    }
}
