package com.studytracker.service;

import com.studytracker.model.StudySession;
import com.studytracker.repository.StudySessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySessionService {

    @Autowired
    private StudySessionRepository repository;

    public StudySession save(StudySession session) {
        return repository.save(session);
    }

    public List<StudySession> getAll() {
        return repository.findAll();
    }
}