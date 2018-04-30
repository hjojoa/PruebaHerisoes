/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Dao;

import com.pruebaHorisoes.Conexion.Conexion;
import com.pruebaHorisoes.Intermediaria.Intermediaria;
import com.pruebaHorisoes.Intermediaria.IntermediariaUsuario;
import com.pruebaHorisoes.Modelo.Usuario;
import com.pruebaHorisoes.Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hamilton Jojoa
 */
public class UsuarioDao 
{
    Connection conexion;
    Statement st;
    public boolean encontrarPorCedula(IntermediariaUsuario inter)
    {
        
        Usuario usuario = new Usuario();
        PreparedStatement preparedStatement = null;
        Conexion conexion = new Conexion();
        conexion.realizarConexion();
        this.conexion = conexion.getConxion();
        try
        {
            String sql = "SELECT FROM usuario WHERE id_usuario = ? ";
            
            preparedStatement = this.conexion.prepareStatement(sql);
            preparedStatement.setInt(1, inter.getCedulaIngresada());
            
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next())
            {
                
                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNombre(resultSet.getString("usu_nombre"));
                usuario.setCedula(resultSet.getInt("usu_cedula"));
                usuario.setTipo(resultSet.getString("usu_tipo"));
                usuario.setContrasena(resultSet.getString("usu_contrasena"));
                
            }
            st.close();
            this.conexion.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrio un error realizando la conexión a la base de datos"+e);
        } 
        if(usuario !=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
