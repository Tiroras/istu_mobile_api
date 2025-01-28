package com.example.istu.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Получить всех пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // Получить пользователя по номеру зачетной книжки
    @GetMapping("/{gradeBook}")
    public ResponseEntity<User> getUserByGradeBook(@PathVariable int gradeBook) {
        return service.getUserByGradeBook(gradeBook)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("auth")
    public ResponseEntity<User> getUserByLoginAndPassword(@RequestParam String login, @RequestParam String password) {
        return service.getUserByLoginAndPassword(login, password).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Создать нового пользователя
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    // Обновить пользователя
    @PutMapping("/{gradeBook}")
    public ResponseEntity<User> updateUser(@PathVariable int gradeBook, @RequestBody User userDetails) {
        return ResponseEntity.ok(service.updateUser(gradeBook, userDetails));
    }

    // Удалить пользователя
    @DeleteMapping("/{gradeBook}")
    public ResponseEntity<Void> deleteUser(@PathVariable int gradeBook) {
        service.deleteUser(gradeBook);
        return ResponseEntity.noContent().build();
    }
}
