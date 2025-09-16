package com.projetos.LibraryManager.LibraryManager.Livros.Repositories;

import com.projetos.LibraryManager.LibraryManager.Livros.Models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

    /**
     * Busca todos os livros que correspondem a um determinado gênero, ignorando maiúsculas e minúsculas.
     * Ex: "terror", "Terror" e "TERROR" retornarão os mesmos resultados.
     * @param genero O gênero a ser pesquisado.
     * @return Uma lista de LivroModel encontrados.
     */
    List<LivroModel> findByGeneroIgnoreCase(String genero);
}
