/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Dao;

import com.pruebaHorisoes.Conexion.Conexion;
import com.pruebaHorisoes.Modelo.InterfaceMenu;
import com.pruebaHorisoes.Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hamilton Jojoa
 */
public class InterfaceDao 
{
    Connection conexion;
    Statement st;
    public List<InterfaceMenu> listarMenuAdministrador()
    {
         List<InterfaceMenu> listaMenus = new ArrayList();
        
        try
        {
            Conexion conexion = new Conexion();
            conexion.realizarConexion();
            
            this.conexion = conexion.getConxion();
            st = this.conexion.createStatement();
            
            String sql = "SELECT * FROM opcion_menu where menu_rol_asociado = 'Administrativo'";
            
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next())
            {
                InterfaceMenu menu = new InterfaceMenu();
                menu.setMenuNombre(resultSet.getString("menu_nombre"));
                menu.setRolAsociado(resultSet.getString("menu_rol_asociado"));
                listaMenus.add(menu);
            }
            st.close();
            this.conexion.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrio un error listando las opciones de menú: "+e);
        }
        return listaMenus;
    }
    
    public List<InterfaceMenu> listarMenuVendedor()
    {
         List<InterfaceMenu> listaMenus = new ArrayList();
        
        try
        {
            Conexion conexion = new Conexion();
            conexion.realizarConexion();
            
            this.conexion = conexion.getConxion();
            st = this.conexion.createStatement();
            
            String sql = "SELECT * FROM opcion_menu where menu_rol_asociado = 'Vendedor'";
            
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next())
            {
                InterfaceMenu menu = new InterfaceMenu();
                menu.setMenuNombre(resultSet.getString("menu_nombre"));
                menu.setRolAsociado(resultSet.getString("menu_rol_asociado"));
                listaMenus.add(menu);
            }
            st.close();
            this.conexion.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrio un error listando las opciones de menú: "+e);
        }
        return listaMenus;
    }
    
    
}
