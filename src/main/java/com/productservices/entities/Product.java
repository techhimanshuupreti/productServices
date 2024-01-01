package com.productservices.entities;


import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Product extends BaseEntity {

    @Column(name = "cmp_name")
    private String companyName;

    @Column(name = "prod_number")
    private String productNumbers;

    @Column(name = "distributor_supplier_name")
    private String distributorSupplierName;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "prod_sub_category_id")
    private SubCategory subCategory;

    private double price;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descriptions;

    @Column(name = "short_description")
    private String shortDescriptions;

}
