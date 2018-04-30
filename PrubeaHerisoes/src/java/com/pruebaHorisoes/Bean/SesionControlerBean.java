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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    IntermediariaUsuario inter;
    Usuario usuario;
    UsuarioLogica usuarioLogica;
    
    public SesionControlerBean()
    {
        if(usuario == null)
        {
            usuario = new Usuario();
        }
        if(inter== null)
        {
            inter = new IntermediariaUsuario();
        }
        if(usuarioLogica == null)
        {
            usuarioLogica = new UsuarioLogica();
        }
    }

    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void revisarSesion()
    {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        try 
        {
            System.out.println("Antes de ingresar: "+usuario.getNombre());
            if(usuario.getCedula()!=null)
            {
                redirigir();
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println("algo fallo");
        }
    }
    public void validarSesion()
    {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        try 
        {
            System.out.println("Antes de ingresar: "+req.getSession().getId());
            if(usuario.getCedula()==null)
            {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PrubeaHerisoes.xhtml");
            }
            else
            {
                //FacesContext.getCurrentInstance().getExternalContext().redirect("publico/Login/login.xhtml");
            }
        }
        catch (Exception e) 
        {
            System.out.println("algo fallo");
        } 
    }
    private void redirigir()
    {
        try
        {
            switch(usuario.getTipo())
            {
                case "Administrador":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/PrubeaHerisoes/index.xhtml");
                    break;
                case "Vendedor":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/PrubeaHerisoes/vendedor.xhtml");
                    break;
                
            }
        }
        catch (IOException ex) 
        {
            try
            {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PrubeaHerisoes/salir.xhtml");
            }
            catch(IOException e)
            {
                
            }
        }
    }
    public void login() throws IOException 
    {
       
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (req.getUserPrincipal() == null) {
            try {
                System.out.println("Ingreso: "+req.getSession().getId());
                req.login(usuario.getTipo(), usuario.getContrasena());
                usuarioLogica.buscarUsuarioPorCedula(this.inter);
                usuario = inter.getUsuario();
                if(!usuario.getCedula().equals(usuario.getCedula()))
                    logout();
                this.redirigir();
                
            } catch (ServletException ex) {
              // Logger.getLogger(SessionController.class.getName()).log(Level.SEVERE, null, ex);
               mensajeErrorAut();
                
            }
        }
    }
    public void logout() throws IOException, ServletException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            
            req.logout();
            req.getSession().invalidate();
            fc.getExternalContext().invalidateSession();
            System.out.println("logout");
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");

        } catch (ServletException e) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "FAILED", "Logout failed on backend"));
        }

    }
    
      public void mensajeErrorAut() {
        addMessage("Datos No Validos .", "");
        }
      private void addMessage(String summary, String detail) {
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
