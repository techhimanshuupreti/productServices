package com.productservices.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class SubCategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3105438494834129933L;

    private String name;
    private String descriptions;
    private String shortDescriptions;
    private String categoryId;
}
