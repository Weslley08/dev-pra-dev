package br.com.devpradev.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.devpradev.utils.MessageResponse;
import br.com.devpradev.models.dto.PessoaDTO;
import br.com.devpradev.service.PessoaService;
import br.com.devpradev.utils.Endpoints;
import br.com.devpradev.utils.exceptions.NotFoundException;

import javax.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.REQUEST_PESSOA)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping(path = Endpoints.REQUEST_PESSOA_CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.createUser(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping(path = Endpoints.REQUEST_PESSOA_FIND_BY_ID)
    public PessoaDTO findById(@PathVariable Long id) throws NotFoundException {
        return pessoaService.findById(id);
    }

    @PutMapping(path = Endpoints.REQUEST_PESSOA_UPDATE)
    public MessageResponse updateById(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO)
            throws NotFoundException {
        return pessoaService.updateById(id, pessoaDTO);
    }

    @DeleteMapping(path = Endpoints.REQUEST_PESSOA_DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NotFoundException {
        pessoaService.delete(id);
    }
}
