package org.serratec.aula06_07.controller;
import java.util.List;
import org.serratec.aula06_07.domain.Editora;
import org.serratec.aula06_07.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/editoras")
public class EditoraController {
    @Autowired
    private EditoraRepository repository;
    @PostMapping
    public ResponseEntity<Editora> inserir(@RequestBody Editora editora) {
    	System.out.println("Chegou no Post Editora");
    	Editora editoraSalva = repository.save(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(editoraSalva);
    }
    @GetMapping
    public ResponseEntity<List<Editora>> listar() {
        List<Editora> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/{id}")
    public Editora buscar(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
}

