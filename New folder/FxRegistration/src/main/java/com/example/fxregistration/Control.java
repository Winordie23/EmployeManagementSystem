package com.example.fxregistration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Control {
    Dbcon dbc = new Dbcon();

       public void insert(String SId,String Id,String fn,String ln,String dept,String secn){
        Connection con = dbc.connMethod();
        String query = "insert into DEPT_TB(SID,ID,FNAME,LNAME,DEPT,SECTION) VALUES('"+SId+"','"+Id+"','"+fn+"','"+ln+"','"+dept+"','"+secn+"')";
        try{
            Statement st = con.createStatement();
            st.executeUpdate(query);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("successfuly inserted");
            a.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void select(String s,String it){
           Connection con = dbc.connMethod();
           String query = "select * from DEPT_TB where "+s+" = '"+it+"'";
}
public void Update(String SId,String Id,String fn,String ln,String sentId){


}
}
