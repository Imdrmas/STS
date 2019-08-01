package com.issamdrmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Music;
@Repository
public interface MusicRepository extends JpaRepository<Music, Long>{

	List<Music> findByName(String username);

}
