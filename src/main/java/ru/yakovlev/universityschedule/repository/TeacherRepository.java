package ru.yakovlev.universityschedule.repository;

import ru.yakovlev.universityschedule.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
