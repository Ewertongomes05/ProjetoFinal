package com.example.CadastroAluno.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "alunos")
public class Alunos {
	
	//Auto incremento de matricula na tabela
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula;
	
	
	private String cpf;
	private String email;
	private String nome;
	private String sexo;
	private Date data_nasc;
	
	//Relacionamento muitos para um - um curso pode ter varios alunos
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	//Relacionamento muitos para um - um tipo pode ter varios alunos
	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	//Relacionamento muitos para um - um Endereço pode ter varios alunos
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	/**
	 * @param matricula
	 * @param cpf
	 * @param email
	 * @param nome
	 * @param sexo
	 * @param data_nasc
	 * @param curso
	 * @param tipo
	 * @param endereco
	 */
	public Alunos(Integer matricula, String cpf, String email, String nome, String sexo, Date data_nasc, Curso curso,
			Tipo tipo, Endereco endereco) {
		super();
		this.matricula = matricula;
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.sexo = sexo;
		this.data_nasc = data_nasc;
		this.curso = curso;
		this.tipo = tipo;
		this.endereco = endereco;
		
		
	}

	public Alunos() {
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	

	
}
