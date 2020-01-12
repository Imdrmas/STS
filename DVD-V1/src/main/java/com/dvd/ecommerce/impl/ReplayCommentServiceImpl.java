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
import com.dvd.ecommerce.model.ReplayComment;
import com.dvd.ecommerce.repository.CommentRepository;
import com.dvd.ecommerce.repository.ReplayCommentRepository;
import com.dvd.ecommerce.service.ReplayCommentService;


@Service
@Transactional
public class ReplayCommentServiceImpl implements ReplayCommentService {
	
	private ReplayCommentRepository replayCommentRepository;
	private CommentRepository commentRepository;

	public ReplayCommentServiceImpl(ReplayCommentRepository replayCommentRepository, CommentRepository commentRepository) {
		super();
		this.replayCommentRepository = replayCommentRepository;
		this.commentRepository = commentRepository;
	}

	@Override
	public ReplayComment getReplayComment(@Min(value = 1, message = "Invalid Replay Comment ID.") long id) {
		return replayCommentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Replay Comment not found"));
	}

	@Override
	public void deleteById(long id) {
		replayCommentRepository.deleteById(id);
		
	}

	@Override
	public Optional<ReplayComment> findById(long id) {
		return replayCommentRepository.findById(id);
	}

	@Override
	public List<ReplayComment> getAllReplayComments() {
	    List<ReplayComment> list =	replayCommentRepository.findAll();
		List<ReplayComment> sortedList = list.stream().sorted(Comparator.comparing(ReplayComment::getId).reversed())
				.collect(Collectors.toList());
		return sortedList;
	}

	@Override
	public ReplayComment save(ReplayComment replayComment) {
	   return replayCommentRepository.save(replayComment);
	}
	@Override
	public void createReplyForComment(List<ReplayComment> replayComment, Long commentId) {
		Comment comment = commentRepository.findById(commentId).orElse(null);
		commentRepository.save(comment);
		replayCommentRepository.saveAll(replayComment);
	}


}
