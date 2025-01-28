package com.example.istu.app.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService service;

    // Получить все предметы
    @GetMapping
    public List<Subject> getAllSubjects() {
        return service.getAllSubjects();
    }

    // Получить предмет по имени
    @GetMapping("/{name}")
    public ResponseEntity<Subject> getSubjectByName(@PathVariable String name) {
        return service.getSubjectByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать новый предмет
    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    // Обновить предмет
    @PutMapping("/{name}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String name, @RequestBody Subject subjectDetails) {
        return ResponseEntity.ok(service.updateSubject(name, subjectDetails));
    }

    // Удалить предмет
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String name) {
        service.deleteSubject(name);
        return ResponseEntity.noContent().build();
    }
}
