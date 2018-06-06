/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Bean;

import com.pruebaHorisoes.Intermediaria.IntermediariaInterfaces;
import com.pruebaHorisoes.Logica.InterfaceLogica;
import com.pruebaHorisoes.Modelo.InterfaceMenu;
import com.pruebaHorisoes.Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Hamilton Jojoa
 */
@ManagedBean
@SessionScoped      
public class InterfaceBean 
{
    
    private List<String> listaImagenes;
    private IntermediariaInterfaces inter;
    private InterfaceLogica logica;

      
    
    public InterfaceBean()
    {
        inter = new IntermediariaInterfaces();
        logica = new InterfaceLogica();
       
    }
  
    
    

    public IntermediariaInterfaces getInter() {
        return inter;
    }

    public void setInter(IntermediariaInterfaces inter) {
        this.inter = inter;
    }

    public InterfaceLogica getLogica() {
        return logica;
    }

    public void setLogica(InterfaceLogica logica) {
        this.logica = logica;
    }
    
    public void cargarImagenes()
    {
        listaImagenes = new ArrayList();
        for(int i =1; i<=4;i++)
        {
            listaImagenes.add("vehiculo"+i+".jpg");
        }
    }
    
    public List<String> getListaImagenes()
    {
        cargarImagenes();
        return listaImagenes;
    }

    
}
