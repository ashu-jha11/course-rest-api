package org.jspiders.courserestapi.service;

import org.jspiders.courserestapi.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {
    List<Course> courseList=new ArrayList<>();

    {
        courseList.add(new Course("1ESA2","SPRING","AKSHAY",20));
        courseList.add(new Course("1CCA13","CORE JAVA","ISHA",69));
        courseList.add(new Course("1EHA3","HIBERNATE","AKSHAY",25));
        courseList.add(new Course("1EWA9","WEB TECH","SUDESH",30));
    }

    //    1. Display all courses
    public List<Course> getAllCourses(){
        return courseList;
    }

    //    2. Get course details based on batch code
    public Course getCoursesBasedOnBatchCode(String batchCode){
        for (int i=0;i<courseList.size();i++){
            Course c1=courseList.get(i);
            if(c1.getBatchCode().equals(batchCode)){
                return c1;
            }
        }
        return null;
    }

    //    3. Get the name of all faculties
    public Set<String> getNamesOfAllFaculties(){
        Set<String> data=new HashSet<>();
        for (int i=0;i<courseList.size();i++){
            Course c1=courseList.get(i);
            data.add(c1.getFaculty());
        }
        return data;
    }

    //    4. Get all batch codes of specific faculty
    public List<String> getAllBatchCodeBasedOnFaculty(String faculty){
        List<String> batchCodes=new ArrayList<>();
        for (int i=0;i<courseList.size();i++){
            Course c1=courseList.get(i);
            if(c1.getFaculty().equals(faculty)){
                batchCodes.add(c1.getBatchCode());
            }
        }
        return batchCodes;
    }

    //    5. Get all batches where total classes more than 50
    public List<String> getBatchesWhereTotalClasses(){
        List<String> batches=new ArrayList<>();
        for (int i=0;i<courseList.size();i++){
            Course c1=courseList.get(i);
            if(c1.getTotalClasses()>50){
                batches.add(c1.getBatchCode());
            }
        }
        return batches;
    }

    //    6. Add new batch details
    public void addBatch(Course course){
        courseList.add(course);
    }

    //    7. Delete specific batch details based on batch code
    public void deleteSpecificBatch(String batchCode){
        for (int i=0;i<courseList.size();i++){
            Course c1=courseList.get(i);
            if(c1.getBatchCode().equals(batchCode)){
                courseList.remove(c1);
            }
        }
    }
}
