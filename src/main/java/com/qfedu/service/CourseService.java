package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;

import java.util.List;



public interface CourseService {

    public List<Course> findAllCourse(Integer page,Integer limit);
    public void deleteById(int id);

    public List<Subject> findSubject();
    public void addCourse(String course_title,String course_desc, Integer subject_id);

    public Course findOne(int id);
    public void updateOne(Course course);

}
