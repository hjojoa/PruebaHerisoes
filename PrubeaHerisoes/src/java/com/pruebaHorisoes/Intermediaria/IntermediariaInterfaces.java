/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Intermediaria;

import com.pruebaHorisoes.Modelo.InterfaceMenu;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Hamilton Jojoa
 */
public class IntermediariaInterfaces {
    
    private List<InterfaceMenu> listaMenus;
    private String rolSeleccionado;
    
    
    public IntermediariaInterfaces()
    {
        listaMenus = new ArrayList();
        
    }

    public String getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(String rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    
    public List<InterfaceMenu> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<InterfaceMenu> listaMenus) {
        this.listaMenus = listaMenus;
    }
    
     
}
