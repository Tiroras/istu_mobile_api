package com.example.istu.app.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;

    // Получить все предметы
    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    // Получить предмет по имени
    public Optional<Subject> getSubjectByName(String name) {
        return repository.findById(name);
    }

    // Создать новый предмет
    public Subject createSubject(Subject subject) {
        return repository.save(subject);
    }

    // Обновить предмет
    public Subject updateSubject(String name, Subject subjectDetails) {
        Subject subject = repository.findById(name).orElseThrow(() -> new RuntimeException("Subject not found"));
        subject.setName(subjectDetails.getName());
        return repository.save(subject);
    }

    // Удалить предмет
    public void deleteSubject(String name) {
        repository.deleteById(name);
    }
}
