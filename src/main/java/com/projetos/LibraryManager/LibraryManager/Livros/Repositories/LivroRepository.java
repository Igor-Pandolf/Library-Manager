package com.projetos.LibraryManager.LibraryManager.Livros.Repositories;

import com.projetos.LibraryManager.LibraryManager.Livros.Models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
