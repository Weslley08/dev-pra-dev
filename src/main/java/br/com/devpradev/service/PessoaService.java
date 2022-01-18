package br.com.devpradev.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devpradev.mapper.PessoaMapper;
import br.com.devpradev.models.dto.PessoaDTO;
import br.com.devpradev.models.entity.Pessoa;
import br.com.devpradev.repository.PessoaRepository;
import br.com.devpradev.utils.MessageResponse;
import br.com.devpradev.utils.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private static PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MessageResponse createUser(PessoaDTO pessoaDTO) {
        Pessoa pessoaToSave = pessoaMapper.toModel(pessoaDTO);

        Pessoa savedPerson = pessoaRepository.save(pessoaToSave);
        return createMessageResponse(savedPerson.getIdPessoa(), "Usuário criado com o ID: ");
    }

    public List<PessoaDTO> findAll() {
        List<Pessoa> allPerson = pessoaRepository.findAll();
        return allPerson.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());

    }

    public PessoaDTO findById(Long id) throws NotFoundException {
        Pessoa person = verifyIfExists(id);

        return pessoaMapper.toDTO(person);
    }

    public void delete(Long id) throws NotFoundException {
        verifyIfExists(id);
        pessoaRepository.deleteById(id);
    }

    public MessageResponse updateById(Long id, PessoaDTO pessoaDTO) throws NotFoundException {
        verifyIfExists(id);

        Pessoa pessoaToUpdate = pessoaMapper.toModel(pessoaDTO);

        Pessoa updatedP = pessoaRepository.save(pessoaToUpdate);
        return createMessageResponse(updatedP.getIdPessoa(), "Pessoa atualizada com o ID ");
    }

    private MessageResponse createMessageResponse(Long id, String message) {
        return MessageResponse
                .builder()
                .message(message + id)
                .build();
    }

    private Pessoa verifyIfExists(Long id) throws NotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

}
