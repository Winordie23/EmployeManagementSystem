package com.example.fxregistration;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main extends Application implements confirmer {
    public static void main(String[] args) {
        launch(args);
    }

    Label l = new Label("Name");
   Button insert = new Button("insert");
   TableView tb = new TableView();
   TableColumn cl= new TableColumn("Name");
Dbcon dbc = new Dbcon();
    Button Register;
    Button Update;
    Button Select;
    Button Cancel;
    Button bydept= new Button("by dept");
    Button byname= new Button("by section");
    Button confirm = new Button("Confirm");
    TableView table = new TableView();
    TextField Sid;
    TextField Id;
    TextField Fname; TextField Lname;
    ComboBox Dept; ComboBox Section;
    GridPane gp= new GridPane();
    Button dselect = new Button("distnict select");
    Control c = new Control();
     @Override
    public void start(Stage stage) throws Exception {

         //Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
gp.setVgap(15);
gp.setPadding(new Insets(0,10,0,10));
         Text title = new Text("Regisrtation Form");
          title.setFont(Font.font("Agency FB", FontWeight.BOLD, 60));
gp.add(title,7,0);
Text sid = new Text("SID");
gp.add(sid,5,2);
 Sid = new TextField();
         Sid.setMaxWidth(30);
gp.add(Sid,7,2);
         Text id = new Text("ID");
         gp.add(id,9,2);
          Id = new TextField();
         Id.setMaxWidth(80);
         gp.add(Id,10,2);

         Text first = new Text("First Name");
         gp.add(first,5,3);
          Fname = new TextField();
         Fname.setMaxWidth(120);
         gp.add(Fname,7,3);

         Text last = new Text("Last Name");
         gp.add(last,9,3);
         Lname = new TextField();
         Lname.setMaxWidth(120);
         gp.add(Lname,10,3);

         Text dept = new Text("Department");
         gp.add(dept,5,5);
         Dept = new ComboBox();
         Dept.getItems().add("CS");
         Dept.getItems().add("SW");
         gp.add(Dept,7,5);

         Text sec = new Text("Section");
         gp.add(sec,9,5);
         Section = new ComboBox();
         Section.getItems().add("Sec A");
         Section.getItems().add("Sec B");
         Section.getItems().add("Sec C");
         gp.add(Section,10,5);
Button display = new Button("display");

         display.setOnAction(new EventHandler<ActionEvent>() {
             private ObservableList<ObservableList> data;
             //private TableView tbl;

             @Override
             public void handle(ActionEvent event)
             {

                 Dbcon obj1;
                 Connection c;
                 ResultSet rs;
                 table.setItems(data);
                 try {
                     data = FXCollections.observableArrayList();
                      obj1 = new Dbcon();
                     c = obj1.connMethod();
                     String SQL = "SELECT * from DEPT_TB";
                     rs = c.createStatement().executeQuery(SQL);
                     for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                         final int j = i;
                         TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                         col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                                                          ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                         table.getColumns().addAll(col);
                         //System.out.println("Column [" + i + "] ");

                     }
          while (rs.next()) {
                         ObservableList<String> row = FXCollections.observableArrayList();
                         for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                             row.add(rs.getString(i));
                         }
                         //System.out.println("Row[1]added " + row);
                         data.add(row);

                     }
                     table.setItems(data);
                 } catch (Exception e) {
                     e.printStackTrace();
                     System.out.println("Error ");
                 }

             }
         });

          Register = new Button("Register");
          Update = new Button("Update");
          Select = new Button("Select");
          Cancel = new Button("Cancel");
         gp.add(Register,5,7);
          gp.add(Update,7,7);
          gp.add(Select,9,7);
          gp.add(display,7,9);
        gp.add(Cancel,11,7);
Register.setOnAction(this::handle);
         Cancel.setOnAction(this::handle);
         Select.setOnAction(this::handle);
         Update.setOnAction(this::handle);
         Connection con = dbc.connMethod();




table.setMinWidth(200);
       //  table.getColumns().addAll(c1,c2,c3,c4,c5,c6);

  ObservableList<String> values = FXCollections.observableArrayList();
         ResultSet res = con.createStatement().executeQuery("select * from DEPT_TB");
         while(res.next()){
            for(int i=0; i<6; i++) {
                String v1 = res.getString("SID");
                String v2 = res.getString("ID");
                String v3 = res.getString("FNAME");
                String v4 = res.getString("LNAME");
                String v5 = res.getString("DEPT");
                String v6 = res.getString("SECTION");
                values.addAll(v1, v2, v3, v4, v5, v6);
                table.setItems(values);
            }
         }
gp.add(table,7,15);
Select.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        gp.add(bydept,10,8);
        gp.add(byname,12,8);
        gp.add(dselect,8,8);
    }
});
bydept.setOnAction(new EventHandler<ActionEvent>() {
    private ObservableList<ObservableList> data2;
    @Override
    public void handle(ActionEvent event) {

        Dbcon obj1;
        Connection c;
        ResultSet rs;
        TableView table2 = new TableView<>();
        gp.getChildren().remove(table);
        table2.setItems(data2);
        try {
            data2 = FXCollections.observableArrayList();


            obj1 = new Dbcon();
            c = obj1.connMethod();
            String de = Dept.getSelectionModel().getSelectedItem().toString();
            String SQL = "SELECT * from DEPT_TB where DEPT = '"+de+"'";
            rs = c.createStatement().executeQuery(SQL);
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                        ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                table2.getColumns().addAll(col);
                //System.out.println("Column [" + i + "] ");

            }


            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                //System.out.println("Row[1]added " + row);
                data2.add(row);

            }


            table2.setItems(data2);
            gp.add(table2,7,15);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error ");
        }

    }
});

        dselect.setOnAction(new EventHandler<ActionEvent>() {
            private ObservableList<ObservableList> data2;
            //Private String = Fname.getText();
            @Override
            public void handle(ActionEvent event) {

                Dbcon obj1;
                Connection c;
                ResultSet rs;
                TableView table2 = new TableView<>();
                gp.getChildren().remove(table);
                table2.setItems(data2);
                try {
                    data2 = FXCollections.observableArrayList();


                    obj1 = new Dbcon();
                    c = obj1.connMethod();
                    String de = Fname.getText();
                    String SQL = "SELECT * from DEPT_TB where FNAME = '"+de+"'";
                    rs = c.createStatement().executeQuery(SQL);
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        final int j = i;
                        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                                ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                        table2.getColumns().addAll(col);
                        //System.out.println("Column [" + i + "] ");

                    }


                    while (rs.next()) {
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            row.add(rs.getString(i));
                        }
                        //System.out.println("Row[1]added " + row);
                        data2.add(row);

                    }


                    table2.setItems(data2);
                    gp.add(table2,7,15);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error ");
                }

            }
         });
         byname.setOnAction(new EventHandler<ActionEvent>() {
             private ObservableList<ObservableList> data2;
             @Override
             public void handle(ActionEvent event) {

                 Dbcon obj1;
                 Connection c;
                 ResultSet rs;
                 TableView table2 = new TableView<>();
                 gp.getChildren().remove(table);
                 table2.setItems(data2);
                 try {
                     data2 = FXCollections.observableArrayList();


                     obj1 = new Dbcon();
                     c = obj1.connMethod();
                     String de = Section.getSelectionModel().getSelectedItem().toString();
                     String SQL = "SELECT * from DEPT_TB where SECTION = '"+de+"'";
                     rs = c.createStatement().executeQuery(SQL);
                     for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                         final int j = i;
                         TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                         col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                                 ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                         table2.getColumns().addAll(col);
                         //System.out.println("Column [" + i + "] ");

                     }


                     while (rs.next()) {
                         ObservableList<String> row = FXCollections.observableArrayList();
                         for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                             row.add(rs.getString(i));
                         }
                         //System.out.println("Row[1]added " + row);
                         data2.add(row);

                     }


                     table2.setItems(data2);
                     gp.add(table2,7,15);
                 } catch (Exception e) {
                     e.printStackTrace();
                     System.out.println("Error ");
                 }

             }
         });
         confirm.setOnAction(this::handle);
         stage.setScene(new Scene(gp,800,800));
         stage.setTitle("register");
         insert.setOnAction(this::handle);
         stage.show();
    }
    @Override
    public void handle(ActionEvent event) {
        String saveId= Id.getText();
               if (event.getSource() == Register) {
            new Control().insert(Sid.getText(), Id.getText(), Fname.getText(), Lname.getText(), Dept.getSelectionModel().getSelectedItem().toString(), Section.getSelectionModel().getSelectedItem().toString());
        } else if (event.getSource() == Cancel) {
            Sid.setText("");
            Id.setText("");
            Fname.setText("");
            Lname.setText("");
        } else if (event.getSource() == Update) {
           if (Id.getText().equals("")) {
               Alert a = new Alert(Alert.AlertType.INFORMATION);
               a.setContentText("Please insert the id of the student to update");
               a.showAndWait();
           }
           else{
               Connection con = dbc.connMethod();
               String query = "select * from DEPT_TB where ID = '"+Id.getText()+"'";

               ResultSet res = null;

               try {
                   res = con.createStatement().executeQuery(query);
                            while(res.next()) {
                                Sid.setText(res.getString(1));

                                Id.setText(res.getString(2));
                                Fname.setText(res.getString(3));
                                Lname.setText(res.getString(4));
                            gp.add(confirm,6,8);
                            }
               } catch (SQLException e) {
                   System.out.println(e);
               }
           }
        }
               else if (event.getSource()== confirm){
                 Connection con = dbc.connMethod();
                   String query2 ="update DEPT_TB set ID = '"+Id.getText().toString()+"', FNAME = '"+Fname.getText().toString()+"',LNAME = '"+Lname.getText().toString()+"'where ID = '"+saveId+"'";
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                   Statement st = null;
                   try {
                       st = con.createStatement();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   try {
                       st.executeUpdate(query2);
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   a.setContentText("successfuly updated");
                       a.showAndWait();
               }
           }

    @Override
    public void confirmer(ActionEvent event) {

    }
}
