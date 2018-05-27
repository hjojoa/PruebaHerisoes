/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Logica;

import com.pruebaHorisoes.Dao.UsuarioDao;
import com.pruebaHorisoes.Intermediaria.IntermediariaUsuario;
import com.pruebaHorisoes.Modelo.Usuario;
import java.sql.SQLException;

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
    public Usuario validarPorUsuario(IntermediariaUsuario inter) throws SQLException
    {
        Integer cedula = inter.getCedulaIngresada();
        String contrasena = inter.getContrasenaIngresada();
        Usuario usuario =dao.ValidarUsuario(cedula, contrasena);
        return usuario;
    }
    
}
