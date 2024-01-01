package com.productservices.entities;


import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Category extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descriptions;

    @Column(name = "short_description")
    private String shortDescriptions;

}
