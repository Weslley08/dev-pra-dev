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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostService {

	private PostRepository postRepository;

	private static PostMapper postMapper = PostMapper.INSTANCE;

	@Transactional
	public MessageResponseDTO savePost(PostDTO postDTO) {
		Optional<Post> optionalPost = postRepository.findById(postDTO.getIdPost());
		if (optionalPost.isPresent()) {
			return createMessageResponse("ID já cadastrado" + "status: " + HttpStatus.BAD_REQUEST, null);
		} else {
			Post postToSave = postMapper.toModel(postDTO);
			postRepository.save(postToSave);
			return createMessageResponse("Post criado!" + HttpStatus.OK, null);
		}
	}

	@Transactional
	public List<PostDTO> findAll() {
		List<Post> allPosts = postRepository.findAll();
		return allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
	}

	@Transactional
	public MessageResponseDTO findById(Long id, Post post, PostDTO postDTO) throws PostNotFoundException {
		verificarExistencia(id);

		postMapper.toDTO(post);
		return createMessageResponse("ID" + id + "encontrado" + "status: " + HttpStatus.OK, null);
	}

	@Transactional
	public MessageResponseDTO delete(Long id) throws PostNotFoundException {
		verificarExistencia(id);

		postRepository.deleteById(id);
		return createMessageResponse("Post deletado" + "Status: " + HttpStatus.OK, null);
	}

	@Transactional
	public MessageResponseDTO updateById(Long id, PostDTO postDTO) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent()) {
			return createMessageResponse("ID já cadastrado" + "Status: " + HttpStatus.BAD_REQUEST, null);
		} else {
			postMapper.toModel(postDTO);
			return createMessageResponse("Post atualizado!" + HttpStatus.OK, null);
		}
	}

	private Post verificarExistencia(Long id) throws PostNotFoundException {
		return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(String messege, HttpStatus httpStatus) {
		return MessageResponseDTO.builder().message(messege + httpStatus).build();
	}

}