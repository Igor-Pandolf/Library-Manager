package com.projetos.LibraryManager.LibraryManager.Autores.Repositories;

import com.projetos.LibraryManager.LibraryManager.Autores.Models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
