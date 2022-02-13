package com.example.employemanagementsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class Controller {


/*
    @FXML
    private Button loginbtn;




*/
@FXML
private Button applybtn;
DatabaseConnection dbc = new DatabaseConnection();
Connection con = dbc.connectionMethod();

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private CheckBox showCombo;

    @FXML
    private RadioButton adm;

    @FXML
    private RadioButton emp;
    @FXML
    private ToggleGroup tgl;

    public void login(ActionEvent event) throws Exception {
        String se= "select USERNAME,PASSWORD,ROLL from EMPLOYEEINFO where USERNAME ='" + usernamefield.getText() + "'";
           try {
               ResultSet res = con.createStatement().executeQuery(se);
               while (res.next()){
                   if(usernamefield.getText().equals(res.getString(1))){
                   if (passwordfield.getText().equals(res.getString(2))) {
                       if(res.getString(3).equals("Admin")) {
                           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
                           Scene scene = new Scene(fxmlLoader.load(), 980, 620);
                           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                           window.setTitle("Employee Management System");
                           window.setScene(scene);
                           window.show();
                       }
                       else if(res.getString(3).equals("user")){
                           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("empPage.fxml"));
                           Scene scene = new Scene(fxmlLoader.load(), 980, 620);
                           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                           window.setTitle("Employee Management System");
                           window.setScene(scene);
                           window.show();
                       }
                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Wrong password");
                   }
               }
                   else{
                       JOptionPane.showMessageDialog(null, "Wrong Username");
                   }
               }
           }
           catch (Exception e){
             //  JOptionPane.showMessageDialog(null,"invalid username");
               e.printStackTrace();
           }
       }




    public void show(){
        String pass = passwordfield.getText();
        if(showCombo.isSelected()){
//            pass.setEchoChar((char)0);
        }
        else{
//            pass.setEchoChar('*');
        }

    }
    public void apply(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("apply.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 819, 551);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Employee Management System");
        window.setScene(scene);
        window.show();
    }
public void submitClicked(){

}

}
