package com.training.jpa.entity;// Payment.java
import com.training.jpa.model.enums.PaymentMethod;
import com.training.jpa.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
