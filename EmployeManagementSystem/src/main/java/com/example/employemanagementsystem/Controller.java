package com.example.employemanagementsystem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Controller {


/*
    @FXML
    private Button loginbtn;




*/
@FXML
private Button applybtn;

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private CheckBox showCombo;

    public void login(ActionEvent event) throws IOException {
        if((usernamefield.getText().equals("yeab"))&&(passwordfield.getText().equals("1234"))){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 819, 551);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Employee Management System");
            window.setScene(scene);
            window.show();
        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong username or password");

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
