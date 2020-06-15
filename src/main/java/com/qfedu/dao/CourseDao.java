package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;

import java.util.List;

public interface CourseDao {

    public List<Course> findAll();
    public void deleteById(int id);

    public List<Subject> findSubject();
    public void addCourse(Course course);

    public Course findOne(int id);
    public void updateOne(Course course);
}
