/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.managers;

import com.mycompany.entityclasses.User;
import com.mycompany.sessionbeans.UserFacade;
import com.mycompany.sessionbeans.UserPhotoFacade;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

@Named(value = "accountManager")

/*
The @SessionScoped annotation preserves the values of the AccountManager
object's instance variables across multiple HTTP request-response cycles
as long as the user's established HTTP session is alive.
 */
@SessionScoped
/**
 *
 * @author Berthe
 */
public class AccountManager implements Serializable {

    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */
    private String username;
    private String password;
    private String newPassword;

    private String firstName;
    private String middleName;
    private String lastName;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;

    private int securityQuestion;
    private String securityAnswer;

    private String email;

    private final String[] listOfStates = Constants.STATES;
    private Map<String, Object> security_questions;
    private String statusMessage;

    private User selected;

    /*
    The instance variable 'userFacade' is annotated with the @EJB annotation.
    The @EJB annotation directs the EJB Container (of the GlassFish AS) to inject (store) the object reference
    of the UserFacade object, after it is instantiated at runtime, into the instance variable 'userFacade'.
     */
    @EJB
    private UserFacade userFacade;

    /*
    The instance variable 'userPhotoFacade' is annotated with the @EJB annotation.
    The @EJB annotation directs the EJB Container (of the GlassFish AS) to inject (store) the object reference 
    of the UserPhotoFacade object, after it is instantiated at runtime, into the instance variable 'userPhotoFacade'.
     */
    @EJB
    private UserPhotoFacade userPhotoFacade;

    /*
    =========================
    Getter and Setter Methods
    =========================
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(int securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getSecurity_questions() {
        if (security_questions == null) {
            /*
            Difference between HashMap and LinkedHashMap:
            HashMap stores key-value pairings in no particular order. 
                Values are retrieved based on their corresponding Keys.
            LinkedHashMap stores and retrieves key-value pairings
                in the order they were put into the map.
             */
            security_questions = new LinkedHashMap<>();

            for (int i = 0; i < Constants.QUESTIONS.length; i++) {
                security_questions.put(Constants.QUESTIONS[i], i);
            }
        }
        return security_questions;
    }

    public void setSecurity_questions(Map<String, Object> security_questions) {
        this.security_questions = security_questions;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public User getSelected() {
        return selected;
    }

    public void setSelected(User selected) {
        this.selected = selected;
    }

    public String[] getListOfStates() {
        return listOfStates;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public UserPhotoFacade getUserPhotoFacade() {
        return userPhotoFacade;
    }

    public void setUserPhotoFacade(UserPhotoFacade userPhotoFacade) {
        this.userPhotoFacade = userPhotoFacade;
    }

    /*
    ================
    Instance Methods
    ================
     */
    // Return True if a user is logged in; otherwise, return False
    public boolean isLoggedIn() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username") != null;
    }

    /*Log out user*/
    public String logout() {

        // Clear the logged-in User's session map
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();

        // Reset the logged-in User's properties
        username = password = "";
        firstName = middleName = lastName = "";
        address1 = address2 = city = state = zipcode = "";
        securityQuestion = 0;
        securityAnswer = "";
        email = statusMessage = "";

        // Invalidate the logged-in User's session
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        // Redirect to show the index (Home) page
        return "index.xhtml?faces-redirect=true";
    }

    /**
     * Initialize the session map for the User object
     */
    public void initializeSessionMap() {

        // Obtain the object reference of the User object
        User user = getUserFacade().findByUsername(getUsername());

        // Put the User's object reference into session map variable user
        FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().put("user", user);

        // Put the User's database primary key into session map variable user_id
        FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().put("user_id", user.getId());
    }

    /**
     * Validate if the entered password matches the entered confirm password
     *
     * @param event postValidation event
     */
    public void validateInformation(ComponentSystemEvent event) {
        
        /*
        FacesContext contains all of the per-request state information related to the processing of
        a single JavaServer Faces request, and the rendering of the corresponding response.
        It is passed to, and potentially modified by, each phase of the request processing lifecycle.
         */
        FacesContext fc = FacesContext.getCurrentInstance();

        /*
        UIComponent is the base class for all user interface components in JavaServer Faces. 
        The set of UIComponent instances associated with a particular request and response are organized into
        a component tree under a UIViewRoot that represents the entire content of the request or response.
         */
        // Obtain the UIComponent instances associated with the event
        UIComponent components = event.getComponent();

        /*
        UIInput is a kind of UIComponent for the user to enter a value in.
         */
        // Obtain the object reference of the UIInput field with id="password" on the UI
        UIInput uiInputPassword = (UIInput) components.findComponent("password");

        // Obtain the password entered in the UIInput field with id="password" on the UI
        String entered_password = uiInputPassword.getLocalValue()
                == null ? "" : uiInputPassword.getLocalValue().toString();

        // Obtain the object reference of the UIInput field with id="confirmPassword" on the UI
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmPassword");

        // Obtain the confirm password entered in the UIInput field with id="confirmPassword" on the UI
        String entered_confirm_password = uiInputConfirmPassword.getLocalValue()
                == null ? "" : uiInputConfirmPassword.getLocalValue().toString();

        if (entered_password.isEmpty() || entered_confirm_password.isEmpty()) {
            // Do not take any action. 
            // The required="true" in the XHTML file will catch this and produce an error message.
            return;
        }

        if (!entered_password.equals(entered_confirm_password)) {
            statusMessage = "Password and Confirm Password must match!";
        } else {
            statusMessage = "";
        }
    }

    /**
     * Create a new new user account.
     *
     * @return "" if an error occurs; otherwise, upon successful account
     * creation, redirect to show the SignIn page.
     */
    public String createAccount() {

        // First, check if the entered username is already being used
        // Obtain the object reference of a User object with username
        User aUser = getUserFacade().findByUsername(username);

        if (aUser != null) {
            // A user already exists with the username entered
            username = "";
            statusMessage = "Username already exists! Please select a different one!";
            return "";
        }

        // The entered username is available
        if (statusMessage == null || statusMessage.isEmpty()) {
            try {
                // Instantiate a new User object
                User newUser = new User();

                /*
                Set the properties of the newly created newUser object with the values
                entered by the user in the AccountCreationForm in CreateAccount.xhtml
                 */
                newUser.setFirstName(firstName);
                newUser.setMiddleName(middleName);
                newUser.setLastName(lastName);
                newUser.setAddress1(address1);
                newUser.setAddress2(address2);
                newUser.setCity(city);
                newUser.setState(state);
                newUser.setZipcode(zipcode);
                newUser.setSecurityQuestion(securityQuestion);
                newUser.setSecurityAnswer(securityAnswer);
                newUser.setEmail(email);
                newUser.setUsername(username);
                newUser.setPassword(password);

                getUserFacade().create(newUser);

            } catch (EJBException e) {
                username = "";
                statusMessage = "Something went wrong while creating user's account! See: " + e.getMessage();
                return "";
            }
            // Initialize the session map for the newly created User object
            initializeSessionMap();

            /*
            The Profile page cannot be shown since the new User has not signed in yet.
            Therefore, we show the Sign In page for the new User to sign in first.
             */
            return "SignIn.xhtml?faces-redirect=true";
        }
        return "";
    }
}
