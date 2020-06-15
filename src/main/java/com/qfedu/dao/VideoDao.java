package com.qfedu.dao;

import com.qfedu.entity.Speaker;
import com.qfedu.entity.Video;
import com.qfedu.vo.VoVideoSpeak;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface VideoDao {
//分页显示
    public List<VoVideoSpeak> findAll(@Param("searchInfo") String searchInfo,
                                      @Param("course_id") Integer course_id,
                                      @Param("speaker_id") Integer speaker_id);
//删除单个
    public void deleteOne(int id);
//下拉讲师
    public List<Speaker> findSpe();
//添加功能
    public void addVideo(Video video);
//批量删除
    public void deleteMany(String[] arr);
//修改展示
    public Video findById(int id);
//修改
    public void updateVideo(Video video);

}
