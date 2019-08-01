package com.dvd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import com.dvd.ecommerce.model.Music;

public interface MusicRepository extends CrudRepository<Music, Long> {

}
