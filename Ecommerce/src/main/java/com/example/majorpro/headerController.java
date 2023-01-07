package com.example.majorpro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class headerController
{

@FXML
     Button logOut;

    @FXML
    public  void initialize()
{
    if(!HelloApplication.emailId.equals(""))
{
    loginbutton.setOpacity(0);
    email.setText(HelloApplication.emailId);
}
}
@FXML
TextField SearchText;
  @FXML
   Button loginbutton;


@FXML
Label email;
    public void login(MouseEvent e) throws IOException {
        AnchorPane loginpage= FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        HelloApplication.root.getChildren().add(loginpage);
    }

    @FXML
    public void Search(MouseEvent e) throws SQLException, IOException {

        productPage productPage=new productPage();
        header header=new header();
        AnchorPane productPane=new AnchorPane();
        productPane.setLayoutX(125);
        productPane.setLayoutY(100);
        productPane.getChildren().add(productPage.productsbySearch(SearchText.getText()));
       HelloApplication.root.getChildren().clear();
        HelloApplication.root.getChildren().addAll(productPane,header.root);

    }
    @FXML
    public void logOutButtonAppear(MouseEvent e)
    {
       if(logOut.getOpacity()==0)
       {
         logOut.setOpacity(1);
       }
       else
       {
           logOut.setOpacity(0);

       }
    }
    @FXML
    public void logOut() throws IOException {
        if(logOut.getOpacity()==1) {
            HelloApplication.emailId = "";
            logOut.setOpacity(0);
            header header = new header();
            HelloApplication.root.getChildren().add(header.root);
        }
    }
}





