package com.studytracker.controller;

import com.studytracker.model.StudySession;
import com.studytracker.service.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class StudySessionController {

    @Autowired
    private StudySessionService service;

    @PostMapping
    public StudySession create(@RequestBody StudySession session) {
        return service.save(session);
    }

    @GetMapping
    public List<StudySession> getAll() {
        return service.getAll();
    }
}