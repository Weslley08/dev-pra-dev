package br.com.devpradev.controller;

import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.service.PostService;
import br.com.devpradev.utils.Endpoints;
import br.com.devpradev.utils.MessageResponse;
import br.com.devpradev.utils.exception.PostNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.REQUEST_POST)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {

	private PostService postService;

	@PostMapping(path = Endpoints.REQUEST_CREATE)
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse savePost(@RequestBody @Valid PostDTO postDTO) {
		return postService.savePost(postDTO);
	}

	@GetMapping
	public List<PostDTO> findAll(){
		return postService.findAll();
	}

	@GetMapping(path = Endpoints.REQUEST_POST_FIND_BY_ID)
	public MessageResponse findById(@PathVariable Long id) throws PostNotFoundException {
		return postService.findById(id, null);
	}

	@PutMapping(path = Endpoints.REQUEST_POST_UPDATE)
	public MessageResponse updateById(@PathVariable @Valid Long id, @RequestBody @Valid PostDTO postDTO) throws PostNotFoundException {
		return postService.updateById(id, postDTO);
	}

	@DeleteMapping(path = Endpoints.REQUEST_DELETE)
	public void deleteById(@PathVariable Long id) throws PostNotFoundException {
		postService.delete(id);
	}

}
