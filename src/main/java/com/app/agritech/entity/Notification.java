package com.app.agritech.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table( name = "notification" )
@Data
public class Notification {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    @Column
    private String notificationTitle;

    @Column
    private String notificationDetail;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private UserDetails user;

    @Column
    private boolean seen;

    @Column
    @Temporal( TemporalType.TIME )
    private Date createdDate;

    @Column
    private String mappedUrl;

}
