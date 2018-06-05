/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Bean;

import com.pruebaHorisoes.Intermediaria.IntermediariaUsuario;
import com.pruebaHorisoes.Logica.UsuarioLogica;
import com.pruebaHorisoes.Logica.VehiculoLogica;
import com.pruebaHorisoes.Modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Hamilton Jojoa
 */
@SessionScoped
@ManagedBean
public class SesionControlerBean 
{
    private IntermediariaUsuario inter;
    private UsuarioLogica usuarioLogica;
   
    public IntermediariaUsuario getInter() {
        return inter;
    }

    public void setInter(IntermediariaUsuario inter) {
        this.inter = inter;
    }

    public UsuarioLogica getUsuarioLogica() {
        return usuarioLogica;
    }

    public void setUsuarioLogica(UsuarioLogica usuarioLogica) {
        this.usuarioLogica = usuarioLogica;
    }
    
    
    
    public SesionControlerBean()
    {
        inter = new IntermediariaUsuario();
        usuarioLogica = new UsuarioLogica();
        
    }

    
    public String iniciarSesion()
    {
        
        try
        {
            Usuario usuario = usuarioLogica.validarPorUsuario(inter);
            if(usuario.getTipo().equalsIgnoreCase("Administrador"))
            {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                return "faces/index.xhtml?faces-redirect=true";
            }
            else if(usuario.getTipo().equalsIgnoreCase("Vendedor"))
            {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                return "faces/vendedor.xhtml?faces-redirect=true";
            }
            else
            {
                return "faces/login.xhtml";
            }
        }
        catch(Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Usuario o contraseña incorrecta"));
            return null;
        }

    }

        public void verificarSesion(String tipoPagina)
        {
            try 
            {
                Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                if(usuario!=null)
                    {
                    if(usuario.getTipo().equalsIgnoreCase("Administrador") && !tipoPagina.equalsIgnoreCase("Administrador") )
                    {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
                    }
                    else if(usuario.getTipo().equalsIgnoreCase("Vendedor") && !tipoPagina.equalsIgnoreCase("Vendedor"))
                    {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
                    }
                }
                else
                {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
                }
            } 
            catch (Exception e) 
            {
            }
        }
        
        public void cerrarSesion()
        {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
           
        }

}
