package com.projetos.LibraryManager.LibraryManager.Autores.Controllers;

import com.projetos.LibraryManager.LibraryManager.Autores.DTOs.AutorDTO;
import com.projetos.LibraryManager.LibraryManager.Autores.Services.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AutorDTO>> listarAutores(){
        List<AutorDTO> autores = service.listarAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        AutorDTO autor = service.listarPorId(id);

        if (autor != null){
            return ResponseEntity.ok(autor);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Autor com o id: " + id + " não encontrado!");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarAutor(@RequestBody AutorDTO autorDTO){
        AutorDTO autorCadastrado = service.cadastrarAutor(autorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Autor " + autorCadastrado.getNome() + " cadastrado com sucesso!");
    }
}
