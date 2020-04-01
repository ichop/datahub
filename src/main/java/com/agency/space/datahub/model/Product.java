package com.agency.space.datahub.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
public class Product extends BaseEntity {

    @NotNull
    @ManyToOne
    private Mission mission;

    @NotNull
    private LocalDateTime acquisitionDate;

    @NotNull
    @ElementCollection
    @CollectionTable(
            name = "COORDINATES",
            joinColumns = @JoinColumn(name = "PROD_ID")
    )
    private List<Coordinate> footprint;

    @NotNull
    private BigDecimal price;


    @NotNull
    @Column(unique = true)
    private String picUrl;
}
