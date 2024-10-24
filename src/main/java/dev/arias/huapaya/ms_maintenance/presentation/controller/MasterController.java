package dev.arias.huapaya.ms_maintenance.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.ms_maintenance.persistence.entity.MasterEntity;
import dev.arias.huapaya.ms_maintenance.service.interfaces.MasterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

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

@AllArgsConstructor
@RequestMapping(path = "master")
@RestController
public class MasterController {

    private final MasterService masterService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MasterEntity master, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> error = result.getFieldErrors().stream().map(e -> {
                return e.getDefaultMessage();
            }).collect(Collectors.toList());
            response.put("error", error);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            MasterEntity masterSave = this.masterService.save(master);
            response.put("message", "Master create sucessfully.");
            response.put("data", masterSave);
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
        List<MasterEntity> masterList = this.masterService.findAll();
        if (masterList.size() == 0) {
            response.put("message", "Empty record.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        response.put("message", "Master list");
        response.put("data", masterList);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
