package br.com.devpradev.service;

import br.com.devpradev.models.entity.Post;
import br.com.devpradev.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService  {
    
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll(sortByIdAsc());
    }

    @Override
    public Post findById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    private Sort sortByIdAsc() {
        return Sort.by(Sort.DEFAULT_DIRECTION, "id");
    }
}
