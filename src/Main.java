import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    public static void main(String[] args) {


// Read From Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_person where name='Roham'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
/*

//Send To Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from tbl_person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

/*
        //Send To Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into tbl_person (name, family, phonenumber) values('Yashar','Abbasi',09124445231)");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/

        launch(args);

    }


    public void start(Stage primaryStage) throws Exception {

       /* Button btnViewObj = new Button("View");

        ListView PersonList = new ListView();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "");
        Statement PersonStatement = con.createStatement();
        ResultSet PersonResult = PersonStatement.executeQuery("select * from tbl_person");
        while (PersonResult.next()) {

            PersonList.getItems().add(PersonResult.getString(1) + "-" + PersonResult.getString(2) + " " + PersonResult.getString(3) + " /" + PersonResult.getString(4));
        }
*/

        Button btnSend = new Button("Send");

        TextField NameObj = new TextField();
        TextField FamilyObj = new TextField();
        TextField PhoneNumObj = new TextField();

        Label lblName = new Label("Name:");
        Label lblFamily = new Label("Family:");
        Label lblPhonenum = new Label("Phone Number:");


        ListView listView = new ListView();
        btnSend.setOnAction(event -> {

            String nametmp = NameObj.getText();
            String familytmp = FamilyObj.getText();
            String Phonenumtmp = PhoneNumObj.getText();

            listView.getItems().add(nametmp + " " + familytmp + "  " + Phonenumtmp);

        });


        GridPane gridPanea = new GridPane();
        gridPanea.addRow(1, lblName, NameObj);
        gridPanea.addRow(2, lblFamily, FamilyObj);
        gridPanea.addRow(3,lblPhonenum, PhoneNumObj);
        gridPanea.addRow(4, btnSend);
        gridPanea.addRow(5, listView);


      /*  GridPane gridPane = new GridPane();
        gridPane.addRow(1, PersonList);
        gridPane.addRow(1, btnViewObj);
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Phone Book");
        primaryStage.setScene(scene);
        primaryStage.show();*/


        Scene scene = new Scene(gridPanea, 400, 600);
        primaryStage.setTitle("Phone Book");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


}