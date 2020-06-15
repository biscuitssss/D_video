package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Video;
import com.qfedu.vo.VoVideoSpeak;

import java.util.List;

public interface VideoService {
//    分页展示
    public List<VoVideoSpeak> findAll(Integer page, Integer limit,
                                      String searchInfo,
                                      Integer course_id,
                                      Integer speaker_id);
//    删除单个
    public void deleteOne(int id);
//    下拉一个讲师，另一个下拉用的课程管理哪个界面
    public List<Speaker> findSpe();

//添加功能
    public void addVideo(Video video);

//  批量删除
    public void deleteMany(String[] arr);

//  修改展示
    public Video findById(int id);

//   修改
    public void updateVideo(Video video);
}
