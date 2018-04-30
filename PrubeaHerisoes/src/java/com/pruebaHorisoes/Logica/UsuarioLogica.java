/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Logica;

import com.pruebaHorisoes.Dao.UsuarioDao;
import com.pruebaHorisoes.Intermediaria.IntermediariaUsuario;

/**
 *
 * @author Hamilton Jojoa
 */
public class UsuarioLogica 
{
    UsuarioDao dao;
    
    public UsuarioLogica()
    {
        if(dao == null)
        {
            dao = new UsuarioDao();
        }
     
    }
    
    public void buscarUsuarioPorCedula(IntermediariaUsuario inter)
    {
        dao.encontrarPorCedula(inter);
    }
    
}
