package com.productservices.entities;


import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Serial
    private static final long serialVersionUID = 4507893354738057987L;

    @Column(name = "type")
    private String categoryType;

}
