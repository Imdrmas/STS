package com.issamdrmas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.issamdrmas.model.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
