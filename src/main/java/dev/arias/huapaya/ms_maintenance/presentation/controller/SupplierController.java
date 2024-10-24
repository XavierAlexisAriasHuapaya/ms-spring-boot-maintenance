package dev.arias.huapaya.ms_maintenance.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import dev.arias.huapaya.ms_maintenance.persistence.entity.SupplierEntity;
import dev.arias.huapaya.ms_maintenance.service.interfaces.SupplierService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(path = "supplier")
@RestController
public class SupplierController {
    
    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SupplierEntity supplier, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> error = result.getFieldErrors().stream().map(e -> {
                return e.getDefaultMessage();
            }).collect(Collectors.toList());
            response.put("error", error);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            SupplierEntity supplierSave = this.supplierService.save(supplier);
            response.put("message", "Supplier sucessfully.");
            response.put("data", supplierSave);
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
        List<SupplierEntity> supplierList = this.supplierService.findAll();
        if (supplierList.size() == 0) {
            response.put("message", "Empty record.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        response.put("message", "Suppliers");
        response.put("data", supplierList);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
