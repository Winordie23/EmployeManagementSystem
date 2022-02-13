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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EmpController implements Initializable {
    DatabaseConnection dbc = new DatabaseConnection();
    Connection con = dbc.connectionMethod();
    ObservableList<EngagedTbl>oblist=FXCollections.observableArrayList();
    String Scenetitle= "";
    @FXML
    private Hyperlink chatEmp;

    @FXML
    private TextArea descArea;

    @FXML
    private TableView<EngagedTbl> engagedtbl;

    @FXML
    private Hyperlink group;

    @FXML
    private Hyperlink logout;

    @FXML
    private TableView<PartIn> ongoiingtbl;

    @FXML
    private TableColumn<PartIn, String> ENDATE;

    @FXML
    private TableColumn<PartIn, String> STDATE;

    @FXML
    private TableColumn<PartIn, String> TITLE;
    @FXML
    private TableColumn<EngagedTbl,String> titleC;
    @FXML
    private TableColumn<EngagedTbl,String> startdate;
    @FXML
    private TableColumn<EngagedTbl,String> enddate;
    @FXML
    private ComboBox<?> partCombo;

    @FXML
    private Hyperlink shareFiles;

    @FXML
    private Button submit;

    @FXML
    private Hyperlink talkboss;

    @FXML
    void Logout(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene sc = new Scene(fxml.load(), 980, 620);
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.setTitle("Employee Management system");
        st.show();
    }

    @FXML
    void callBoss(ActionEvent event) throws IOException {
        String username = "select USERNAME from EMPLOYEEINFO where ROLL ='user'";

        try{
            ResultSet resultSet = con.createStatement().executeQuery(username);
            while (resultSet.next()){
                Scenetitle = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("ClientUI.fxml"));
        Scene sc = new Scene(fxml.load(), 980, 620);
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.setTitle(Scenetitle);
        st.show();
    }

    @FXML
    void chatWzEmp(ActionEvent event) {

    }

    @FXML
    void groupchat(ActionEvent event) {

    }

    @FXML
    void sendfiles(ActionEvent event) {

    }

    @FXML
    void submitPart(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<EngagedTbl> oblist= FXCollections.observableArrayList();
        String qq = "select * from NEWPROJ";
        ResultSet res;
        try{
            res = con.createStatement().executeQuery(qq);
            while(res.next()){
      //          System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6));
                oblist.add(new EngagedTbl(res.getString(1),(res.getString(3)),res.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        titleC.setCellValueFactory(new PropertyValueFactory<>("title"));
        startdate.setCellValueFactory(new PropertyValueFactory<>("startdate"));
        enddate.setCellValueFactory(new PropertyValueFactory<>("enddate"));

        engagedtbl.setItems(oblist);


        ObservableList<PartIn> list= FXCollections.observableArrayList();
        String partQuery = "select * from PART_IN";
        ResultSet res1;
        try{
            res1 = con.createStatement().executeQuery(partQuery);
            while(res1.next()){
                //          System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6));
                list.add(new PartIn(res1.getString(1),(res1.getString(2)),res1.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TITLE.setCellValueFactory(new PropertyValueFactory<>("title"));
        STDATE.setCellValueFactory(new PropertyValueFactory<>("startdate"));
        ENDATE.setCellValueFactory(new PropertyValueFactory<>("enddate"));

        ongoiingtbl.setItems(list);

    }
}
