/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendawithmaven;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author SebastianR
 */
public class main {    
        static dataBaseConnection con = dataBaseConnection.getInstance();
    
public static void main(String[] args) throws SQLException {
        
        int Select;
        Scanner sc = new Scanner(System.in);
        
        agenda a = agenda.getUser(13);
        if(a == null){
            System.out.println("USUARIO NO ENCONTRADO");
            System.exit(0);
        }
        
        System.out.println("IDUSUARIO: " + a.getIdContacto());
        System.out.println("NOMBRE: " + a.getNombre());
        System.out.println("APELLIDO: " + a.getApellido());
        System.out.println("EDAD: " + a.getEdad());
            
        do{
        System.out.println("\t ");
        System.out.println("Seleccionar una opcion: ");        
        System.out.println("1 - Ver los contactos.");
        System.out.println("2 - Buscar un contacto.");
        System.out.println("3 - Agregar nuevo contacto.");
        System.out.println("4 - Editar un contacto.");
        System.out.println("5 - Borrar un contacto.");
        System.out.println("0 - Salir");
        System.out.println("\t ");
                
        String Option = sc.next();
               Select = Integer.parseInt(Option);
                        
                if (Select == 1){ 
                            SHOW();   
               
        }else{            
                if (Select == 2 ) {       
                           SEARCH();              
        } else{                       
                if (Select == 3){             
                           ADD();    
                                                   
        }else{  
                if (Select == 4) {            
                           UPDATE(); 
                           
        }else{            
               if (Select == 5) {             
                            DELETE();   
                        
        } else {                  
               if (Select > 6 ) {           
                    System.out.println("Selecciono una opcion NO valida");
            
                    } 
                   }
                  }
                 }
                }
               }               
           }    while(Select != 0);
             System.out.println("SALIO DEL PROGRAMA");
        }  
    
    //FUNCIONES
    
    //MOSTRAR TODOS LOS CONTACTOS.    
    public static void SHOW (){
        
        PreparedStatement ps;
        ResultSet rs;
                
        try 
        {   
            String Q = "SELECT * FROM contactos WHERE estado = '1';";
            
            ps = con.getConnection().prepareStatement(Q);      
            rs = ps.executeQuery(Q);
            
               System.out.printf("%-15s %-15s %-15s %-20s %20s %n","NOMBRE" , "APELLIDO" , "NACIMIENTO" , "EMAIL" , "TELEFONO");
               
            while(rs.next())
            {  
               System.out.printf("%-15s %-15s %-15s %-20s %20s %n", rs.getString("nombre"),rs.getString("apellido"),rs.getDate("fechaNacimiento"),
                                                                    rs.getString("email"),rs.getInt("telefono"));                              
                          } 
            
              BIRTHDAY();
             } 
        
        catch (Exception e)
         {
            System.err.println("ERROR AL OBTENER LOS DATOS. " + e );
         }
      } 
    
    //CUMPLEAÑOS
    public static void BIRTHDAY (){
        
          
        PreparedStatement ps;
        ResultSet rs;               
        
        try
           {   
            String Q = "SELECT * FROM contactos WHERE DAY(fechaNacimiento)= day(NOW()) AND MONTH(fechaNacimiento)=month(NOW());";
            
            ps = con.getConnection().prepareStatement(Q);
            rs = ps.executeQuery(Q);
            
            while(rs.next())
            {  
                System.out.println("");
                System.out.println("HOY ES EL CUMPLEAÑOS DE: " +rs.getString("nombre").toUpperCase()+ "  " +rs.getString("apellido").toUpperCase()+"!!!");    
            }               
        }
        catch(Exception e){
         }
        }            
             
    
    //BUSCAR UN CONTACTO
    public static void SEARCH (){
        
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps;
        ResultSet rs;        
        
             System.out.println("Ingresar el nombre o apellido del contacto: ");
             String Name = sc.next();
              
        try 
        {
            String Q = "SELECT * FROM contactos WHERE nombre like '"+Name+"' OR apellido like '"+Name+"' " ;
            
            ps = con.getConnection().prepareStatement(Q);
            rs = ps.executeQuery(Q);      
            
            System.out.printf("%-15s %-15s %-15s %-15s %15s %n", "NOMBRE", "APELLIDO", "NACIMIENTO", "EMAIL", "TELEFONO");
                                  
            while(rs.next()){
                        
            System.out.printf("%-15s %-15s %-15s %-15s %15s %n", rs.getString("nombre"), rs.getString("apellido"), 
                                                                 rs.getDate("fechaNacimiento"), rs.getString("email"), rs.getInt("telefono"));
               }      
            
            }catch (Exception e)
         {
             System.err.println("ERROR AL OBTENER LOS DATOS. " + e );
         }
        
       }    
        
        
    //AGREGAR UN CONTACTO    
    public static void ADD (){
        
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps;  
        
              System.out.println("Ingresar el nombre: ");
              String Name = sc.next();              
              System.out.println("Ingresar el apellido: ");
              String Surname = sc.next();            
              System.out.println("Ingresar la fecha de nacimiento: (yyyy/MM/dd) ");
              String SBirth = sc.next();    
              System.out.println("Ingresar el email: ");
              String Email = sc.next();  
              System.out.println("Ingresar el telefono: ");
              String Phone3 = sc.next();
              int Phone = Integer.parseInt(Phone3);  
              
        try 
        {   
            String Q = "INSERT INTO contactos (`nombre`, `apellido`, `fechaNacimiento` , `email` , `telefono`) "
                     + "VALUES ( ? , ? , ? , ? , ? );";
            
            ps = con.getConnection().prepareStatement(Q);
            ps.setString(1 , Name );
            ps.setString(2 , Surname );            
            ps.setString(3 , SBirth);
            ps.setString(4 , Email );
            ps.setInt(5 , Phone );
            
            int resultRowCount = ps.executeUpdate();
            
            if(resultRowCount > 0) {
               System.out.println("El contacto se agrego correctamente" );
            }else{
             System.out.println("NO se agrego el contacto");
            }   
         } 
        
        catch (Exception e)
         {
            System.err.println("ERROR AL OBTENER LOS DATOS. " + e );
         }
      } 
    
    
    //MODIFICAR UN CONTACTO
    public static void UPDATE ( ){
        
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps;
        
             System.out.println("Ingresar el nombre del contacto a modificar: ");
             String Name = sc.next();
             
             System.out.println("Ingresar el nuevo nombre: ");
             String Newname = sc.next();
             
        try 
        {
            String Q = "UPDATE contactos SET nombre = ? WHERE nombre = ? ;" ;
            
            ps = con.getConnection().prepareStatement(Q);
            ps.setString(1 , Newname.toLowerCase() );
            ps.setString(2 , Name.toLowerCase() );
            
            int resultRowCount = ps.executeUpdate();
           
            if(resultRowCount > 0) {
               System.out.println("El contacto se modifico correctamente" );
            }else{
               System.out.println("El contacto NO se modifico");
            }  
         } 
        
        catch (Exception e)
         {
            System.err.println("ERROR AL OBTENER LOS DATOS. " + e );
         }
       }
    
    
    //BORRAR UN CONTACTO
    public static void DELETE (){
        
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps;
        
            System.out.println("Ingresar el nombre del contacto a borrar: ");
            String name = sc.next();
            
        try 
        {
            String Q = "UPDATE contactos SET estado = ? WHERE nombre = ? ;";
            
            ps = con.getConnection().prepareStatement(Q);
            ps.setInt(1 , 0);
            ps.setString(2 , name.toLowerCase());
            
            int resultRowCount = ps.executeUpdate();
            
            if(resultRowCount > 0) {
               System.out.println("El contacto se borro correctamente");
            }else{
               System.out.println("El nombre que ingreso no existe");
            }
        } 
        
        catch (Exception e)
         {
            System.err.println("ERROR AL OBTENER LOS DATOS. " + e );
         }
       }  
     }