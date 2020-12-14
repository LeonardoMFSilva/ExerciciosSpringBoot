package org.generation.Eletros.repository;

import java.util.List;

import org.generation.Eletros.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);

}
