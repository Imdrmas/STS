package com.dvd.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import com.dvd.ecommerce.model.Comment;


@Validated
public interface CommentService {
	Comment getComment(@Min(value = 1L, message = "Invalid game ID.") long id);
	Comment save(Comment comment);
	void deleteById(long id);
	Optional<Comment> findById(long id);
	List<Comment> getAllComments();

}
