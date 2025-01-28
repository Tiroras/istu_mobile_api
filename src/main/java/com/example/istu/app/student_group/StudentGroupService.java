package com.example.istu.app.student_group;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGroupService {
    @Autowired
    private StudentGroupRepository repository;

    // Получить все группы
    public List<StudentGroup> getAllGroups() {
        return repository.findAll();
    }

    // Получить группу по имени
    public Optional<StudentGroup> getGroupByName(String name) {
        return repository.findById(name);
    }

    // Создать новую группу
    public StudentGroup createGroup(StudentGroup group) {
        return repository.save(group);
    }

    // Обновить группу
    public StudentGroup updateGroup(String name, StudentGroup groupDetails) {
        StudentGroup group = repository.findById(name).orElseThrow(() -> new RuntimeException("Group not found"));
        group.setName(groupDetails.getName());
        return repository.save(group);
    }

    // Удалить группу
    public void deleteGroup(String name) {
        repository.deleteById(name);
    }
}
