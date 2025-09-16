package com.projetos.LibraryManager.LibraryManager.Livros.Controllers;

import com.projetos.LibraryManager.LibraryManager.Autores.DTOs.AutorDTO;
import com.projetos.LibraryManager.LibraryManager.Livros.DTOs.LivroDTO;
import com.projetos.LibraryManager.LibraryManager.Livros.Services.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LivroDTO>> listarLivros(){
        List<LivroDTO> livros = service.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        LivroDTO livro = service.listarPorId(id);

        if (livro != null){
            return ResponseEntity.ok(livro);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro com o id: " + id + " não encontrado!");
        }
    }

    @GetMapping("/listar/genero/{genero}")
    public ResponseEntity<?> listarPorGenero(@PathVariable String genero){
        List<LivroDTO> livrosEncontrados = service.listarPorGenero(genero);

        if (livrosEncontrados != null){
            return ResponseEntity.ok(livrosEncontrados);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não temos livros do gênero: " + genero);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){

        if (service.listarPorId(id) != null){
            service.deletar(id);
            return ResponseEntity.ok("Livro com id: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro com id: " + id + " não encontrado!");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarLivro(@RequestBody LivroDTO livroDTO){
        LivroDTO livroCadastrado = service.cadastrarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Livro " + livroCadastrado.getTitulo() + " cadastrado com sucesso!");
    }
}
