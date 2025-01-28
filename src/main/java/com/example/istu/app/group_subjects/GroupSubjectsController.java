package com.example.istu.app.group_subjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/group-subjects")
public class GroupSubjectsController {

    @Autowired
    private GroupSubjectsService service;

    // Получить все записи
    @GetMapping
    public List<GroupSubjects> getAllGroupSubjects() {
        return service.getAllGroupSubjects();
    }

    // Получить запись по ID
    @GetMapping("/{id}")
    public ResponseEntity<GroupSubjects> getGroupSubjectsById(@PathVariable int id) {
        return service.getGroupSubjectsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать новую запись
    @PostMapping
    public GroupSubjects createGroupSubjects(@RequestBody GroupSubjects groupSubjects) {
        return service.createGroupSubjects(groupSubjects);
    }

    // Обновить запись
    @PutMapping("/{id}")
    public ResponseEntity<GroupSubjects> updateGroupSubjects(@PathVariable int id, @RequestBody GroupSubjects groupSubjectsDetails) {
        return ResponseEntity.ok(service.updateGroupSubjects(id, groupSubjectsDetails));
    }

    // Удалить запись
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupSubjects(@PathVariable int id) {
        service.deleteGroupSubjects(id);
        return ResponseEntity.noContent().build();
    }
}