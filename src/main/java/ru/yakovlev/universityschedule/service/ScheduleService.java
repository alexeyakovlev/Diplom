package ru.yakovlev.universityschedule.service;

import ru.yakovlev.universityschedule.model.Schedule;
import ru.yakovlev.universityschedule.repository.ScheduleRepository;
import ru.yakovlev.universityschedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Schedule> getSchedulesByUser(String username) {
        return scheduleRepository.findByUserUsername(username);
    }

    public void createSchedule(Schedule schedule, String username) {
        schedule.setUser(userRepository.findByUsername(username));
        scheduleRepository.save(schedule);
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public void updateSchedule(Long id, Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.findById(id).orElse(null);
        if (existingSchedule != null) {
            existingSchedule.setSubject(schedule.getSubject());
            existingSchedule.setDateTime(schedule.getDateTime());
            existingSchedule.setRoom(schedule.getRoom());
            existingSchedule.setStatus(schedule.getStatus());
            scheduleRepository.save(existingSchedule);
        }
    }
}
