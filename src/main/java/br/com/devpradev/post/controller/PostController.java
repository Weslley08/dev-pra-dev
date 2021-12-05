package br.com.devpradev.post.controller;

import br.com.devpradev.post.models.dto.PostDTO;
import br.com.devpradev.post.models.entity.Post;
import br.com.devpradev.post.service.PostService;
import br.com.devpradev.utils.Endpoints;
import br.com.devpradev.utils.MessageResponse;
import br.com.devpradev.utils.exceptions.NotFoundException;

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

	@PostMapping(path = Endpoints.REQUEST_POST_CREATE)
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse savePost(@RequestBody @Valid PostDTO postDTO) {
		return postService.savePost(postDTO);
	}

	@GetMapping
	public List<PostDTO> findAll(){
		return postService.findAll();
	}

	@GetMapping(path = Endpoints.REQUEST_POST_FIND_BY_ID)
	public PostDTO findById(@PathVariable Long id) throws NotFoundException {
		return postService.findById(id);
	}

	@PutMapping(path = Endpoints.REQUEST_POST_UPDATE)
	public Post updateById(@PathVariable Long id, @RequestBody @Valid PostDTO postDTO) throws NotFoundException {
		return postService.updateById(id, postDTO);
	}

	@DeleteMapping(path = Endpoints.REQUEST_POST_DELETE)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		postService.delete(id);
	}

}
