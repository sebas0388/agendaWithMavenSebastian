/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendawithmaven;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SebastianR
 */
public class agenda {
    
   static dataBaseConnection con = dataBaseConnection.getInstance();
        
        private int idContacto;
        private String nombre;
        private String apellido;
        private int edad;

public static void setCon(dataBaseConnection con) {
        agenda.con = con;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static dataBaseConnection getCon() {
        return con;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

public static agenda getUser(int idContacto) throws SQLException{
        String query = "select * from contactos where idContacto= ?;";
        if(con != null){
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, idContacto);
            
            agenda a = new agenda();
            
            ResultSet rs = ps.executeQuery();
            
            boolean isValid = false;
            
            while (rs.next()) {
            isValid = true;
            a.idContacto = rs.getInt("idContacto");
            a.nombre = rs.getString("nombre");
            a.apellido = rs.getString("apellido");
            a.edad = rs.getInt("edad");
 
            }
            ps.close();
            
            if (isValid == true)
                    {
                        return a;
                    }
            
            else    {
                    return null;
                    }
        }
        
        
          return null;
        
        
       
    }
}
