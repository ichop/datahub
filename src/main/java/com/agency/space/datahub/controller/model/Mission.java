package com.agency.space.datahub.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/*
Simple JavaBean domain object that represents Mission
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class Mission extends BaseEntity {
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private ImageryType imageryType;
    private Date startDate;
    private Date endDate;
}
