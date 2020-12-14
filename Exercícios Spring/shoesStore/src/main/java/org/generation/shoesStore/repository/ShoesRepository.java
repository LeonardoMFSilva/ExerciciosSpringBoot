package org.generation.shoesStore.repository;

import java.util.List;

import org.generation.shoesStore.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {
	public List<Shoes> findAllByNameContainingIgnoreCase (String name);
	
	public List<Shoes> findAllBySize (int size);
}
