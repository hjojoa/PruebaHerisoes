/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Hamilton Jojoa
 */
@ManagedBean
public class ImagenesBean 
{
     private List<String> listaImagenes;
    
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
