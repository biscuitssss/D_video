package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.VideoDao;
import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Video;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VoVideoSpeak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
//分页展示
    @Override
    public List<VoVideoSpeak> findAll(Integer page, Integer limit,String searchInfo, Integer course_id, Integer speaker_id) {
        PageHelper.startPage(page,limit);
        List<VoVideoSpeak> all = videoDao.findAll(searchInfo,course_id,speaker_id);
        return all;
    }
//    删除单个
    @Override
    public void deleteOne(int id) {
        videoDao.deleteOne(id);
    }
    //    下拉一个讲师，另一个下拉用的课程管理哪个界面
    @Override
    public List<Speaker> findSpe() {
        return videoDao.findSpe();
    }

//    添加
    @Override
    public void addVideo(Video video) {
        videoDao.addVideo(video);
    }
//    批量删除
    @Override
    public void deleteMany(String[] arr) {
        videoDao.deleteMany(arr);
    }

    //    修改展示
    @Override
    public Video findById(int id) {
        Video byId = videoDao.findById(id);
        return byId;
    }

//  修改
    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }


}
