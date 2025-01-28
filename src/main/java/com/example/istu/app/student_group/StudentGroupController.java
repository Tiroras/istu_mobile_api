package com.example.istu.app.student_group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class StudentGroupController {

    @Autowired
    private StudentGroupService service;

    // Получить все группы
    @GetMapping
    public List<StudentGroup> getAllGroups() {
        return service.getAllGroups();
    }

    // Получить группу по имени
    @GetMapping("/{name}")
    public ResponseEntity<StudentGroup> getGroupByName(@PathVariable String name) {
        return service.getGroupByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать новую группу
    @PostMapping
    public StudentGroup createGroup(@RequestBody StudentGroup group) {
        return service.createGroup(group);
    }

    // Обновить группу
    @PutMapping("/{name}")
    public ResponseEntity<StudentGroup> updateGroup(@PathVariable String name, @RequestBody StudentGroup groupDetails) {
        return ResponseEntity.ok(service.updateGroup(name, groupDetails));
    }

    // Удалить группу
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteGroup(@PathVariable String name) {
        service.deleteGroup(name);
        return ResponseEntity.noContent().build();
    }
}
