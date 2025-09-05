package com.training.jpa.entity;// Order.java
import com.training.jpa.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "customer_id" , nullable = false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id", updatable = false, insertable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;  // could be Enum instead

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double totalAmount;

    private LocalDateTime orderDate = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;
}
