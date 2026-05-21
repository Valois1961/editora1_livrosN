package org.serratec.aula06_07.repository;
import org.serratec.aula06_07.domain.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
