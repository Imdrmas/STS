package com.issamdrmas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.issamdrmas.dao.MusicRepository;
import com.issamdrmas.model.Music;
import com.issamdrmas.services.IMusicService;
@Repository
public class MusicImpl implements IMusicService {
	
	@Autowired
	private MusicRepository musicRepository;

	@Override
	public Music add(Music music) {
		Music music2 = musicRepository.save(new Music(music.getId(), music.getName(), music.getDescription(), 
				music.getPrice(), music.getCreateAt(), music.getCategory()));
		return music2;
	}

	@Override
	public List<Music> getAll() {
		List<Music> musics = new ArrayList<Music>();
		musicRepository.findAll().forEach(musics::add);
		return musics;
	}

	@Override
	public ResponseEntity<Music> update(Long id, Music music) {
		Optional<Music> mOptional = musicRepository.findById(id);
		if (mOptional.isPresent()) {
			Music m = mOptional.get();
			m.setId(music.getId());
			m.setName(music.getName());
			m.setDescription(music.getDescription());
			m.setPrice(music.getPrice());
			m.setCreateAt(music.getCreateAt());
			m.setCategory(music.getCategory());
			musicRepository.save(m);
			return new ResponseEntity<Music>(musicRepository.save(m), HttpStatus.OK);
		}
		return new ResponseEntity<Music>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		musicRepository.deleteById(id);
		return new ResponseEntity<String>("Music has been deleted!", HttpStatus.OK);
	}

	@Override
	public List<Music> getUsername(String username) {
		List<Music> musics = musicRepository.findByName(username);
		return musics;
	}

	@Override
	public ResponseEntity<String> deleteAll() {
		musicRepository.deleteAll();
		return new ResponseEntity<String>("All Musics have been deleted!", HttpStatus.OK);
	}

	@Override
	public Music getById(Long id) {
		Optional<Music> mOptional = musicRepository.findById(id);
		if (mOptional.isPresent()) {
			Music m = mOptional.get();
			return m;
		}
		return null;
	}

}
