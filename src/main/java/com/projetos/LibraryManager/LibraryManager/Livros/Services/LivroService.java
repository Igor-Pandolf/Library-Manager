package com.projetos.LibraryManager.LibraryManager.Livros.Services;

import com.projetos.LibraryManager.LibraryManager.Livros.DTOs.LivroDTO;
import com.projetos.LibraryManager.LibraryManager.Livros.Mappers.LivroMapper;
import com.projetos.LibraryManager.LibraryManager.Livros.Models.LivroModel;
import com.projetos.LibraryManager.LibraryManager.Livros.Repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;

    public LivroService(LivroRepository repository, LivroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // listar todos
    public List<LivroDTO> listarLivros(){
        List<LivroModel> livros = repository.findAll();

        return livros.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    // listar por id
    public LivroDTO listarPorId(Long id){
        Optional<LivroModel> livroEncontrado = repository.findById(id);
        return livroEncontrado.map(mapper::map).orElse(null);
    }

    // listar por genero
    public List<LivroDTO> listarPorGenero(String genero){
        List<LivroModel> livrosEncontrados = repository.findByGeneroIgnoreCase(genero);

        if (!livrosEncontrados.isEmpty()){
            return livrosEncontrados.stream()
                    .map(mapper::map)
                    .collect(Collectors.toList());
        }

        return null;
    }

    // deletar
    public void deletar(Long id){
        repository.deleteById(id);
    }

    // cadastrar
    public LivroDTO cadastrarLivro(LivroDTO livroDTO){
        LivroModel livroModel = mapper.map(livroDTO);
        livroModel = repository.save(livroModel);
        return mapper.map(livroModel);
    }
}
