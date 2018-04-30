/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dao.VehiculoDao;
import Intermediaria.Intermediaria;
import Modelo.Vehiculo;

/**
 *
 * @author Hamilton Jojoa
 */
public class VehiculoLogica 
{
    VehiculoDao dao;
    
    public VehiculoLogica()
    {
        dao = new VehiculoDao();
    }
    
    public void cargarVehiculos(Intermediaria inter)
    {
        inter.setListaVehiculos(dao.listarVehiculo());
    }
    public void editarVehiculo(Intermediaria inter)
    {
        dao.editarVehiculo(inter);
       
    }
    
    public void eliminarVehiculo(Intermediaria inter)
    {
        dao.eliminarVehiculo(inter);
    }
    
    public void agregarVehiculo(Intermediaria inter)
    {
        dao.agregarVehiculo(inter);
    }
}
