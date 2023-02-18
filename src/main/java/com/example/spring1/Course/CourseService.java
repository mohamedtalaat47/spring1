package com.example.spring1.Course;

import com.example.spring1.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> all() {
        return courseRepository.findAll();
    }

    public Optional<Course> getOne(Long courseId) {
        Boolean exists = courseRepository.existsById(courseId);

        if (!exists) {
            throw new IllegalStateException("There is no course with id " + courseId);
        }

        return courseRepository.findById(courseId);
    }

    public void add(Course course) {
        Optional<Course> courseOptional = courseRepository.findByName(course.getName());

        if (courseOptional.isPresent()) {
            throw new IllegalStateException("Course already exists");
        }
        courseRepository.save(course);
    }

    public void delete(Long CourseId) {
        Boolean exists = courseRepository.existsById(CourseId);

        if (!exists) {
            throw new IllegalStateException("There is no course with id " + CourseId);
        }

        courseRepository.deleteById(CourseId);
    }

    public void update(Long CourseId, String name) {
        Course course = courseRepository.findById(CourseId)
                .orElseThrow(() -> new IllegalStateException("There is no course with id " + CourseId));

        course.setName(name);

    }

}
