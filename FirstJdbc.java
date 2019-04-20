/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class FirstJdbc {
   
      public static void main(String[] args) {
      try{
          Class.forName("oracle.jdbc.OracleDriver");
      }
      catch(ClassNotFoundException cfe){
          System.out.println("Error in loadind the Driver" + cfe);
          System.exit(0);
      }
      Connection conn=null;
      try{
          conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","anshthukral");
          System.out.println("Connection succeeded");
          int i;
          String let="Let us C12";
          String I="Helo";
          Scanner sc=new Scanner(System.in);
          i=sc.nextInt();
              PreparedStatement ps=null;
              String s="insert into books(bookid,bookname,bookprice)"+"values(?,?,?)";
              ps=conn.prepareStatement(s);

              
                            ps.setInt(1,i);
              ps.setString(2, "hello");
              ps.setDouble(3,98);
             
               ps.execute();
               ps.close();
               ps=conn.prepareStatement("select bookid,bookname,bookprice from books");
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                  int t=rs.getInt(1);
                  String st=rs.getString(2);
                  Double d=rs.getDouble(3);
                  System.out.println(t+"\t"+st+"\t"+d);
              
              
             }
            
      }
          
      
      catch(SQLException sq){
          System.out.println("Exception in db:"+sq);
      }
      finally{
          if(conn!=null){
              try{
                  conn.close();
                  System.out.println("Connection closed");
              }
              catch(SQLException sq){
                  System.out.println("Exception in db:"+sq);
              }
          }
      }
    }
}
