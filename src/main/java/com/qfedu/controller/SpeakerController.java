package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/speaker")
@ResponseBody
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/speakerList.do")
    public Map<String,Object> find(Integer page, Integer limit) {
        List<Speaker> allSpeaker = speakerService.findAllSpeaker(page, limit);
        long total = ((Page) allSpeaker).getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",allSpeaker);
        return map;
    }
    @RequestMapping("/deleteSpeaker.do")
    public void delete(int id) {
        speakerService.delete(id);
    }
//      添加
    @RequestMapping("/addSpeaker.do")
    public JsonResult add(String speaker_name, String speaker_job, String header_img_url, String speaker_desc) {
        speakerService.addSpeaker(speaker_name, speaker_job, header_img_url, speaker_desc);
        JsonResult result = new JsonResult(1,"添加成功");
        return result;
    }
//      点击更新直接显示内容
    @RequestMapping("/querySpeaker.do")
    public JsonResult findSpeak(int id) {
        Speaker speak = speakerService.findSpeak(id);
        JsonResult result = new JsonResult(1,speak);
        return result;
    }

    @RequestMapping("/updateSpeaker.do")
    public JsonResult update(int id, String speaker_name, String speaker_job, String header_img_url, String speaker_desc) {
        speakerService.updateSpeaker(id,speaker_name, speaker_job, header_img_url, speaker_desc);
        JsonResult result = new JsonResult(1,"修改成功");
        return result;
    }
}
