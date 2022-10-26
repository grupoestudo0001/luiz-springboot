package br.com.luiz.controllers;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.luiz.model.Setor;
import br.com.luiz.services.SetorService;

@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorService service;
	
	
	@RequestMapping(method = RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Setor> findAll()
	{
		return service.encontrarTodos();
	}
	
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Setor findById(@PathVariable(value = "id") Long id) 
	{
		return service.encontrarPorId(id);	
	}
	
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Setor create(@RequestBody Setor setor) 
	{
		return service.criar(setor);
	}
	

	@RequestMapping(method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Setor update(@RequestBody Setor setor) 
	{
		return service.atualizar(setor);
	}
	

	@RequestMapping(value = "/{id}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) 
	{
		service.apagar(id);	
	}
}
