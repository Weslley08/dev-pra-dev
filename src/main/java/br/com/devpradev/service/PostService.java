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
    public Post update(Long id, Post objPost) {
        Post oldObjPost = findById(id);

        oldObjPost.setTitulo(objPost.getTitulo());
        oldObjPost.setAutor(objPost.getAutor());
        oldObjPost.setTexto(objPost.getTexto());
        oldObjPost.setData(objPost.getData());
        return postRepository.save(oldObjPost);
    }

    @Transactional
    public Post update(Long id) {
        Post post = this.findById(id);
        postRepository.save(post);
        return post;
    }

    @Transactional
    public Post delete(Long id) {
        Post post = this.findById(id);
        postRepository.deleteById(post.getIdPost());
        return post;
    }
}
