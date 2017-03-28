/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.sessionbeans;

import com.mycompany.entityclasses.PublicVideo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author berth
 */
@Stateless
public class PublicVideoFacade extends AbstractFacade<PublicVideo> {

    @PersistenceContext(unitName = "Videos-BerthePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicVideoFacade() {
        super(PublicVideo.class);
    }
    
}
