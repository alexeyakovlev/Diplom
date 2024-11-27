package ru.yakovlev.universityschedule.controller;

import ru.yakovlev.universityschedule.model.Schedule;
import ru.yakovlev.universityschedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public String viewSchedule(Model model, Principal principal) {
        model.addAttribute("schedules", scheduleService.getSchedulesByUser(principal.getName()));
        return "schedule";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("schedule", new Schedule());
        return "create_schedule";
    }

    @PostMapping("/create")
    public String createSchedule(Schedule schedule, Principal principal) {
        scheduleService.createSchedule(schedule, principal.getName());
        return "redirect:/schedule";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("schedule", scheduleService.getScheduleById(id));
        return "edit_schedule";
    }

    @PostMapping("/edit/{id}")
    public String editSchedule(@PathVariable Long id, Schedule schedule) {
        scheduleService.updateSchedule(id, schedule);
        return "redirect:/schedule";
    }
}
