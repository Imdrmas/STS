package com.dvd.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.ecommerce.model.Comment;
import com.dvd.ecommerce.service.CommentService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
   private	CommentService commentService;

  public CommentController(CommentService commentService) {
	super();
  	this.commentService = commentService;
  }
  
	@GetMapping(value = {"/comments", "/"})
	public @NotNull Iterable<Comment> getComments(){
		return commentService.getAllComments();
	}
	@GetMapping("/comments/{id}")
	public Optional<Comment> getCommentById(@PathVariable("id") Long commentId) {
	  Optional<Comment> comments = commentService.findById(commentId);
	  return comments;
	}
	@PostMapping("/comments/create")
	public Comment createComment(@Valid @RequestBody Comment comment) {
		return commentService.save(comment);
	}
	@PutMapping("/comments/{id}")
  public ResponseEntity<Comment> updateComment(@PathVariable("id") Long commentId, Comment comment){
	Optional<Comment> comments = commentService.findById(commentId);
	if (comments.isPresent()) {
		Comment comment2 = comments.get();
		 comment2.setTitle(comment.getTitle());
		 comment2.setMessage(comment.getMessage());
	return new ResponseEntity<Comment>(commentService.save(comment2), HttpStatus.OK);
	}
	return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
 }
	@DeleteMapping("/comments/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId) {
		commentService.deleteById(commentId);
		return new ResponseEntity<String>("Comment deleted", HttpStatus.OK);
	}

}
