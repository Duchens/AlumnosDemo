/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jean.jpacontroller;

import com.jean.jpa.Direccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jean
 */
@Stateless
public class DireccionFacade extends AbstractFacade<Direccion> {
    @PersistenceContext(unitName = "AlumnosDemoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }
    
}
