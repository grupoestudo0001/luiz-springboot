package br.com.luiz.services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luiz.exceptions.ResourceNotFoundException;
import br.com.luiz.model.Setor;
import br.com.luiz.repositories.SetorRepository;

@Service
public class SetorService 
{
	private Logger log = Logger.getLogger(SetorService.class.getName());
	
	//injeção de dependencia do repositorio
	@Autowired
	SetorRepository repo;
	
	
	public List<Setor> encontrarTodos()
	{	
		log.info("Retornando todos os setores");	
		return repo.findAll();
	}
	
	
	public Setor encontrarPorId(Long id) 
	{
		log.info("Encontrando por id.");
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));		
	}
	
	
	public Setor criar(Setor st) 
	{
		log.info("Criando um setor");
		return repo.save(st);
	}
	
	
	public Setor atualizar(Setor st) 
	{
		log.info("Atualizando uma pessoa");
		var se = repo.findById(st.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		
		se.setDescricao(st.getDescricao());
		se.setDatacriacao(st.getDatacriacao());
		se.setInativo(st.getInativo());
		
		return repo.save(st);		
	}
	
	
	public void apagar(Long id) 
	{
		log.info("Apagando um setor");
		var se = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		repo.delete(se);
	}
}
