/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.bean;

import com.aerolinea.dao.AvionFacade;
import com.aerolinea.entidad.Avion;
import com.aerolinea.sesion.controlAvion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alvaro
 */
@Named(value = "AvionBean")
@SessionScoped
public class AvionBean implements Serializable {

    @EJB
    private controlAvion controlAvion;
    private List<Avion> aviones;
    private Avion avion;
    private String accion;
    private AvionFacade avionFacade;
    
    public AvionBean() {
    }

    public void doAccion() {
        if (accion.equals("Modificar")) {
            modificarAvion();
        } else {
            agregarAvion();
        }
    }

    public void modificarAvion() {
        try {
            avionFacade.edit(avion);
//            limpiarObjetos();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Avion modificado."));
        } catch (Exception e) {
            System.out.println("Error al modificar avion " + e);
        }
    }
    
    
//    public String limpiarObjetos() {
//        avion = new Avion();
//        return "frmEmpleados.xhtml?faces-redirect=true";
//    }

    public void agregarAvion() {
        try {
            avionFacade.create(avion);
//            limpiarObjetos();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Avion agregado."));

        } catch (Exception e) {
            System.out.println("Error al agregar al avion : " + e);
        }
    }

    public List<Avion> getAviones() {
        aviones = controlAvion.getAllAviones();
        return aviones;
    }

    public controlAvion getControlAvion() {
        return controlAvion;
    }

    public void setControlAvion(controlAvion controlAvion) {
        this.controlAvion = controlAvion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public AvionFacade getAvionFacade() {
        return avionFacade;
    }

    public void setAvionFacade(AvionFacade avionFacade) {
        this.avionFacade = avionFacade;
    }
    
}
