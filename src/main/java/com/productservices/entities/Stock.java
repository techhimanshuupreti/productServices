package com.productservices.entities;

import com.productservices.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocks")
public class Stock extends BaseEntity {

    @Column(name = "available_qty")
    private int availableQty;

    @Column(name = "purchase_qty")
    private int purchaseQty;

    @Column(name = "unit")
    private String unit;

    @Column(name = "unit_price")
    private double unitPrice;

    @OneToOne
    @JoinColumn(name = "stock_prod_id")
    private Product product;
}
