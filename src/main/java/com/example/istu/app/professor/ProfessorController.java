package com.example.istu.app.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    // Получить всех преподавателей
    @GetMapping
    public List<Professor> getAllProfessors() {
        return service.getAllProfessors();
    }

    // Получить преподавателя по ID
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable int id) {
        return service.getProfessorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать нового преподавателя
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return service.createProfessor(professor);
    }

    // Обновить преподавателя
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable int id, @RequestBody Professor professorDetails) {
        return ResponseEntity.ok(service.updateProfessor(id, professorDetails));
    }

    // Удалить преподавателя
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable int id) {
        service.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
