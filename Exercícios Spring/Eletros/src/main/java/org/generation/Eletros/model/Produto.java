package org.generation.Eletros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size (min = 1, max = 50)
	private String nome;
	
	@NotNull
	@NumberFormat
	private float preco;
	
	@NotNull
	@NumberFormat
	private int quantidade;
	
	@NotBlank
	@Size(min = 1, max = 10)
	private String marca;
	
	@ManyToOne 
	@JsonIgnoreProperties ("produto")
	private TipoEletro tipoEletro;
	
	@ManyToOne 
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TipoEletro getTipoEletro() {
		return tipoEletro;
	}

	public void setTipoEletro(TipoEletro tipoEletro) {
		this.tipoEletro = tipoEletro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
