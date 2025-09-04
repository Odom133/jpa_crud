package com.training.jpa.controller;

import com.training.jpa.model.dto.ProductDTO;
import com.training.jpa.model.request.ProductRequest;
import com.training.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // POST: /products
    // Body: {}
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO create(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    // PUT: /products/1
    // Body: {}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@PathVariable("id") Integer productId, @RequestBody ProductRequest request) {
        return productService.updateProduct(productId, request);
    }

    // GET: /products/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO get(@PathVariable("id") Integer productId) {
        return productService.getProduct(productId);
    }

    // DELETE: /products/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer productId) {
        productService.deleteProduct(productId);
    }

    // GET: /products
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> list() {
        return productService.listProducts();
    }

}
