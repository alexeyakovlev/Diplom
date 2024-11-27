package ru.yakovlev.universityschedule.repository;

import ru.yakovlev.universityschedule.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
