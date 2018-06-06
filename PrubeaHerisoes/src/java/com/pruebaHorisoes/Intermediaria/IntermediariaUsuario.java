/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Intermediaria;

import com.pruebaHorisoes.Modelo.InterfaceMenu;
import com.pruebaHorisoes.Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Hamilton Jojoa
 */
public class IntermediariaUsuario 
{
    private List<InterfaceMenu> listaMenus;
    private Usuario usuario;
    private Integer cedulaIngresada;
    private String contrasenaIngresada;
    private String rolSeleccionado;

    public List<InterfaceMenu> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<InterfaceMenu> listaMenus) {
        this.listaMenus = listaMenus;
    }

    
    
    public String getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(String rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }
    

    public IntermediariaUsuario()
    {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCedulaIngresada() {
        return cedulaIngresada;
    }

    public void setCedulaIngresada(Integer cedulaIngresada) {
        this.cedulaIngresada = cedulaIngresada;
    }

    public String getContrasenaIngresada() {
        return contrasenaIngresada;
    }

    public void setContrasenaIngresada(String contrasenaIngresada) {
        this.contrasenaIngresada = contrasenaIngresada;
    }
    
    
}
