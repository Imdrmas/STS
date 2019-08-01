package com.issamdrmas.service;

import org.springframework.data.domain.Page;

import com.issamdrmas.model.Vol;

public interface IAeroport {
public Page<Vol> getAllVols(String mc, int page, int size);
public Page<Vol> getAllAvions(String mc, int page, int size);
public Page<Vol> getAllPilotes(String mc, int page, int size);
}
