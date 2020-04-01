package com.agency.space.datahub.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Coordinate {

    @NotNull
    private BigDecimal latitude;

    @NotNull
    private BigDecimal longitude;

}
