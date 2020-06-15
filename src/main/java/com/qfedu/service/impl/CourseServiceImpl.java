package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

//    分页查询
    @Override
    public List<Course> findAllCourse(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Course> all = courseDao.findAll();
        return all;
    }
//    删除
    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }
//    下拉列表
    @Override
    public List<Subject> findSubject() {
        return courseDao.findSubject();
    }

    //    添加内容
    @Override
    public void addCourse(String course_title, String course_desc, Integer subject_id) {
        Course course = new Course();
        course.setCourse_title(course_title);
        course.setCourse_desc(course_desc);
        course.setSubject_id(subject_id);
        courseDao.addCourse(course);
    }


//    点击更新直接显示内容
    @Override
    public Course findOne(int id) {
        return courseDao.findOne(id);
    }

    @Override
    public void updateOne(Course course) {
        courseDao.updateOne(course);
    }


}
