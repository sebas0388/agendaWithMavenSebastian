/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendawithmaven;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author SebastianR
 */
public class dataBaseConnection {
    
    private static dataBaseConnection instance = null;
    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/db_agenda";
    private String user = "root";
    private String password = "1234";


private dataBaseConnection (){

try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           this.con = DriverManager.getConnection(host,user,password);
           System.out.println("BASE DE DATOS ON"); 
        } catch (Exception e)
        {
            System.out.println("ERROR ->" + e);
        }

}

  public Connection getConnection() {
        return con;
    }
    
  public static dataBaseConnection getInstance() {
        try{
                if (instance == null) {
                instance = new dataBaseConnection();

                } else if (instance.getConnection().isClosed()) {
                    instance = new dataBaseConnection();
                }

            return instance;
        } 
        
        catch(SQLException e){
            
            return instance;
            
        }
    
    }
}