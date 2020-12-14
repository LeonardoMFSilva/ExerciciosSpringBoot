package org.generation.Eletros.repository;

import java.util.List;


import org.generation.Eletros.model.TipoEletro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tipoEletroRepository extends JpaRepository<TipoEletro, Long> {
	public List<TipoEletro> findAllByDescricaoContainingIgnoreCase (String descricao);
}
