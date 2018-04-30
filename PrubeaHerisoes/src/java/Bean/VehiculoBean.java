/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Intermediaria.Intermediaria;
import Logica.VehiculoLogica;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hamilton Jojoa
 */

@ManagedBean
@SessionScoped
public class VehiculoBean 
{
    private Intermediaria inter;
    private VehiculoLogica logica;
    
    public VehiculoBean()
    {
        inter = new Intermediaria();
        logica = new VehiculoLogica();
        logica.cargarVehiculos(inter);
    }

    public Intermediaria getInter() {
        return inter;
    }

    public void setInter(Intermediaria inter) {
        this.inter = inter;
    }

    public VehiculoLogica getLogica() {
        return logica;
    }

    public void setLogica(VehiculoLogica logica) {
        this.logica = logica;
    }
    
    public void editarVehiculo()
    {
        logica.editarVehiculo(inter);
        logica.cargarVehiculos(inter);
    }
    
    public void eliminarVehiculo()
    {
        logica.eliminarVehiculo(inter);
        logica.cargarVehiculos(inter);
    }
    
    public void agregarVehiculo()
    {
        logica.agregarVehiculo(inter);
        logica.cargarVehiculos(inter);
    }
    
    
}
