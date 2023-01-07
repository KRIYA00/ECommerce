package com.example.majorpro;

import java.sql.*;

public class DatabaseConnection
{
 Connection con=null;
 String SQLURL="jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
 String username="root";
 String password="tanmay@0903";
 DatabaseConnection() throws SQLException {
con= DriverManager.getConnection(SQLURL,username,password);
if(con!=null) {
 System.out.println("Connection is established");
}

 }
 //Select * from temporary
 public ResultSet executeQuery(String query) throws SQLException
 {
  ResultSet result=null;
  try
  {
   Statement statement = con.createStatement();                   //to pass the   query inside statement
    result = statement.executeQuery(query);//executeQuery here,is an inbuilt function of mysql class,not the same as the above functiom
   return result;                              //points to the header of the table
  }                              //ResultSet is a datatype of mysql class which acts as an iterator to the complete table && points to the header of table
  catch (Exception e)
  {
   e.printStackTrace();
  }
return result;

 }

 public int executeUpdate(String query) throws SQLException {
  int rows = 0;
  try
  {
   Statement statement = con.createStatement();
   rows = statement.executeUpdate(query);
   return rows;
  }
  catch (Exception e) //if any wrong query is given,catch block is executed and project will not break
                     //will help to not terminate the project if some error occurs
  {
   e.printStackTrace();
  }
  return rows;
 }


}
