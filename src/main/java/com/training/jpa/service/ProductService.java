package com.training.jpa.service;

import com.training.jpa.entity.Product;
import com.training.jpa.model.dto.ProductDTO;
import com.training.jpa.model.request.ProductRequest;
import com.training.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductDTO createProduct(ProductRequest request) {
        Product productCreated = productRepository.save(Product.builder()
                .productName(request.name())
                .description(request.description())
                .price(request.price())
                .stockQuantity(request.stock())
                .build());

        return new ProductDTO(productCreated);
    }

    @Transactional
    public ProductDTO updateProduct(Integer productId, ProductRequest request) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found!"));
        product.setProductName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStockQuantity(request.stock());
        return new ProductDTO(productRepository.save(product));
    }

    @Transactional
    public void deleteProduct(Integer productId) {
        productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found!"));
        productRepository.deleteById(productId);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> listProducts() {
        return productRepository.findAll().stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO getProduct(Integer productId) {
        return productRepository.findById(productId).map(ProductDTO::new).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

}
