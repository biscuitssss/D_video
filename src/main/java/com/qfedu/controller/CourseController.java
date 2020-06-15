package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
@ResponseBody
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/courseList.do")
    public Map<String,Object> listCouse(Integer page,Integer limit) {
        List<Course> allCourse = courseService.findAllCourse(page, limit);
        long total = ((Page) allCourse).getTotal();
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",allCourse);
        return map;
    }

    @RequestMapping("/deleteCourse.do")

    public void delete(int id) {
        courseService.deleteById(id);
    }

    @RequestMapping("/subjectList.do")
    public JsonResult findSub() {
        List<Subject> subject = courseService.findSubject();
        JsonResult result = new JsonResult(1,subject);
        return result;
    }

    @RequestMapping("/addCourse.do")
    public JsonResult add(String course_title, String course_desc, Integer subject_id) {
        courseService.addCourse(course_title, course_desc, subject_id);
        JsonResult result = new JsonResult(1, "添加成功");
        return result;
    }
// 更新展示
    @RequestMapping("/queryCourse.do")
    public JsonResult findOne(int id) {
        Course one = courseService.findOne(id);
        JsonResult result = new JsonResult(1,one);
        return result;
    }
//修改
    @RequestMapping("/updateCourse.do")
    public JsonResult update(Course course) {
        courseService.updateOne(course);
        JsonResult result = new JsonResult(1,"ok");
        return result;
    }

}
