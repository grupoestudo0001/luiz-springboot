package br.com.luiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.luiz.model.Setor;

@Service
public class SetorService {

	private Logger log = Logger.getLogger(SetorService.class.getName());
	
	public List<Setor> findAll(){
		
		log.info("Retornando todos os setores");
		
		List<Setor> setores = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Setor setor = mockSetor(i);
			setores.add(setor);
		}
		return setores;
		
	}
	
	private Setor mockSetor(int i) {
		Setor setor = new Setor();
		setor.setId(0L);
		setor.setDescricao("setor 1");
		setor.setDatacriacao(null);
		setor.setInativo(true);
		return setor;		
	}
}
