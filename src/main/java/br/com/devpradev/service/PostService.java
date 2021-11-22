package br.com.devpradev.service;

import br.com.devpradev.mapper.PostMapper;
import br.com.devpradev.models.dto.MessageResponseDTO;
import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.models.entity.Post;
import br.com.devpradev.repository.PostRepository;
import br.com.devpradev.util.exception.PostExistException;
import br.com.devpradev.util.exception.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
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
	public MessageResponseDTO savePost(PostDTO postDTO) throws PostExistException {
		Optional<Post> optionalPost = postRepository.findById(postDTO.getIdPost());
		if (optionalPost.isPresent()) {
			throw new PostExistException(postDTO.getIdPost());
		} else {
			Post postToSave = postMapper.toModel(postDTO);
			postRepository.save(postToSave);
			return createMessageResponse("Post criado!");
		}
	}

	@Transactional
	public List<PostDTO> findAll() {
		List<Post> allPosts = postRepository.findAll();
		return allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
	}

	@Transactional
	public MessageResponseDTO findById(Long id, PostDTO postDTO) throws PostNotFoundException {
		Post post = verificarExistencia(id);

		postMapper.toDTO(post);
		return createMessageResponse("ID" + id + "encontrado");
	}

	@Transactional
	public MessageResponseDTO delete(@PathVariable Long id) throws PostNotFoundException {
		verificarExistencia(id);

		postRepository.deleteById(id);
		return createMessageResponse("Post deletado");
	}

	@Transactional
	public MessageResponseDTO updateById(Long id, PostDTO postDTO) throws PostExistException {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent()) {
			throw new PostExistException(id);
		} else {
			postMapper.toModel(postDTO);
			return createMessageResponse("Post atualizado!");
		}
	}

	private Post verificarExistencia(Long id) throws PostNotFoundException {
		return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(String messege) {
		return MessageResponseDTO.builder().message(messege).build();
	}

}