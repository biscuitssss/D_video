package com.qfedu.service;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerService {
    public List<Speaker> findAllSpeaker(Integer page,Integer limit);
    public void delete(int id);
    public void addSpeaker(String speaker_name,String speaker_job,String header_img_url,String speaker_desc);

    public Speaker findSpeak(int id);
    public void updateSpeaker(int id, String speaker_name,String speaker_job,String header_img_url,String speaker_desc);
}
