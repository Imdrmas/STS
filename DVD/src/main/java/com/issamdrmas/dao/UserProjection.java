package com.issamdrmas.dao;

import org.springframework.data.rest.core.config.Projection;

import com.issamdrmas.model.User;

@Projection(name="p1", types= {User.class})
public interface UserProjection {
public String getUsername();
}
