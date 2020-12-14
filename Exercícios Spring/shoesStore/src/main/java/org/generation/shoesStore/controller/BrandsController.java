package org.generation.shoesStore.controller;

import java.util.List;

import org.generation.shoesStore.model.Brands;
import org.generation.shoesStore.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/brands")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class BrandsController {
	
	@Autowired
	private BrandsRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Brands>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Brands> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/brand/{brand}")
	public ResponseEntity<List<Brands>> getByName(@PathVariable String brandName){
		return ResponseEntity.ok(repository.findAllBybrandNameContainingIgnoreCase(brandName));
	}
	
	@PostMapping
	public ResponseEntity<Brands> postNew(@RequestBody Brands brand){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(brand));
	}
	
	@PutMapping
	public ResponseEntity<Brands> editExisting(@RequestBody Brands brand){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(brand));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteById (@PathVariable long id) {
		repository.deleteById(id);
	}

}
