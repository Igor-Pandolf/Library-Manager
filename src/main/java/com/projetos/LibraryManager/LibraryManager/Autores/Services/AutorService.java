package com.projetos.LibraryManager.LibraryManager.Autores.Services;

import com.projetos.LibraryManager.LibraryManager.Autores.DTOs.AutorDTO;
import com.projetos.LibraryManager.LibraryManager.Autores.Mappers.AutorMapper;
import com.projetos.LibraryManager.LibraryManager.Autores.Models.AutorModel;
import com.projetos.LibraryManager.LibraryManager.Autores.Repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private final AutorRepository repository;
    private final AutorMapper mapper;

    public AutorService(AutorRepository repository, AutorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AutorDTO> listarAutores(){
        List<AutorModel> autores = repository.findAll();

        return autores.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public AutorDTO listarPorId(Long id){
        Optional<AutorModel> autorEncontrado = repository.findById(id);
        return autorEncontrado.map(mapper::map).orElse(null);
    }

    public AutorDTO cadastrarAutor(AutorDTO autorDTO){
        AutorModel autorModel = mapper.map(autorDTO);
        autorModel = repository.save(autorModel);
        return mapper.map(autorModel);
    }
}
