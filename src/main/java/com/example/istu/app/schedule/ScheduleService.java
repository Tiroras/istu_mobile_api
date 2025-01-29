package com.example.istu.app.schedule;

import com.example.istu.app.user.User;
import com.example.istu.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private UserRepository userRepository;

    // Получить все записи расписания
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // Получить запись расписания по ID
    public Optional<Schedule> getScheduleById(long id) {
        return scheduleRepository.findById(id);
    }

    // Создать новую запись расписания
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Обновить запись расписания
    public Schedule updateSchedule(long id, Schedule scheduleDetails) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.setGroup(scheduleDetails.getGroup());
        schedule.setSubject(scheduleDetails.getSubject());
        schedule.setTimeStart(scheduleDetails.getTimeStart());
        schedule.setDate(scheduleDetails.getDate());
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesByUser(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return scheduleRepository.findAllByGroupName(user.getStudentGroup().getName());
    }

    // Удалить запись расписания
    public void deleteSchedule(long id) {
        scheduleRepository.deleteById(id);
    }
}
