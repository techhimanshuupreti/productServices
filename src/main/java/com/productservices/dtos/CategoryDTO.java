package com.productservices.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7165415861432774758L;

    private String name;
    private String descriptions;
    private String shortDescriptions;
}
