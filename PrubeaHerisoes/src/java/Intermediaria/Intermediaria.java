/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediaria;

import Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hamilton Jojoa
 */
public class Intermediaria 
{
    private List<Vehiculo> listaVehiculos;
    private Vehiculo vehiculoSeleccionado;
    private Vehiculo vehiculo;
    
    
    public Intermediaria()
    {
        listaVehiculos = new ArrayList();
        vehiculoSeleccionado = new Vehiculo();
        vehiculo = new Vehiculo();
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    
    
}
