package com.productservices.entities;

import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sub_categories",uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class SubCategory extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 5060514047181314347L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,
                          CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "fk_category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descriptions;

    @Column(name = "short_description")
    private String shortDescriptions;
}
