package com.issamdrmas.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issamdrmas.model.Game;
@Service
public interface IGameService {
	public Game add(Game game);
	public List<Game> getAll();
	public ResponseEntity<Game> update(Long id, Game  game);
	public ResponseEntity<String> deleteById(Long id);
	public List<Game> getUsername(String username);
	public ResponseEntity<String>deleteAll();
	public Game getById(Long id);
}
