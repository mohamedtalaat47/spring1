package com.example.spring1.Course;

import com.example.spring1.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    private final StudentService studentService;


    @Autowired
    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }



    @GetMapping("/")
    public List<Course> all() {
        return courseService.all();
    }

    @GetMapping("{courseId}")
    public Optional<Course> getOne(@PathVariable("courseId") Long courseId) {
        return courseService.getOne(courseId);
    }


    @PostMapping("/")
    public void addCourse(@RequestBody Course course) {
        courseService.add(course);
    }

    @DeleteMapping("{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.delete(courseId);
    }

    @PutMapping("{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = true) String name
    ) {
        courseService.update(courseId, name);
    }
}
