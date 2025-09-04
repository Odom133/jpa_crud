package com.training.jpa.model.dto;

import com.training.jpa.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    private Integer productId;
    private String productName;
    private String description;
    private Double price;
    private Integer stockQuantity;

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
    }
}
