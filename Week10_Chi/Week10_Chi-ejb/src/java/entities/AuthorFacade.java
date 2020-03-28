/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CBui
 */
@javax.ejb.Stateless
public class AuthorFacade extends AbstractFacade<Author> implements AuthorFacadeLocal {

    @PersistenceContext(unitName = "Week10_Chi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthorFacade() {
        super(Author.class);
    }
    
}
