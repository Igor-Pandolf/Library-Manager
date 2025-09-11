package com.projetos.LibraryManager.LibraryManager.Livros;

import com.projetos.LibraryManager.LibraryManager.Autores.AutorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tb_livros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String genero;

    private Date ano;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autor;
}
