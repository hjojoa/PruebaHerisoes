/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Intermediaria;

import com.pruebaHorisoes.Modelo.Usuario;

/**
 *
 * @author Hamilton Jojoa
 */
public class IntermediariaUsuario 
{
    private Usuario usuario;
    private Integer cedulaIngresada;
    
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
    
    
}
