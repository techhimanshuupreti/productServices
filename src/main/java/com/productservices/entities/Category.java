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
import java.sql.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "category", uniqueConstraints = {@UniqueConstraint(columnNames = {"category_id"})})
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 4507893354738057987L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false, insertable = false, updatable = false)
    private String categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "type")
    private String categoryType;

    @Column(name = "description")
    private String descriptions;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedAt;

}
