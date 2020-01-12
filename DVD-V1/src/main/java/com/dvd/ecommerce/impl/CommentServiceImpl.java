package com.dvd.ecommerce.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.ecommerce.exception.ResourceNotFoundException;
import com.dvd.ecommerce.model.Comment;
import com.dvd.ecommerce.repository.CommentRepository;
import com.dvd.ecommerce.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	private CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment getComment(@Min(value = 1, message = "Invalid game ID.") long id) {
		return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void deleteById(long id) {
		commentRepository.deleteById(id);
	}

	@Override
	public Optional<Comment> findById(long id) {
		return commentRepository.findById(id);
	}

	@Override
	public List<Comment> getAllComments() {
		List<Comment> list = commentRepository.findAll();
		List<Comment> sortedList = list.stream().sorted(Comparator.comparing(Comment::getId).reversed())
				.collect(Collectors.toList());
		return sortedList;
	}



}
