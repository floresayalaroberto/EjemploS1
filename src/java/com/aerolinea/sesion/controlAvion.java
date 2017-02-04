/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.sesion;

import com.aerolinea.dao.AvionFacade;
import com.aerolinea.entidad.Avion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Alvaro
 */
@Stateless
public class controlAvion {

    @EJB
    private AvionFacade avionFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Avion> getAllAviones(){
        return avionFacade.findAll();
    }

}
