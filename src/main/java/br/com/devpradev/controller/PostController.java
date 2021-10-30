package br.com.devpradev.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.devpradev.service.PostService;
import br.com.devpradev.models.entity.Post;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class PostController {

    @Autowired
	PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok(postService.findAll());
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Post> findById(@PathVariable Long id) {
		return ResponseEntity.ok(postService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Post> save(@RequestBody Post post) {
		return ResponseEntity.ok(postService.save(post));
	}

	@PutMapping(value = {"/{id}"}) 
	public ResponseEntity<Post> update(@RequestBody Post post) {
		return ResponseEntity.ok(postService.update(post));
	}

	@DeleteMapping({"/{id}"})
	public ResponseEntity<Post> delete(@PathVariable Long id) {
		return ResponseEntity.ok(postService.delete(id));
	}

}
