/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Intermediaria.Intermediaria;
import Modelo.Vehiculo;
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
public class VehiculoDao 
{
    Connection conexion;
    Statement st;
    public List<Vehiculo> listarVehiculo()
    {
         List<Vehiculo> listaVehiculo = new ArrayList();
        
        try
        {
            Conexion conexion = new Conexion();
            conexion.realizarConexion();
            
            this.conexion = conexion.getConxion();
            st = this.conexion.createStatement();
            
            String sql = "SELECT * FROM vehiculo";
            
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next())
            {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(resultSet.getInt("id_vehiculo"));
                vehiculo.setMarca(resultSet.getString("veh_marca"));
                vehiculo.setTipo(resultSet.getString("veh_tipo"));
                vehiculo.setPrecio(resultSet.getFloat("veh_precio"));
                listaVehiculo.add(vehiculo);
            }
            st.close();
            this.conexion.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrio un error listando las personas: "+e);
        }
        return listaVehiculo;
    }
    
    public void editarVehiculo(Intermediaria inter)
    {
        PreparedStatement preparedStatement = null;
        Conexion conexion = new Conexion();
        conexion.realizarConexion();
        this.conexion = conexion.getConxion();
        try
        {
            String sql = "UPDATE vehiculo "
                    + "SET veh_marca = ? , veh_tipo = ? , veh_precio = ? "
                    + "where id_vehiculo = ? ";
            preparedStatement = this.conexion.prepareStatement(sql);
            preparedStatement.setString(1, inter.getVehiculoSeleccionado().getMarca());
            preparedStatement.setString(2, inter.getVehiculoSeleccionado().getTipo());
            preparedStatement.setFloat(3, inter.getVehiculoSeleccionado().getPrecio());
            preparedStatement.setInt(4, inter.getVehiculoSeleccionado().getId());
            
            int resultadoActualizar = preparedStatement.executeUpdate();
            if(resultadoActualizar >0)
            {
                System.out.println("Se ha actualizado correctamente el vehiculo seleccionado");
            }
            else
            {
                System.out.println("ocurrió un error actualizando el vehiculo seleccionado");
            }
            this.conexion.close();
            preparedStatement.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrio un error realizando la conexión a la base de datos");
        }
    }
    
    public void eliminarVehiculo(Intermediaria inter)
    {
        PreparedStatement preparedStatement = null;
        Conexion conexion = new Conexion();
        conexion.realizarConexion();
        this.conexion = conexion.getConxion();
        try
        {
            String sql = "DELETE FROM vehiculo where id_vehiculo = ? ";
            
            preparedStatement = this.conexion.prepareStatement(sql);
            preparedStatement.setInt(1, inter.getVehiculoSeleccionado().getId());
            int resultadoActualizar = preparedStatement.executeUpdate();
            if(resultadoActualizar >0)
            {
                System.out.println("Se ha eliminado correctamente el vehiculo seleccionado");
            }
            else
            {
                System.out.println("ocurrió un error eliminando el vehiculo seleccionado");
            }
            this.conexion.close();
            preparedStatement.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrio un error realizando la conexión a la base de datos"+e);
        } 
    }
    
    public void agregarVehiculo(Intermediaria inter)
    {
        PreparedStatement preparedStatement = null;
        Conexion conexion = new Conexion();
        conexion.realizarConexion();
        this.conexion = conexion.getConxion();
        try
        {
            String sql ="INSERT INTO vehiculo(veh_marca, veh_tipo, veh_precio) VALUES ( ?, ?, ?);";
            
            preparedStatement = this.conexion.prepareStatement(sql);
            preparedStatement.setString(1, inter.getVehiculo().getMarca());
            preparedStatement.setString(2, inter.getVehiculo().getTipo());
            preparedStatement.setFloat(3, inter.getVehiculo().getPrecio());
            
            if(!preparedStatement.execute())
            {
                System.out.println("Vehiculo guardado exitosamente!");
            }
            else
            {
                System.out.println("Ocurrio un error al guardar el vehiculo");
            }
            this.conexion.close();
            preparedStatement.close();
            
        }
        catch(SQLException e)
        {
            System.out.println("Ocurrió un error realizando la conexión a la base de datos"+e);
        }
    }
    
}
