package br.com.devpradev.service;

import java.util.List;

import br.com.devpradev.models.entity.Post;

public interface PostService {
    
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
}
