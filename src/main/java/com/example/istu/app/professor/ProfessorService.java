package com.example.istu.app.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    // Получить всех преподавателей
    public List<Professor> getAllProfessors() {
        return repository.findAll();
    }

    // Получить преподавателя по ID
    public Optional<Professor> getProfessorById(long id) {
        return repository.findById(id);
    }

    // Создать нового преподавателя
    public Professor createProfessor(Professor professor) {
        return repository.save(professor);
    }

    // Обновить преподавателя
    public Professor updateProfessor(long id, Professor professorDetails) {
        Professor professor = repository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
        professor.setName(professorDetails.getName());
        professor.setSurname(professorDetails.getSurname());
        professor.setPatronymic(professorDetails.getPatronymic());
        return repository.save(professor);
    }

    // Удалить преподавателя
    public void deleteProfessor(long id) {
        repository.deleteById(id);
    }
}
