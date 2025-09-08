package com.training.jpa.entity;// OrderItem.java
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_item_id;

    @Column(name = "order_id",nullable = false)
    private Integer orderId;

    private Integer quantity;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double price;

}
