package com.studytracker.controller;

import com.studytracker.model.Subject;
import com.studytracker.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return service.save(subject);
    }

    @GetMapping("/{userId}")
    public List<Subject> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
}
