/*
 * Created by Cheick Berthe on 2017.03.26  * 
 * Copyright © 2017 Cheick Berthe. All rights reserved. * 
 */
package com.mycompany.entityclasses;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author berth
 */
@Entity
@Table(name = "UserVideo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserVideo.findAll", query = "SELECT u FROM UserVideo u")
    , @NamedQuery(name = "UserVideo.findById", query = "SELECT u FROM UserVideo u WHERE u.id = :id")
    , @NamedQuery(name = "UserVideo.findByUserId", query = "SELECT u FROM UserVideo u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserVideo.findByTitle", query = "SELECT u FROM UserVideo u WHERE u.title = :title")
    , @NamedQuery(name = "UserVideo.findByDescription", query = "SELECT u FROM UserVideo u WHERE u.description = :description")
    , @NamedQuery(name = "UserVideo.findByYoutubeVideoId", query = "SELECT u FROM UserVideo u WHERE u.youtubeVideoId = :youtubeVideoId")
    , @NamedQuery(name = "UserVideo.findByDuration", query = "SELECT u FROM UserVideo u WHERE u.duration = :duration")
    , @NamedQuery(name = "UserVideo.findByDatePublished", query = "SELECT u FROM UserVideo u WHERE u.datePublished = :datePublished")
    , @NamedQuery(name = "UserVideo.findByCategory", query = "SELECT u FROM UserVideo u WHERE u.category = :category")})
public class UserVideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "youtube_video_id")
    private String youtubeVideoId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "duration")
    private String duration;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_published")
    @Temporal(TemporalType.DATE)
    private Date datePublished;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "category")
    private String category;

    public UserVideo() {
    }

    public UserVideo(Integer id) {
        this.id = id;
    }

    public UserVideo(Integer userId, String title, String description, String youtubeVideoId, String duration, Date datePublished, String category) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.youtubeVideoId = youtubeVideoId;
        this.duration = duration;
        this.datePublished = datePublished;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserVideo)) {
            return false;
        }
        UserVideo other = (UserVideo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entityclasses.UserVideo[ id=" + id + " ]";
    }

}
