package com.example.istu.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Получить всех пользователей
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Получить пользователя по номеру зачетной книжки
    public Optional<User> getUserByGradeBook(long gradeBook) {
        return repository.findById(gradeBook);
    }
    public Optional<User> getUserByLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }

    // Создать нового пользователя
    public User createUser(User user) {
        return repository.save(user);
    }

    // Обновить пользователя
    public User updateUser(long gradeBook, User userDetails) {
        User user = repository.findById(gradeBook).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setPatronymic(userDetails.getPatronymic());
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        user.setStudentGroup(userDetails.getStudentGroup());
        return repository.save(user);
    }

    // Удалить пользователя
    public void deleteUser(long gradeBook) {
        repository.deleteById(gradeBook);
    }
}
