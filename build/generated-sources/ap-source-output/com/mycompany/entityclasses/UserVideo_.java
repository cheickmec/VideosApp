package com.mycompany.entityclasses;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-26T22:35:16")
@StaticMetamodel(UserVideo.class)
public class UserVideo_ { 

    public static volatile SingularAttribute<UserVideo, String> duration;
    public static volatile SingularAttribute<UserVideo, Date> datePublished;
    public static volatile SingularAttribute<UserVideo, String> youtubeVideoId;
    public static volatile SingularAttribute<UserVideo, String> description;
    public static volatile SingularAttribute<UserVideo, Integer> id;
    public static volatile SingularAttribute<UserVideo, String> title;
    public static volatile SingularAttribute<UserVideo, String> category;
    public static volatile SingularAttribute<UserVideo, Integer> userId;

}