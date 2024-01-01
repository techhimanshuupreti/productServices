package com.productservices.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class SubCategoryDTO implements Serializable {

    private String name;
    private String descriptions;
    private String shortDescriptions;
    private String categoryId;
}
