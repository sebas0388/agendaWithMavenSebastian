/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendawithmaven;
import java.sql.*;

/**
 *
 * @author SebastianR
 */
public class main {    
public static void main(String[] args) throws SQLException {
        
        agenda a = agenda.getUser(13);
        if(a == null){
            System.out.println("USUARIO NO ENCONTRADO");
            System.exit(0);
        }
        
        System.out.println("IDUSUARIO: " + a.getIdContacto());
        System.out.println("NOMBRE: " + a.getNombre());
        System.out.println("APELLIDO: " + a.getApellido());
        System.out.println("EDAD: " + a.getEdad());
        
   
        
        
    }    
}
