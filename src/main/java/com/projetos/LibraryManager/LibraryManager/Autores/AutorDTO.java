package com.projetos.LibraryManager.LibraryManager.Autores;

import com.projetos.LibraryManager.LibraryManager.Livros.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {

    private Long id;
    private String nome;
    private String nacionalidade;
    private List<LivroModel> livro;
}
