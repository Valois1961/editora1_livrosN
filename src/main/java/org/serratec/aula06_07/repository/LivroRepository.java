package org.serratec.aula06_07.repository;
import org.serratec.aula06_07.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroRepository extends JpaRepository<Livro, Long> {
}