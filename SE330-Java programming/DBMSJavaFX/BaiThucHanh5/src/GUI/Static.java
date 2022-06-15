/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.Lop;
import DLL.ThongKe;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class Static {
    public static ObservableList<Lop> ds = FXCollections.observableArrayList();
    public static ObservableList<ThongKe> dstk = FXCollections.observableArrayList(); 
    public static String connection = "jdbc:ucanaccess://C:\\Users\\Admin\\Documents\\Database2.accdb";
}
