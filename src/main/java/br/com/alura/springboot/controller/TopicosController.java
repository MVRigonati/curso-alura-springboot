package br.com.alura.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springboot.dto.TopicoDTO;
import br.com.alura.springboot.model.Topico;
import br.com.alura.springboot.repository.TopicoRepository;

@RestController()
public class TopicosController {
	
	@Autowired
	private TopicoRepository repository;

	@RequestMapping(value = "/topicos", method = RequestMethod.GET)
	public List<TopicoDTO> topicos() {
		final List<Topico> allTopicos = this.repository.findAll();
		return TopicoDTO.parseList(allTopicos);
	}
	
	@RequestMapping(value = "/topicos", params = {"courseName"}, method = RequestMethod.GET)
	public List<TopicoDTO> topicosWithFilter(final String courseName) {
		
		List<Topico> allTopicos = new ArrayList<>();
		if (courseName != null && !courseName.isEmpty())
			allTopicos = this.repository.findByCursoNomeLike("%" + courseName + "%");
		
		return TopicoDTO.parseList(allTopicos);
	}
	
}
