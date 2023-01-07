package com.example.majorpro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Order
{
    void placeOrder(String productId) throws SQLException {
        int orderId=1;
        ResultSet res=HelloApplication.connection.executeQuery("Select max(orderId)as orderId from orders");
        while(res.next())
        {
         orderId= res.getInt("orderId")+1;

        }
        Timestamp ts=new Timestamp(Calendar.getInstance().getTime().getTime());
        String query=String.format("Insert into orders values(%s,%s,'%s','%s')"
                ,orderId,productId,HelloApplication.emailId,ts);
        int response=HelloApplication.connection.executeUpdate(query);
        if(response>0)
 System.out.println("Order is placed");
        else
            System.out.println("Order is not placed");
    }
}


