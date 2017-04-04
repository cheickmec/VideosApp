/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.sessionbeans;

import com.mycompany.entityclasses.UserVideo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author berth
 */
@Stateless
public class UserVideoFacade extends AbstractFacade<UserVideo> {

    @PersistenceContext(unitName = "Videos-BerthePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserVideoFacade() {
        super(UserVideo.class);
    }

    //The following method is added to the generated code
    public List<UserVideo> findVideosByUserID(Integer userID) {
        return (List<UserVideo>) em.createNamedQuery("UserVideo.findByUserId")
                .setParameter("userId", userID)
                .getResultList();
    }

}
