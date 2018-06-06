/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaHorisoes.Bean;

import com.pruebaHorisoes.Intermediaria.IntermediariaUsuario;
import com.pruebaHorisoes.Logica.UsuarioLogica;
import com.pruebaHorisoes.Modelo.InterfaceMenu;
import com.pruebaHorisoes.Modelo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
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
@SessionScoped
@ManagedBean
public class SesionControlerBean 
{
    private IntermediariaUsuario inter;
    private UsuarioLogica usuarioLogica;
    private MenuModel menu;

    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }
    
   
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
                return "faces/Administrador/Administrador.xhtml?faces-redirect=true";
            }
            else if(usuario.getTipo().equalsIgnoreCase("Vendedor"))
            {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                return "faces/Vendedor/Vendedor.xhtml?faces-redirect=true";
            }
            else
            {
                return "faces/login.xhtml?faces-redirect=true";
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
                        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
                    }
                    else if(usuario.getTipo().equalsIgnoreCase("Vendedor") && !tipoPagina.equalsIgnoreCase("Vendedor"))
                    {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
                    }
                    if(usuario.getTipo().equalsIgnoreCase("Administrador") && tipoPagina.equalsIgnoreCase("Administrador") )
                    {
                        usuarioLogica.cargarMenusAdministrador(inter);
                        menu = new DefaultMenuModel();
                        DefaultSubMenu submenu = new DefaultSubMenu();
                        List<InterfaceMenu> listado = inter.getListaMenus();
                        for(int i = 0; i<listado.size();i++)
                        {
                            String nombre = listado.get(i).getMenuNombre();
                            submenu = new DefaultSubMenu(nombre);
                            menu.addElement(submenu);
                        }
                        this.inter.setRolSeleccionado("Administrador");
                    }
                    if(usuario.getTipo().equalsIgnoreCase("Vendedor") && tipoPagina.equalsIgnoreCase("Vendedor"))
                    {
                        usuarioLogica.cargarMenusVendedor(inter);
                        menu = new DefaultMenuModel();
                        DefaultSubMenu submenu = new DefaultSubMenu();
                        List<InterfaceMenu> listado = inter.getListaMenus();
                        for(int i = 0; i<listado.size();i++)
                        {
                            String nombre = listado.get(i).getMenuNombre();
                            submenu = new DefaultSubMenu(nombre);
                            menu.addElement(submenu);
                        }
                    }
                }
                else
                {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
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
