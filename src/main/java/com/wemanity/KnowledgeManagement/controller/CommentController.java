package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.services.ICommentService;
import com.wemanity.KnowledgeManagement.services.impl.CommentServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {

	@Autowired
	ICommentService commentService;

	public CommentController(CommentServiceImpl commentServiceImpl) {
		this.commentService = commentServiceImpl;
	}

	@RequestMapping(value = "/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDto>> getCommentsByKnowledge(Knowledge knowledge) {
		List<Comment> comments = this.commentService.findByKnowledge(knowledge);
		List<CommentDto> commentsDto = new ArrayList<CommentDto>();
		for (Comment currentComment : comments) {
			commentsDto.add(new CommentDto(currentComment));
		}
		return new ResponseEntity<>(commentsDto, HttpStatus.OK);
	}
}