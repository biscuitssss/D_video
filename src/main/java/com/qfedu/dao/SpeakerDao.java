package com.qfedu.dao;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerDao {
    public List<Speaker> findAll();
    public void delete(int id);
    public void addSpeaker(Speaker speaker);

    public Speaker findSpeak(int id);
    public void updateSpeak(Speaker speaker);
}
