package com.grupo2.nexus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.grupo2.nexus.model.entity.Curso;
import com.grupo2.nexus.service.cursoService;
import lombok.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor

public class CursoController {

    private final cursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.findById(id));
    }


   @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(request));
    }

      @PutMapping("/{id}")
    public ResponseEntity<Curso> update(
            @PathVariable Long id,
            @RequestBody Curso request) {
        return ResponseEntity.ok(cursoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)    {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
