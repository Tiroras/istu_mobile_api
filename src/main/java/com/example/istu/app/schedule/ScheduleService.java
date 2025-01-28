package com.example.istu.app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    // Получить все записи расписания
    public List<Schedule> getAllSchedules() {
        return repository.findAll();
    }

    // Получить запись расписания по ID
    public Optional<Schedule> getScheduleById(long id) {
        return repository.findById(id);
    }

    // Создать новую запись расписания
    public Schedule createSchedule(Schedule schedule) {
        return repository.save(schedule);
    }

    // Обновить запись расписания
    public Schedule updateSchedule(long id, Schedule scheduleDetails) {
        Schedule schedule = repository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.setGroup(scheduleDetails.getGroup());
        schedule.setSubject(scheduleDetails.getSubject());
        schedule.setTimeStart(scheduleDetails.getTimeStart());
        schedule.setDate(scheduleDetails.getDate());
        return repository.save(schedule);
    }

    // Удалить запись расписания
    public void deleteSchedule(long id) {
        repository.deleteById(id);
    }
}
