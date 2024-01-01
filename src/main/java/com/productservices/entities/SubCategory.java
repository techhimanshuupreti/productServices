package com.productservices.entities;

import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "sub_categories", uniqueConstraints = {
        @UniqueConstraint(name = "uc_subcategory_name", columnNames = {"name"})
})
public class SubCategory extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
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
