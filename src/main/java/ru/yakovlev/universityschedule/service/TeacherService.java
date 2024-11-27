package ru.yakovlev.universityschedule.service;

import ru.yakovlev.universityschedule.model.Teacher;
import ru.yakovlev.universityschedule.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public void addComment(Long id, String comment) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.getComments().add(comment);
            teacherRepository.save(teacher);
        }
    }
}
