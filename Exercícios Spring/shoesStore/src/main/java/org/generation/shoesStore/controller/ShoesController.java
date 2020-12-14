package org.generation.shoesStore.controller;

import java.util.List;

import org.generation.shoesStore.model.Shoes;
import org.generation.shoesStore.repository.ShoesRepository;
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
@RequestMapping ("/shoes")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ShoesController {
	
	@Autowired
	private ShoesRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Shoes>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Shoes> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/size/{size}")
	public ResponseEntity<List<Shoes>> getBySize(@PathVariable int size){
		return ResponseEntity.ok(repository.findAllBySize(size));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Shoes>> getByName(@PathVariable String name){
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	
	@PostMapping
	public ResponseEntity<Shoes> postNew(@RequestBody Shoes shoes){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(shoes));
	}
	
	@PutMapping
	public ResponseEntity<Shoes> editExisting(@RequestBody Shoes shoes){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(shoes));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteById (@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
