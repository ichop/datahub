package com.agency.space.datahub.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/*
Simple JavaBean domain object that represents Mission
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class Mission extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ImageryType imageryType;

    @NotNull
    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
