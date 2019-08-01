package com.issamdrmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
