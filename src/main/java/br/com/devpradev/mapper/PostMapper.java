package br.com.devpradev.mapper;

import br.com.devpradev.models.dto.PostDTO;
import br.com.devpradev.models.entity.Post;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post toModel(PostDTO postDTO);
    PostDTO toDTO(Post post);
    
}
