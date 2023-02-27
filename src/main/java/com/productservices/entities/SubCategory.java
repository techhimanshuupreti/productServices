package com.productservices.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Builder
@Table(name = "sub_category", uniqueConstraints = {@UniqueConstraint(columnNames = {"sub_category_id"})})
public class SubCategory implements Serializable {
    @Serial
    private static final long serialVersionUID = 5060514047181314347L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id", unique = true, nullable = false, insertable = false, updatable = false)
    private String subCategoryId;

    @Column(name = "sub_category_name")
    private String subCategoryName;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedAt;


}
