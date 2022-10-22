package br.com.luiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luiz.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {}
