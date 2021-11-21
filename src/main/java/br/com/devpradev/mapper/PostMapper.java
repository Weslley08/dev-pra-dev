package br.com.devpradev.mapper;

import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.models.entity.Post;

// import org.mapstruct.Mapper;
// import org.mapstruct.factory.Mappers;

// @Mapper

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public Post toModel(PostDTO postDTO) {
        Post post = new Post();
        post.setIdPost(postDTO.getIdPost());
        post.setTitulo(postDTO.getTitulo());
        post.setAutor(postDTO.getAutor());
        post.setTexto(postDTO.getTexto());
        post.setData(postDTO.getData());
        return post;
    }

    public PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setIdPost(post.getIdPost());
        postDTO.setTitulo(post.getTitulo());
        postDTO.setAutor(post.getAutor());
        postDTO.setTexto(post.getTexto());
        postDTO.setData(post.getData());
        return postDTO;
    }

    public List<PostDTO> toDTO(List<Post> listPost) {
        return listPost.stream().map(this::toDTO).collect(Collectors.toList());
    }

    // PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    // Post toModel(PostDTO postDTO);

    // PostDTO toDTO(Post post);

}
