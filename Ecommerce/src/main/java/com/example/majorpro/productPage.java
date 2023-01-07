package com.example.majorpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class productPage extends Node {
    ListView<HBox>products; //used to view a list of  products

    ListView<HBox> productsbySearch(String search)throws SQLException
    {
        products=new ListView<>();
        ObservableList<HBox> productList= FXCollections.observableArrayList();
        ResultSet res=HelloApplication.connection.executeQuery("Select * from product");
        while(res.next()) {
            if (res.getString("productName").toLowerCase().contains(search.toLowerCase())) {
                Label productId = new Label();
                Label name = new Label();
                Label price = new Label();
                Button buy = new Button();
                productId.setMinWidth(50);
                name.setMinWidth(70);
                price.setMinWidth(70);

                buy.setText("Buy");
                buy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("Buy Button is clicked");
                        if (HelloApplication.emailId.equals("")) {
                            System.out.println("Please login first");
                        } else {
                            System.out.println("You are logged in with " + HelloApplication.emailId);
                            Order order = new Order();
                            try {
                                order.placeOrder(productId.getText());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
                HBox ProductDetails = new HBox();

                name.setText(res.getString("productName"));
                productId.setText(res.getString("productId"));
                price.setText(res.getString("price"));
                ProductDetails.getChildren().addAll(name, productId, price, buy);
                productList.add(ProductDetails);
            }
        }
        products.setItems(productList);
        return products;
    }



    ListView<HBox> products()throws SQLException
    {
        products=new ListView<>();
        ObservableList<HBox> productList= FXCollections.observableArrayList();
        ResultSet res=HelloApplication.connection.executeQuery("Select * from product");
        while(res.next())
        {
            Label productId = new Label();
            Label name = new Label();
            Label price = new Label();
            Button buy = new Button();
            productId.setMinWidth(50);
            name.setMinWidth(70);
            price.setMinWidth(70);

            buy.setText("Buy");
            buy.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Buy Button is clicked");
                    if(HelloApplication.emailId.equals(""))
                    {
                        System.out.println("Please login first");
                    }
                    else
                    {
                        System.out.println("You are logged in with "+HelloApplication.emailId);
                        Order order=new Order();
                        try
                        {
                            order.placeOrder(productId.getText());
                        }
                        catch (SQLException e)
                        {
                            e.printStackTrace();
                        }

                    }
                }
            });
            HBox ProductDetails = new HBox();

            name.setText(res.getString("productName"));
            productId.setText(res.getString("productId"));
            price.setText(res.getString("price"));
            ProductDetails.getChildren().addAll(name, productId, price, buy);
            productList.add(ProductDetails);
        }
        products.setItems(productList);
        return products;
    }
}
