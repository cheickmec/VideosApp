/*
 * Created by Cheick Berthe on 2017.03.30  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.videoSearch;

import com.mycompany.sessionbeans.PublicVideoFacade;

import com.mycompany.entityclasses.PublicVideo;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Berthe
 */

@Named(value = "searchedVideoController")
@SessionScoped
public class searchedVideoController implements Serializable {

    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */
    private String searchKeyword;
    private String searchCategory;
    private List<PublicVideo> searchItems = null;

    /*
    publicVideoFacade is a reference (pointer) to an object that belongs to the PublicVideoFacade class. 
    It is annotated with the @EJB annotation implying that the GlassFish application server, at runtime, 
    will inject in this instance variable, a reference to the @Stateless session bean PublicVideoFacade.
     */
    @EJB
    private com.mycompany.sessionbeans.PublicVideoFacade publicVideoFacade;

    /*
    =========================
    Getter and Setter Methods
    =========================
     */

    public PublicVideoFacade getPublicVideoFacade() {
        return publicVideoFacade;
    }

    public void setPublicVideoFacade(PublicVideoFacade publicVideoFacade) {
        this.publicVideoFacade = publicVideoFacade;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchCategory() {
        return searchCategory;
    }

    public void setSearchCategory(String searchCategory) {
        this.searchCategory = searchCategory;
    }
 

    /**
     * Return the list of object references of all those companies where 
     * the search string 'searchString' entered by the user is contained in the searchField.
     * @return result of search
     */
    public List<PublicVideo> getSearchItems() {
        switch (searchCategory) {
            case "title":
                return getPublicVideoFacade().videoTitleQuery(searchKeyword);
            case "description":
                return getPublicVideoFacade().videoDescriptionQuery(searchKeyword);
            case "category":
                return getPublicVideoFacade().videoCategoryQuery(searchKeyword);
            default:
                return getPublicVideoFacade().allQuery(searchKeyword);
        }
    }

    /*
    =========================
    Instance Methods
    =========================
     */

    /**
     * @SessionScoped enables to preserve the values of the instance variables
     * for the SearchResults.xhtml page to access.
     *
     * @throws IOException if the page to be redirected to cannot be found
     */
    public void search() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("SearchResults.xhtml");
    }

}
