package com.example.istu.app.grades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradesController {

    @Autowired
    private GradesService service;

    // Получить все оценки
    @GetMapping
    public List<Grades> getAllGrades() {
        return service.getAllGrades();
    }

    // Получить оценку по ID
    @GetMapping("/{id}")
    public ResponseEntity<Grades> getGradeById(@PathVariable int id) {
        return service.getGradeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать новую оценку
    @PostMapping
    public Grades createGrade(@RequestBody Grades grade) {
        return service.createGrade(grade);
    }

    // Обновить оценку
    @PutMapping("/{id}")
    public ResponseEntity<Grades> updateGrade(@PathVariable int id, @RequestBody Grades gradeDetails) {
        return ResponseEntity.ok(service.updateGrade(id, gradeDetails));
    }

    // Удалить оценку
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable int id) {
        service.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{gradeBook}")
    public List<Grades> getGradesByGradeBook(@PathVariable Long gradeBook) {
        return service.getGradesByUserGradeBook(gradeBook);
    }
}