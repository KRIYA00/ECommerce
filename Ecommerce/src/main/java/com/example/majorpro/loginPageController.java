package com.example.majorpro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginPageController
{
    @FXML
    TextField email;
    @FXML
    PasswordField Password;
public  void login(MouseEvent e) throws SQLException, IOException {
 String query=String.format("Select * from user where emailId='%s' and pass='%s'",email.getText(),Password.getText());
    ResultSet res=HelloApplication.connection.executeQuery(query);
    if(res.next())
    {
        HelloApplication.emailId=res.getString("emailId");
        System.out.println("Logged in");
        String userType=res.getString("userType");
        if(userType.equals("Seller"))
        {
            System.out.println("You are logged in as Seller");
          AnchorPane sellerPage= FXMLLoader.load(getClass().getResource("sellerPage.fxml"));
          HelloApplication.root.getChildren().add(sellerPage);
        }
        else
        {
            System.out.println("You are logged in as Buyer");
            header header=new header();
            productPage productPage=new productPage();
            AnchorPane productPane=new AnchorPane();
            productPane.setLayoutX(125);
            productPane.setLayoutY(100);
            productPane.getChildren().add(productPage.products());
            HelloApplication.root.getChildren().clear();
            HelloApplication.root.getChildren().addAll(productPane,header.root);
        }
    }
    else
    {
        System.out.println("Not Logged in");
    }
}
}
