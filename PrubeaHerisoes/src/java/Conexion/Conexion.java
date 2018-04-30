/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hamilton Jojoa
 */
public class Conexion 
{
    Connection conexion;
    
    public Conexion(Connection conexion)
    {
        this.conexion = conexion;
    }
    public Conexion()
    {
        
    }
    
    public void realizarConexion()  
    {
        String conexion  = "jdbc:postgresql://localhost:5432/pruebaHerisoes";
        String usuario = "postgres" ;
        String contrasena = "tp4Dk0Kr" ;
        
        try
        {
            Class.forName("org.postgresql.Driver");
            this.conexion = DriverManager.getConnection(conexion,usuario, contrasena);
            System.out.println("Conexión exitosa");
        }
        catch(SQLException  | ClassNotFoundException e)
        {
            System.out.println("Error realizando la conexión a la base de datos: "+ e);
        }
    }
    
    public Connection getConxion()
    {
        return this.conexion;
    }
}
