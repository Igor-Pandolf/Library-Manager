package com.projetos.LibraryManager.LibraryManager.Autores.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetos.LibraryManager.LibraryManager.Livros.Models.LivroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_autores")
@NoArgsConstructor
@AllArgsConstructor
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @OneToMany(mappedBy = "autor") // Vai pegar os livros que tem esse "autor"
    @JsonIgnore
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
