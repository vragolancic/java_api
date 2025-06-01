package com.codewithmosh.store.exceptions;

public class OrderNotFoundExeption extends RuntimeException {
    public OrderNotFoundExeption() {
        super("Order not found");
    }
}
