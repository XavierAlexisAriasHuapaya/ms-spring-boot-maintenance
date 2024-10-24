package dev.arias.huapaya.ms_maintenance.presentation.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.ms_maintenance.persistence.entity.ProductEntity;
import dev.arias.huapaya.ms_maintenance.service.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(path = "product")
@RestController
public class ProductController {

    private final ProductService productService;
    
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductEntity product, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> error = result.getFieldErrors().stream().map(e -> {
                return e.getDefaultMessage();
            }).collect(Collectors.toList());
            response.put("error", error);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            ProductEntity productSave = this.productService.save(product);
            response.put("message", "Product create sucessfully.");
            response.put("data", productSave);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Database error.");
            response.put("error", "Error when inserting into the database: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        List<ProductEntity> productList = this.productService.findAll();
        if (productList.size() == 0) {
            response.put("message", "Empty record.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        response.put("message", "Product list");
        response.put("data", productList);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
