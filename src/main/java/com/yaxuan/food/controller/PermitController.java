package com.yaxuan.food.controller;

import com.yaxuan.food.model.entity.Permit;
import com.yaxuan.food.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PermitController {

    private final PermitService permitService;

    @Autowired
    public PermitController(PermitService permitService) {
        this.permitService = permitService;
    }

    @GetMapping("/permits/{id}")
    public ResponseEntity<Permit> getPermitById(@PathVariable Integer id) {
        Optional<Permit> permit = permitService.getPermitById(id);
        return permit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
