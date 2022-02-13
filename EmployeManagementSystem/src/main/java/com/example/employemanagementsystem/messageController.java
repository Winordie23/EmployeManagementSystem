package com.example.employemanagementsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class messageController implements Initializable {
    DatabaseConnection dbc = new DatabaseConnection();
    Connection con = dbc.connectionMethod();
    int i =0;
String[] slelctedUsers;
    @FXML
    private Button Start;

    @FXML
    private TextArea VacancyArea;

    @FXML
    private Button multiStart;

    @FXML
    private Button multiStart1;

    @FXML
    private Button publsihBtn;

    @FXML
    private ComboBox<String> sendtoCombo;

    @FXML
    private TextArea messageList;


    @FXML
    void announce(ActionEvent event) throws SQLException {
        i=i+1;
      try {
          String ins = "insert into VACANCY(NO,VACANCEE) values('" + i + "','" + VacancyArea.getText() + "')";
          ResultSet res = con.createStatement().executeQuery(ins);
          while (res.next()) {
              JOptionPane.showMessageDialog(null, "insertion Successfull!!!");
          }
      }
      catch (Exception e){

      }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendtoCombo.setItems(FXCollections.observableArrayList("Male","Female"));
        messageList.setText(sendtoCombo.getSelectionModel().getSelectedItem());
    }
    @FXML
    void startChat(ActionEvent event)  {
        String username = "select USERNAME from EMPLOYEEINFO where ROLL ='user'";
        String title=null;
        try{
            ResultSet resultSet = con.createStatement().executeQuery(username);
            while (resultSet.next()){
                title = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {  FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("ServerUI.fxml"));
        Scene sc = new Scene(fxml.load(),980,620);
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.setTitle(title);
        st.show();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

}