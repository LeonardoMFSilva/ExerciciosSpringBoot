package org.generation.shoesStore.repository;

import java.util.List;

import org.generation.shoesStore.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<Brands, Long>{
	
	public List<Brands> findAllBybrandNameContainingIgnoreCase (String name);

}
