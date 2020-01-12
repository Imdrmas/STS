package com.dvd.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.ecommerce.model.ReplayComment;
import com.dvd.ecommerce.service.ReplayCommentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/replaycomments")
public class ReplayCommentController {
	
   private	ReplayCommentService replayCommentService;

	public ReplayCommentController(ReplayCommentService replayCommentService) {
	super();
	this.replayCommentService = replayCommentService;
}
	@GetMapping(value = {"/replay", "/"})
	public @NotNull Iterable<ReplayComment> getReplayComments(){
		return replayCommentService.getAllReplayComments();
	}
	@GetMapping("/replay/{id}")
	public Optional<ReplayComment> getReplayCommentById(@PathVariable("id") Long commentId) {
	  Optional<ReplayComment> replayComments = replayCommentService.findById(commentId);
	  return replayComments;
	}

	/*
	 * @PostMapping("/replay/create{commentId}") public ReplayComment
	 * createReplayComment(@Valid @RequestBody @PathVariable("commentId")
	 * ReplayComment comment, long commentId) { return
	 * replayCommentService.saveById(comment, commentId); }
	 */
	/*
	 * @PutMapping("/replay/{id}") public ResponseEntity<ReplayComment>
	 * updateReplayComment(@PathVariable("id") Long commentId, ReplayComment
	 * comment){ Optional<ReplayComment> comments =
	 * replayCommentService.findById(commentId); if (comments.isPresent()) {
	 * ReplayComment comment2 = comments.get();
	 * comment2.setMessageReplay(comment.getMessageReplay()); return new
	 * ResponseEntity<ReplayComment>(replayCommentService.saveById(comment2,
	 * commentId), HttpStatus.OK); } return new
	 * ResponseEntity<ReplayComment>(HttpStatus.NOT_FOUND); }
	 */
	@DeleteMapping("/replay/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId) {
		replayCommentService.deleteById(commentId);
		return new ResponseEntity<String>("Comment deleted", HttpStatus.OK);
	}
	@GetMapping("/replay/comment/{commentId}")
	public void createReplyForComment(@RequestBody List<ReplayComment> replayComment, @PathVariable("commentId") Long commentId) {
		replayCommentService.createReplyForComment(replayComment, commentId);
	}

}
