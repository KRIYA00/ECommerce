package com.example.majorpro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {
    public static DatabaseConnection connection;
    public static String emailId="";
     public static Group root;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        connection=new DatabaseConnection();
        root=new Group();
        header header=new header();
        productPage productPage=new productPage();
        AnchorPane productPane=new AnchorPane();
        productPane.setLayoutX(125);
        productPane.setLayoutY(100);
        productPane.getChildren().add(productPage.products());

        root.getChildren().addAll(header.root,productPane);


       /* ResultSet res=connection.executeQuery("Select * from temporary");
        //will point to the header of the table temporary
        while(res.next())
        {
            int number=res.getInt("temp_number"); //res of ResultType can store all type of data type
            System.out.println(number);
        }
        int rows=connection.executeUpdate("Insert into temporary values(6)");
        System.out.println(rows);

        */


        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("header.fxml"));
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("ECommerce");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e ->{
            try
            {
                connection.con.close();
                System.out.println("Connection is closed successfully");
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            //says that close the connection when project is closef
        });
    }

    public static void main(String[] args)
    {
        launch();
    }
}