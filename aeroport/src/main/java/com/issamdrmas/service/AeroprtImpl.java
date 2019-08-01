package com.issamdrmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.issamdrmas.model.Vol;
import com.issamdrmas.repostory.AvionRepisotory;
import com.issamdrmas.repostory.PiloteRepisotory;
import com.issamdrmas.repostory.VolRepisotory;

public class AeroprtImpl implements IAeroport {
	
	
	@Autowired
    AvionRepisotory avionRepisotory;
	@Autowired
	VolRepisotory volRepisotory;
	@Autowired
	PiloteRepisotory piloteRepisotory;

	@Override
	public Page<Vol> getAllVols(String mc, int page, int size) {
		return null;		
	}

	@Override
	public Page<Vol> getAllAvions(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vol> getAllPilotes(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
