package com.example.istu.app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    // Получить все записи расписания
    @GetMapping
    public List<Schedule> getAllSchedules() {
        return service.getAllSchedules();
    }

    // Получить запись расписания по ID
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable int id) {
        return service.getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создать новую запись расписания
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return service.createSchedule(schedule);
    }

    // Обновить запись расписания
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable int id, @RequestBody Schedule scheduleDetails) {
        return ResponseEntity.ok(service.updateSchedule(id, scheduleDetails));
    }

    // Удалить запись расписания
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable int id) {
        service.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public List<Schedule> getSchedulesByUser(@PathVariable long userId) {
        return service.getSchedulesByUser(userId);
    }
}