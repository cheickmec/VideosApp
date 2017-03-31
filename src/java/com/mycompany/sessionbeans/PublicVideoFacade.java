/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.sessionbeans;

import com.mycompany.entityclasses.PublicVideo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Berthe
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

    /*
    ------------------------------------
    Search Category: VIDEO TITLE
    ------------------------------------
     */
    /**
     * Searches UsersVideosDB for videos where the video title contains the
     * searchString entered by the user
     *
     * @param searchString contains the search string the user entered for
     * searching the video titles
     * @return A list of PublicVideos object references as the search results
     */
    public List<PublicVideo> videoTitleQuery(String searchString) {
        //Place the % wildcard before and after the search string to search for 
        // it anywhere in the video title
        searchString = "%" + searchString + "%";
        //Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager()
                .createQuery("SELECT p FROM PublicVideo p WHERE p.title LIKE :searchString")
                .setParameter("searchString", searchString).getResultList();
    }

    /*
    -----------------------------------------
    Search Category: VIDEO DESCRIPTION
    -----------------------------------------
     */
    /**
     * Searches UsersVideosDB for videos where the video description contains
     * the searchString entered by the user
     *
     * @param searchString contains the search string the user entered for
     * searching the video description
     * @return A list of PublicVideos object references as the search results
     */
    public List<PublicVideo> videoDescriptionQuery(String searchString) {
        //Place the % wildcard before and after the search string to search for 
        // it anywhere in the video title
        searchString = "%" + searchString + "%";
        //Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager()
                .createQuery("SELECT p FROM PublicVideo p WHERE p.description LIKE :searchString")
                .setParameter("searchString", searchString).getResultList();
    }

    /*
    -----------------------------------------
    Search Category: VIDEO CATEGORY
    -----------------------------------------
     */
    /**
     * Searches UsersVideosDB for videos where the video category name contains
     * the searchString entered by the user
     *
     * @param searchString contains the search string the user entered for
     * searching the video category
     * @return A list of PublicVideos object references as the search results
     */
    public List<PublicVideo> videoCategoryQuery(String searchString) {
        //Place the % wildcard before and after the search string to search for 
        // it anywhere in the video title
        searchString = "%" + searchString + "%";
        //Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager()
                .createQuery("SELECT p FROM PublicVideo p WHERE p.category LIKE :searchString")
                .setParameter("searchString", searchString).getResultList();
    }

    /*
    -----------------------------------------
    Search Category: ALL
    -----------------------------------------
     */
    /**
     * Searches UsersVideosDB for videos where the video title, description, or category name contains
     * the searchString entered by the user
     *
     * @param searchString contains the search string the user entered for
     * searching video title, description, or category names
     * @return A list of PublicVideos object references as the search results
     */
    public List<PublicVideo> allQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the name 
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager()
                .createQuery("SELECT p FROM PublicVideo p WHERE p.title LIKE :searchString OR p.description LIKE :searchString OR p.category LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    
    }

}
