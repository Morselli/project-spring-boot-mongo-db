package com.viniciusmorselli.projectspringmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.viniciusmorselli.projectspringmongo.domain.Post;
import com.viniciusmorselli.projectspringmongo.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
}
