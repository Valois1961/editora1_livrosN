package org.serratec.aula06_07.controller;
import java.util.List;
import java.util.Optional;
import org.serratec.aula06_07.domain.Editora;
import org.serratec.aula06_07.domain.Livro;
import org.serratec.aula06_07.repository.EditoraRepository;
import org.serratec.aula06_07.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EditoraRepository editoraRepository;
    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody Livro livro) {
        if (livro.getEditora() == null ||
            livro.getEditora().getId() == null) {
            return ResponseEntity.badRequest()
                    .body("O id da editora deve ser informado.");
        }
        Optional<Editora> editora =
                editoraRepository.findById(
                        livro.getEditora().getId());
        if (editora.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Editora não encontrada.");
        }
        livro.setEditora(editora.get());
        Livro livroSalvo = livroRepository.save(livro);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(livroSalvo);
    }
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> lista = livroRepository.findAll();
        return ResponseEntity.ok(lista);
    }
}

