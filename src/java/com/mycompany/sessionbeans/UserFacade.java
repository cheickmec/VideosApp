/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.sessionbeans;

import com.mycompany.entityclasses.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author berth
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "Videos-BerthePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    /*
    --------------------------------------------------------------
    The following code has been added to the auto-generated code 
    --------------------------------------------------------------
     */
    /**
     * Queries the User table of the UsersVideosDB database for the user entry
     * with the username matching the given username
     *
     * @param username is the username attribute value of the user
     * @return object reference of the User entity whose username is username
     */
    public User findByUsername(String username) {
        if (em.createQuery("SELECT u FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getResultList().isEmpty()) {
            return null;
        } else {
            return (User) (em.createQuery("SELECT u FROM User u WHERE u.username = :username")
                    .setParameter("username", username)
                    .getSingleResult());
        }
    }

}
