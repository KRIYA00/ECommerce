package com.example.majorpro;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sellerPageController
{
    @FXML
    TextField name,price,sellerid;
   public void AddProduct(MouseEvent e) throws SQLException {
       int productID=1;
        ResultSet response2=HelloApplication.connection.executeQuery("select max(productId) as productId from product");
        if(response2.next())
        {
          productID=response2.getInt("productId")+1;

        }
       String query=String.format("Insert into product values('%s','%s','%s','%s')",productID,name.getText(),price.getText(),sellerid.getText());
       int response=HelloApplication.connection.executeUpdate(query);
       if(response>0)
           System.out.println("New Product added");
   }

}
