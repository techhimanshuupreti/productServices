package com.productservices.entities;

import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "sub_categories", uniqueConstraints = {
        @UniqueConstraint(name = "uc_subcategory_name", columnNames = {"name"})
})
public class SubCategory extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -6032856804657692513L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubCategory that = (SubCategory) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "category = " + getCategory() + ", " +
                "name = " + getName() + ", " +
                "descriptions = " + getDescriptions() + ", " +
                "shortDescriptions = " + getShortDescriptions() + ", " +
                "createdAt = " + getCreatedAt() + ", " +
                "updatedAt = " + getUpdatedAt() + ")";
    }
}
