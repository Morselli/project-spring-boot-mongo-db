package com.viniciusmorselli.projectspringmongo.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.viniciusmorselli.projectspringmongo.domain.Post;
import com.viniciusmorselli.projectspringmongo.resources.utils.URL;
import com.viniciusmorselli.projectspringmongo.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping(value = "/titleSearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/fullSearch")
	public ResponseEntity<List<Post>> fullSearch(
		@RequestParam(value = "text", defaultValue = "") String text,
		@RequestParam(value = "minDate", defaultValue = "") String minDate,
		@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

		text = URL.decodeParam(text);
		LocalDate min = URL.convertDate(minDate, LocalDate.of(2010, 01, 01));
		LocalDate max = URL.convertDate(maxDate, LocalDate.now());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

}
