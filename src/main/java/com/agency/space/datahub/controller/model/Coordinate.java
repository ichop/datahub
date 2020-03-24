package com.agency.space.datahub.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Coordinate {

    private BigDecimal latitude;
    private BigDecimal longitude;


    public Coordinate(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
