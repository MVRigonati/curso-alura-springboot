package br.com.alura.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.springboot.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	public List<Topico> findByCursoNomeLike(String courseName);
	
}
