package br.com.devpradev.service;

import br.com.devpradev.models.entity.Post;
import br.com.devpradev.repository.PostRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Transactional
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    public Post findById(long id) {
        return postRepository.findById(id).get();
    }

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Post post) {
        Post atualizarPost = post;
        return postRepository.save(atualizarPost);
    }

    @Transactional
    public Post delete(Long id) {
        Post post = this.findById(id);
        postRepository.deleteById(post.getIdPost());
        return post;
    }
}
