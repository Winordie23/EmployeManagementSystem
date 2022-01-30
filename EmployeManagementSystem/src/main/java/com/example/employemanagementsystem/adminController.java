package com.example.employemanagementsystem;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminController {
    DatabaseConnection dbc = new DatabaseConnection();
    Connection con = dbc.connectionMethod();

public FileChooser fillChooser;
public File seletedPic;
public Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ComboBox<?> age;

    @FXML
    private Button atachBtn;

    @FXML
    private ImageView atachIng;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField department;

    @FXML
    private TextField division;

    @FXML
    private TableView<?> empInfoTbl;

    @FXML
    private TextField empid;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private TextField grossPayment;

    @FXML
    private Button insertBtn;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private TextField name;

    @FXML
    private Button reportBtn;

    @FXML
    private ToggleGroup sex;

    @FXML
    private Button showBtn;

    @FXML
    private Button showBtn1;

    @FXML
    private Button updateBtn;

    @FXML
    void attachPic() throws FileNotFoundException {
fillChooser = new FileChooser();
        fillChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg Files", "*.jpg"));
seletedPic = fillChooser.showOpenDialog(null);
        if (seletedPic != null) {
            InputStream stream = new FileInputStream(seletedPic);
            Image image = new Image(stream);

            //Setting image to the image view
            atachIng.setImage(image);
        } else {
            alert.setContentText("File is not selected!");
            alert.showAndWait();

        }
    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void deleteInfo(ActionEvent event) {

    }

    @FXML
    void insertInfo(ActionEvent event) {
String insertion = "insert into empinfo(EmpId,Name,Department,Division,GP) values('"+empid.getText()+"','"+name.getText()+"','"+department.getText()+"','"+division.getText()+"','"+grossPayment.getText()+"')";


        try{
            ResultSet pst = con.createStatement().executeQuery(insertion);
   while(pst.next())   {
alert.setContentText("insertion successfull");
alert.showAndWait();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reportGenerator(ActionEvent event) {

    }

    @FXML
    void searchEmp(ActionEvent event) {

    }

    @FXML
    void showEmpNo(ActionEvent event) {

    }

    @FXML
    void updateInfo(ActionEvent event) {

    }
    @FXML
    void startMessage(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("message.fxml"));
        Scene sc = new Scene(fxml.load(),980,620);
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.setTitle("Employee Management System");
        st.show();
    }

}
