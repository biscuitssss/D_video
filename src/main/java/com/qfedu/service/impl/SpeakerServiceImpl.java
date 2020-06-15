package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;
    @Override
    public List<Speaker> findAllSpeaker(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Speaker> all = speakerDao.findAll();
        return all;
    }

    @Override
    public void delete(int id) {
        speakerDao.delete(id);
    }

    @Override
    public void addSpeaker(String speaker_name, String speaker_job, String header_img_url, String speaker_desc) {
        Speaker speaker = new Speaker();
        speaker.setSpeaker_name(speaker_name);
        speaker.setSpeaker_job(speaker_job);
        speaker.setHead_img_url(header_img_url);
        speaker.setSpeaker_desc(speaker_desc);
        speakerDao.addSpeaker(speaker);
    }

    public Speaker findSpeak(int id) {
        return speakerDao.findSpeak(id);

    }

    @Override
    public void updateSpeaker(int id, String speaker_name, String speaker_job, String header_img_url, String speaker_desc) {
        Speaker speaker = new Speaker();
        speaker.setId(id);
        speaker.setSpeaker_name(speaker_name);
        speaker.setSpeaker_job(speaker_job);
        speaker.setHead_img_url(header_img_url);
        speaker.setSpeaker_desc(speaker_desc);
        speakerDao.updateSpeak(speaker);
    }


}
