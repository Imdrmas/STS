package com.issamdrmas.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issamdrmas.model.Music;
@Service
public interface IMusicService {
	public Music add(Music music);
	public List<Music> getAll();
	public ResponseEntity<Music> update(Long id, Music  music);
	public ResponseEntity<String> deleteById(Long id);
	public List<Music> getUsername(String username);
	public ResponseEntity<String>deleteAll();
	public Music getById(Long id);
}
