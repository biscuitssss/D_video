package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Subject;
import com.qfedu.entity.Video;
import com.qfedu.service.CourseService;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VoVideoSpeak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
@ResponseBody
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;

//    分页显示
    @RequestMapping("/videoList.do")
    public Map<String , Object> findAll(Integer page, Integer limit, String searchInfo, Integer course_id, Integer speaker_id) {
        List<VoVideoSpeak> allVideo = videoService.findAll(page, limit,searchInfo, course_id, speaker_id);
        long total = ((Page) allVideo).getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",allVideo);
        return map;
    }
//    删除单个
    @RequestMapping("/deleteVideo.do")
    public JsonResult deleteOne(int id) {
        videoService.deleteOne(id);
        JsonResult result = new JsonResult(1,"ok");
        return result;
    }

//    下拉讲师和课程
    @RequestMapping("/findSAC.do")
    public Map<String,Object> findTwo() {
        List<Subject> sub = courseService.findSubject();
        List<Speaker> spe = videoService.findSpe();
        HashMap<String, Object> map = new HashMap<>();
        map.put("findSubject",sub);
        map.put("findSpe",spe);
        return map;
    }

//    添加
    @RequestMapping("/addVideo.do")
    public JsonResult addVideo(Video video) {
        videoService.addVideo(video);
        JsonResult result = new JsonResult(1,"ok");
        return result;
    }

//    批量删除
    @RequestMapping("/deleteSomeVideo.do")
    public JsonResult deleteMany(String string) {
        String[] array = string.split(",");
        try {
            videoService.deleteMany(array);
            return new JsonResult(1,null);
        }catch (Exception e) {
            return new JsonResult(0,e.getMessage());
        }
    }

//    修改展示
    @RequestMapping("/queryVideo.do")
    public JsonResult findById(int id) {
        Video byId = videoService.findById(id);
        JsonResult result = new JsonResult(1,byId);
        return result;
    }

//    修改更新
@RequestMapping("/updateVideo.do")
    public JsonResult updateVideo(Video video) {
        videoService.updateVideo(video);
        JsonResult result = new JsonResult(1,"修改成功");
        return result;
    }

}
