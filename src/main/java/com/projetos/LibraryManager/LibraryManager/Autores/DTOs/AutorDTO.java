package com.projetos.LibraryManager.LibraryManager.Autores.DTOs;

import com.projetos.LibraryManager.LibraryManager.Livros.Models.LivroModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {

    private Long id;
    private String nome;
    private String nacionalidade;
    private List<LivroModel> livro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<LivroModel> getLivro() {
        return livro;
    }

    public void setLivro(List<LivroModel> livro) {
        this.livro = livro;
    }
}
