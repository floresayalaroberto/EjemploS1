/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.dao;

import com.aerolinea.entidad.Aeropuerto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alvaro
 */
@Stateless
public class AeropuertoFacade extends AbstractFacade<Aeropuerto> {

    @PersistenceContext(unitName = "EjemploS1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AeropuertoFacade() {
        super(Aeropuerto.class);
    }
    
    
    
}
