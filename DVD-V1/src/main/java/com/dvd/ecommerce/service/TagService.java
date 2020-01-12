package com.dvd.ecommerce.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.dvd.ecommerce.model.Tag;

@Validated
public interface TagService {
    Tag save(Tag tag);
    List<Tag> getAllTags();
}
