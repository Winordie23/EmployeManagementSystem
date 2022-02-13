package com.example.employemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplyController {
DatabaseConnection dbc = new DatabaseConnection();
    Connection c = dbc.connectionMethod();
    @FXML
    private TextField age;

    @FXML
    private Button back;

    @FXML
    private Button cancel;

    @FXML
    private TextField email;

    @FXML
    private RadioButton femaleradio;

    @FXML
    private TextField fullname;

    @FXML
    private RadioButton maleradio;

    @FXML
    private TextField phoneno;

    @FXML
    private TextField applearea;

    @FXML
    private Button subit;

    @FXML
    private ToggleGroup sex;
public void cancelmethod(){
    age.setText("");
    email.setText("");
    fullname.setText("");
    phoneno.setText("");
  }

public void backBtn(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 819, 551);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setTitle("Employee Management System");
    window.setScene(scene);
    window.show();
}

public void submitclicked() throws SQLException {
String seX;
if(maleradio.isSelected()){
    seX="Male";
}
else if(femaleradio.isSelected()){
    seX="Female";
}
else{
    seX="null";
}
    String query = "insert into APPLICANTS(FULLNAME,AGE,SEX,PHONENO,EMAIL,APPAREA)values(?,?,?,?,?,?)";
    PreparedStatement pst = c.prepareStatement(query);
    try{
        pst.setString(1,fullname.getText());
        pst.setString(2,age.getText());
        pst.setString(3,seX);
        pst.setString(4,phoneno.getText());
        pst.setString(5,email.getText());
        pst.setString(6,applearea.getText());
        pst.executeUpdate();
        if (pst.executeUpdate()==1){
        JOptionPane.showMessageDialog(null,"Successfully registerd!!!");
        }
    }
    catch(Exception e){
e.printStackTrace();
    }
}

}