package com.abhinav.base.entityOneToOne;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Address {
    private Integer streetNumber;
    private String location;
    private String state;
}
