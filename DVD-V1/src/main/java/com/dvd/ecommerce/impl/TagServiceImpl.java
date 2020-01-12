package com.dvd.ecommerce.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.model.Tag;
import com.dvd.ecommerce.repository.TagRepository;
import com.dvd.ecommerce.service.TagService;

@Service
@Transactional
public class TagServiceImpl implements TagService {
	
	private TagRepository tagRepository;
	
	public TagServiceImpl(TagRepository tagRepository) {
		super();
		this.tagRepository = tagRepository;
	}

	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public List<Tag> getAllTags() {
		return tagRepository.findAll();
	}

}
