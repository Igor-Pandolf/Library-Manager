package com.projetos.LibraryManager.LibraryManager.Autores;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetos.LibraryManager.LibraryManager.Livros.LivroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_autores")
@Data
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
}
