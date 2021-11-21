package br.com.devpradev.service;

import br.com.devpradev.mapper.PostMapper;
import br.com.devpradev.models.dto.MessageResponseDTO;
import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.models.entity.Post;
import br.com.devpradev.repository.PostRepository;

import br.com.devpradev.util.exception.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostService {

	private PostRepository postRepository;

	private PostMapper postMapper;

	// private static PostMapper postMapper = PostMapper.INSTANCE;

	@Transactional
	public MessageResponseDTO savePost(PostDTO postDTO) {
		Post postToSave = postMapper.toModel(postDTO);

		Post savedPost = postRepository.save(postToSave);
		return createMessageResponde(savedPost.getIdPost(), "Post criado! ");
	}

	@Transactional
	public List<PostDTO> findAll() {
		List<Post> allPosts = postRepository.findAll();
		return allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
	}

	@Transactional
	public PostDTO findById(Long id) throws PostNotFoundException {
		Post post = verificarExistencia(id);
		return postMapper.toDTO(post);
	}

	@Transactional
	public void delete(Long id) throws PostNotFoundException {
		verificarExistencia(id);
		postRepository.deleteById(id);
	}

	@Transactional
	public MessageResponseDTO updateById(Long id, PostDTO postDTO) throws PostNotFoundException {
		verificarExistencia(id);

		Post postToUpdate = postMapper.toModel(postDTO);
		return createMessageResponde(postToUpdate.getIdPost(), "Post atualizado!");
	}

	private Post verificarExistencia(Long id) throws PostNotFoundException {
		return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponde(Long id, String messege) {
		return MessageResponseDTO.builder().message(messege + id).build();
	}

}