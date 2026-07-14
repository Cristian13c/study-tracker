package com.studytracker.service;

import com.studytracker.model.Subject;
import com.studytracker.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Subject save(Subject subject) {
        return repository.save(subject);
    }

    public List<Subject> getByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}