package br.com.devpradev.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.devpradev.service.PostService;
import br.com.devpradev.models.entity.Post;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/blog")
public class PostController {

	@Autowired
	PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok(postService.findAll());
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Post> findById(@PathVariable Long id) {
		return ResponseEntity.ok(postService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Post> save(@RequestBody Post post) {
		return ResponseEntity.ok(postService.save(post));
	}

	@PutMapping(path = { "/{id}" })
	public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post objpost) {
		Post newObjPost = postService.update(id, objpost);
		return ResponseEntity.ok().body(newObjPost);
	}

	@DeleteMapping({ "/{id}" })
	public ResponseEntity<Post> delete(@PathVariable Long id) {
		return ResponseEntity.ok(postService.delete(id));
	}

}
