package com.agency.space.datahub.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
public class Product extends BaseEntity {

    @ManyToOne
    private Mission mission;
    private Date acquisitionDate;
    @ElementCollection
    @CollectionTable(
            name="COORDINATES",
            joinColumns = @JoinColumn(name = "PROD_ID")
    )
    private List<Coordinate> footprint;
    private BigDecimal price;
    private String picUrl;
}
