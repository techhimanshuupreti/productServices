package com.productservices.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -46420887205954797L;

    private String companyName;
    private String productNumber;
    private String distributorSupplierName;
    private String subCategoryId;
    private double price;
    private String name;
    private String descriptions;
    private String shortDescriptions;
}
