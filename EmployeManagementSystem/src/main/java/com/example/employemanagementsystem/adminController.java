package com.example.employemanagementsystem;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable {
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
    private TableView<Table1> empInfoTbl;
    @FXML
    private TableColumn<Table1, String> Division;
    @FXML
    private TableColumn<Table1, String> dept;
    @FXML
    private TableColumn<Table1, String> Name;
    @FXML
    private TableColumn<Table1, String> Sex;
    @FXML
    private TableColumn<Table1, String> empID;
    @FXML
    private TableColumn<Table1, String> GPA;
    @FXML
    private TextField empid;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private TextField grossPayment;
    @FXML
    private Button insertBtn;
    @FXML
    private Button select;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private TextField name;
    @FXML
    private TextField swithname;

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
String insertion = "insert into EMPLOYEEINFO(EmpId,Name,Department,Division,GP) values('"+empid.getText()+"','"+name.getText()+"','"+department.getText()+"','"+division.getText()+"','"+grossPayment.getText()+"')";


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
String qq = "select *from EMPLOYEEINFO where Name = '"+swithname.getText()+"'";
ResultSet res;
try{
    res = con.createStatement().executeQuery(qq);
    while(res.next()){
        empid.setText(res.getString(1));
   name.setText(res.getString(2));
           department.setText(res.getString(7));
                                     division.setText(res.getString(8));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
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
    @FXML
    void applicantsMtd(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("applicants.fxml"));
        Scene sc = new Scene(fxml.load(),980,620);
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.setTitle("Employee Management System");
        st.show();
    }
    @FXML
    void disp(ActionEvent event) {

    }
    @FXML
    void Logout(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene sc = new Scene(fxml.load(), 980, 620);
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.setTitle("Employee Management System");
        st.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Table1> oblist= FXCollections.observableArrayList();
        String qq = "select * from APPLICANTS";
        ResultSet res;
        try{
            res = con.createStatement().executeQuery(qq);
            while(res.next()){
                System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6));
                oblist.add(new Table1(res.getString(1),(res.getString(2)),res.getString(3),res.getString(4),res.getString(5),res.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        empID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Sex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        Division.setCellValueFactory(new PropertyValueFactory<>("Division"));
        GPA.setCellValueFactory(new PropertyValueFactory<>("GPA"));

        empInfoTbl.setItems(oblist);

    }
}
