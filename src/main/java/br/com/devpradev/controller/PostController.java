package br.com.devpradev.controller;

import br.com.devpradev.models.dto.MessageResponseDTO;
import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.util.exception.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.devpradev.service.PostService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/blog/request")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {

	private PostService postService;

	@PostMapping(path = {"/create"})
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO savePost(@RequestBody @Valid PostDTO postDTO) {
		return postService.savePost(postDTO);
	}

	@GetMapping
	public List<PostDTO> findAll(){
		return postService.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public PostDTO findById(@PathVariable Long id) throws PostNotFoundException {
		return postService.findById(id);
	}

	@PutMapping(path = {"/update/{id}"})
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PostDTO postDTO) throws PostNotFoundException {
		return postService.updateById(id, postDTO);
	}

	@DeleteMapping(path = {"/delete/{id}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PostNotFoundException {
		postService.delete(id);
	}

}