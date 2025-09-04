package com.training.jpa.model.request;

public record ProductRequest(
            String name,
            String description,
            double price,
            int stock
) {
}
