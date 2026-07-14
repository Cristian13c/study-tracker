package com.studytracker.repository;

import com.studytracker.model.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
}