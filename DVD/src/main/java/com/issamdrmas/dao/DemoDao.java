package com.issamdrmas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issamdrmas.model.Demo;
@Repository
public interface DemoDao extends JpaRepository<Demo, Long> {

}
