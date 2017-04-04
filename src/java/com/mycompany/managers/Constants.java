/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.managers;

/**
 *
 * @author berth
 */
public final class Constants {

    /* =========== Design Decision ===========
        We will be using directories external to our application 
        for the storage and retrieval of user's files.
    
        We do not want to use a database for the following reasons: 
            (a) Database storage and retrieval of large files as 
                BLOB (binary large object) degrades performance.
            (b) BLOBs increase the database complexity.
    
        Therefore, we use the following two external directories 
        for the storage and retrieval of user's files.
     */
    /**
     * For Linux/Mac
     */
    //public static final String PHOTOS_ABSOLUTE_PATH = "/home/cloudsd/Berthe/UserPhotoStorage/";
    /**
     * For Windows
     */
    public static final String PHOTOS_ABSOLUTE_PATH = "C:\\Users\\berth\\Documents\\CloudStorage\\UserPhotoStorage\\";

    /*
    In glassfish-web.xml file, we designated the '/CloudStorage/' directory as the
    Alternate Document Root directory with the following statement:
        
        <property name="alternatedocroot_1" value="from=/CloudStorage/* dir=/Users/Berthe" />
    
    Relative path is defined with respect to the Alternate Document Root starting with 'CloudStorage'.
     */
    /**
     * For Linux/Mac
     */
    //public static final String PHOTOS_RELATIVE_PATH = "UserPhotoStorage/";
    /**
     * For Windows
     */
    public static final String PHOTOS_RELATIVE_PATH = "CloudStorage\\UserPhotoStorage\\";

    /* Temporary filename */
    public static final String TEMP_FILE = "tmp_file";

    public static final Integer THUMBNAIL_SIZE = 200;
    /**
     * United States postal state abbreviations
     */
    public static final String[] STATES = {
        "AK", "AL", "AR", "AZ", "CA", "CO", "CT",
        "DC", "DE", "FL", "GA", "GU", "HI", "IA",
        "ID", "IL", "IN", "KS", "KY", "LA", "MA",
        "MD", "ME", "MH", "MI", "MN", "MO", "MS",
        "MT", "NC", "ND", "NE", "NH", "NJ", "NM",
        "NV", "NY", "OH", "OK", "OR", "PA", "PR",
        "PW", "RI", "SC", "SD", "TN", "TX", "UT",
        "VA", "VI", "VT", "WA", "WI", "WV", "WY"};

    /**
     * Security questions to reset password
     */
    public static final String[] QUESTIONS = {
        "In what city were you born?",
        "What is your mother's maiden name?",
        "What elementary school did you attend?",
        "What was the make of your first car?",
        "What is your father's middle name?",
        "What is the name of your most favorite pet?",
        "What street did you grow up on?"
    };

}
