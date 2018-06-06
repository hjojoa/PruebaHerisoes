/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Logica;

import com.pruebaHorisoes.Dao.InterfaceDao;
import com.pruebaHorisoes.Intermediaria.IntermediariaInterfaces;

/**
 *
 * @author Hamilton Jojoa
 */
public class InterfaceLogica {
    
    InterfaceDao dao;
    
    public InterfaceLogica()
    {
        dao = new InterfaceDao();
    }
    public void cargarMenusAdministrador(IntermediariaInterfaces inter)
    {
        inter.setListaMenus(dao.listarMenuAdministrador());
    }
    public void cargarMenusVendedor(IntermediariaInterfaces inter)
    {
        inter.setListaMenus(dao.listarMenuVendedor());
    }
}
