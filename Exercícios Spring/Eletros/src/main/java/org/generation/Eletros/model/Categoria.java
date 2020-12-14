package org.generation.Eletros.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size (min = 5, max = 255)
	private String descricao;
	
	@OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("categoria")
	private List<Produto> produto;
	
	@ManyToOne
	@JsonIgnoreProperties ("categoria")
	private TipoEletro tipoEletro;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public TipoEletro getTipoEletro() {
		return tipoEletro;
	}

	public void setTipoEletro(TipoEletro tipoEletro) {
		this.tipoEletro = tipoEletro;
	}
	
	

}
