/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jean.jpacontroller;

import com.jean.jpa.UsuarioRole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jean
 */
@Stateless
public class UsuarioRoleFacade extends AbstractFacade<UsuarioRole> {
    @PersistenceContext(unitName = "AlumnosDemoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRoleFacade() {
        super(UsuarioRole.class);
    }
    
}
