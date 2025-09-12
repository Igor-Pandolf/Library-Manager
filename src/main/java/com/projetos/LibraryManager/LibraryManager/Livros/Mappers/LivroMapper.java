package com.projetos.LibraryManager.LibraryManager.Livros.Mappers;

import com.projetos.LibraryManager.LibraryManager.Livros.DTOs.LivroDTO;
import com.projetos.LibraryManager.LibraryManager.Livros.Models.LivroModel;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public LivroModel map(LivroDTO livroDTO) {
        LivroModel livroModel = new LivroModel();
        livroModel.setId(livroDTO.getId());
        livroModel.setTitulo(livroDTO.getTitulo());
        livroModel.setGenero(livroDTO.getGenero());
        livroModel.setAno(livroDTO.getAno());
        livroModel.setAutor(livroDTO.getAutor());

        return livroModel;
    }

    public LivroDTO map(LivroModel livroModel) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livroModel.getId());
        livroDTO.setTitulo(livroModel.getTitulo());
        livroDTO.setGenero(livroModel.getGenero());
        livroDTO.setAno(livroModel.getAno());
        livroDTO.setAutor(livroModel.getAutor());

        return livroDTO;
    }
}
