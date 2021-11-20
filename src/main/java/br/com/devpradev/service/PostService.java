package br.com.devpradev.service;

import br.com.devpradev.mapper.PostMapper;
import br.com.devpradev.models.dto.MessageResponseDTO;
import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.models.entity.Post;
import br.com.devpradev.repository.PostRepository;

import br.com.devpradev.util.exception.PostNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private static PostMapper postMapper = PostMapper.INSTANCE;

	@Transactional
	public MessageResponseDTO savePost(PostDTO postDTO){
		Post postToSave = postMapper.toModel(postDTO);

		Post savedPost = postRepository.save(postToSave);
		return createMessageResponde (savedPost.getIdPost(),"Post criado! ");
	}

	@Transactional
	public List<PostDTO> findAll(){
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
		return createMessageResponde(postToUpdate.getIdPost(),"Post atualizado!");
	}
	

	private Post verificarExistencia(Long id) throws PostNotFoundException {
		return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponde(Long id, String messege){
		return MessageResponseDTO.builder().message(messege + id).build();
	}


































//	@Transactional
//	public List<Post> findAll() {
//		return postRepository.findAll();
//	}
//
//	@Transactional
//	public Post findById(long id) {
//		return postRepository.findById(id).get();
//	}
//
//	@Transactional
//	public Post save(Post post) {
//		return postRepository.save(post);
//	}
//
//	@Transactional
//	public Post update(Long id, Post objPost) {
//		Post oldObjPost = findById(id);
//
//		oldObjPost.setTitulo(objPost.getTitulo());
//		oldObjPost.setAutor(objPost.getAutor());
//		oldObjPost.setTexto(objPost.getTexto());
//		oldObjPost.setData(objPost.getData());
//		return postRepository.save(oldObjPost);
//	}
//
//	@Transactional
//	public Post update(Long id) {
//		Post post = this.findById(id);
//		postRepository.save(post);
//		return post;
//	}
//
//	@Transactional
//	public Post delete(Long id) {
//		Post post = this.findById(id);
//		postRepository.deleteById(post.getIdPost());
//		return post;
//	}

}
