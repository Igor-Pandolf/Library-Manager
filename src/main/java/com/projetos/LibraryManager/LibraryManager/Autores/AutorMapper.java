package com.projetos.LibraryManager.LibraryManager.Autores;

import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorModel map(AutorDTO autorDTO) {
        AutorModel autorModel = new AutorModel();
        autorModel.setId(autorDTO.getId());
        autorModel.setNome(autorDTO.getNome());
        autorModel.setNacionalidade(autorDTO.getNacionalidade());
        autorModel.setLivro(autorDTO.getLivro());

        return autorModel;
    }

    public AutorDTO map(AutorModel autorModel) {
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autorModel.getId());
        autorDTO.setNome(autorModel.getNome());
        autorDTO.setNacionalidade(autorModel.getNacionalidade());
        autorDTO.setLivro(autorModel.getLivro());

        return autorDTO;
    }
}
