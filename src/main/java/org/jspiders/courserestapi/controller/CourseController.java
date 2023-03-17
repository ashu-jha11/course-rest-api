package org.jspiders.courserestapi.controller;

import org.jspiders.courserestapi.model.Course;
import org.jspiders.courserestapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping("/courses")
    public List<Course> getAllCourses(Course course){
        return service.getAllCourses();
    }

    @GetMapping("/courses/{batchCode}")
    public Course getCoursesBasedOnBatchCode(@PathVariable(value = "batchCode")String batchCode){
        return service.getCoursesBasedOnBatchCode(batchCode);
    }

    @GetMapping("/courses/faculty")
    public Set<String> getNamesOfAllFaculties(Course course){
        return service.getNamesOfAllFaculties();
    }

    @GetMapping("courses/faculty/{faculty}")
    public List<String> getAllBatchCodeBasedOnFaculty(@PathVariable(value = "faculty") String faculty){
        return service.getAllBatchCodeBasedOnFaculty(faculty);
    }

    @GetMapping("/courses/totalClasses")
    public List<String> getBatchesWhereTotalClasses(Course course){
        return service.getBatchesWhereTotalClasses();
    }

    @PostMapping("/courses")
    public void addBatch(@RequestBody Course course){
        service.addBatch(course);
    }

    @DeleteMapping("/courses/batches/{batchCode}")
    public void deleteSpecificBatch(@PathVariable(value = "batchCode")String batchCode){
        service.deleteSpecificBatch(batchCode);
    }
}
