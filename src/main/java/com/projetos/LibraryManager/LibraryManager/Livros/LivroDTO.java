package com.projetos.LibraryManager.LibraryManager.Livros;

import com.projetos.LibraryManager.LibraryManager.Autores.AutorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

    private Long id;
    private String titulo;
    private String genero;
    private Date ano;
    private AutorModel autor;
}
