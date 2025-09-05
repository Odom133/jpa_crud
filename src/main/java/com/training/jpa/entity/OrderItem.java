package com.training.jpa.entity;// OrderItem.java
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    @Column(name = "order_id",nullable = false)
    private Integer orderId;

    private Integer quantity;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double price;
}
