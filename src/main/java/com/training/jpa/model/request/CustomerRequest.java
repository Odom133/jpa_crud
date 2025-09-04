package com.training.jpa.model.request;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        String address
) {
}

