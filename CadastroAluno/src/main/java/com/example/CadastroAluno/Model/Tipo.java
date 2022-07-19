package com.example.CadastroAluno.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tipo;
	
	@OneToMany(mappedBy = "tipo")
	private List <Alunos> alunos;

	/**
	 * @param id
	 * @param tipo
	 * @param alunos
	 */
	public Tipo(int id, String tipo, List<Alunos> alunos) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.alunos = alunos;
	}

	public Tipo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}
	
	
	
}
