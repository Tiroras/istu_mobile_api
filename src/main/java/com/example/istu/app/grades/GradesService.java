package com.example.istu.app.grades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {

    @Autowired
    private GradesRepository repository;

    // Получить все оценки
    public List<Grades> getAllGrades() {
        return repository.findAll();
    }

    // Получить оценку по ID
    public Optional<Grades> getGradeById(long id) {
        return repository.findById(id);
    }

    // Создать новую оценку
    public Grades createGrade(Grades grade) {
        return repository.save(grade);
    }

    // Обновить оценку
    public Grades updateGrade(long id, Grades gradeDetails) {
        Grades grade = repository.findById(id).orElseThrow(() -> new RuntimeException("Grade not found"));
        grade.setUser(gradeDetails.getUser());
        grade.setSubject(gradeDetails.getSubject());
        grade.setGrade(gradeDetails.getGrade());
        return repository.save(grade);
    }
    public List<Grades> getGradesByUserGradeBook(Long gradeBook) {
        return repository.findByUserGradeBook(gradeBook);
    }

    // Удалить оценку
    public void deleteGrade(long id) {
        repository.deleteById(id);
    }
}