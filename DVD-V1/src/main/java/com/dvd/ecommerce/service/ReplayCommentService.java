package com.dvd.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import com.dvd.ecommerce.model.ReplayComment;

@Validated
public interface ReplayCommentService {
	ReplayComment getReplayComment(@Min(value = 1L, message = "Invalid Replay Comment ID.") long id);
	ReplayComment save(ReplayComment replayComment);
	void deleteById(long id);
	Optional<ReplayComment> findById(long id);
	List<ReplayComment> getAllReplayComments();
	void createReplyForComment(List<ReplayComment> replayComment, Long commentId);
}
