package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;



    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;


    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> items = new LinkedHashSet<>();

}