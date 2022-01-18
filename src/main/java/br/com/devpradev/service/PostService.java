package br.com.devpradev.service;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.devpradev.mapper.PostMapper;
import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.models.entity.Post;
import br.com.devpradev.repository.PostRepository;
import br.com.devpradev.utils.MessageResponse;
import br.com.devpradev.utils.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostService {

	private PostRepository postRepository;

	private static PostMapper postMapper = PostMapper.INSTANCE;

	@Transactional
	public MessageResponse savePost(PostDTO postDTO) {

		Post postToSave = postMapper.toModel(postDTO);
		postRepository.save(postToSave);
		return createMessageResponse("Post criado!");
	}

	@Transactional
	public List<PostDTO> findAll() {
		List<Post> allPosts = postRepository.findAll();
		return allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
	}

	@Transactional
	public PostDTO findById(Long id) throws NotFoundException {
		Post post = verificarExistencia(id);
		return postMapper.toDTO(post);
	}

	@Transactional
	public Post updateById(Long id, PostDTO postDTO) throws NotFoundException {
		verificarExistencia(id);

		Post postToUpdate = postMapper.toModel(postDTO);
		return postRepository.save(postToUpdate);
	}

	@Transactional
	public void delete(@PathVariable Long id) throws NotFoundException {
		verificarExistencia(id);
		postRepository.deleteById(id);
	}

	private Post verificarExistencia(Long id) throws NotFoundException {
		return postRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	private MessageResponse createMessageResponse(String messege) {
		return MessageResponse.builder().message(messege).build();
	}

}