package com.example.istu.app.group_subjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupSubjectsService {

    @Autowired
    private GroupSubjectsRepository repository;

    // Получить все записи
    public List<GroupSubjects> getAllGroupSubjects() {
        return repository.findAll();
    }

    // Получить запись по ID
    public Optional<GroupSubjects> getGroupSubjectsById(long id) {
        return repository.findById(id);
    }

    // Создать новую запись
    public GroupSubjects createGroupSubjects(GroupSubjects groupSubjects) {
        return repository.save(groupSubjects);
    }

    // Обновить запись
    public GroupSubjects updateGroupSubjects(long id, GroupSubjects groupSubjectsDetails) {
        GroupSubjects groupSubjects = repository.findById(id).orElseThrow(() -> new RuntimeException("GroupSubjects not found"));
        groupSubjects.setGroup(groupSubjectsDetails.getGroup());
        groupSubjects.setSubject(groupSubjectsDetails.getSubject());
        groupSubjects.setProfessor(groupSubjectsDetails.getProfessor());
        return repository.save(groupSubjects);
    }

    // Удалить запись
    public void deleteGroupSubjects(long id) {
        repository.deleteById(id);
    }
}
