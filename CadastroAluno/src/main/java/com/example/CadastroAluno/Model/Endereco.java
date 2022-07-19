package com.example.CadastroAluno.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cep;
	private String uf;
	private String cidade;
	private String rua;
	private String bairro;
	private int numero;
	private String complemento;
	
	//Quando excluir um aluno ele tambem vai excluir o endereço associado
	@OneToMany(mappedBy = "endereco", 
			cascade = {CascadeType.ALL}, //Cascade - associa o aluno ao endereço
			fetch = FetchType.EAGER) //EAGER - carrega os dados para o banco
	private List<Alunos> alunos;
	
	public Endereco() {
	}

	/**
	 * @param id
	 * @param cep
	 * @param uf
	 * @param cidade
	 * @param rua
	 * @param numero
	 * @param complemento
	 * @param alunos
	 */
	public Endereco(int id, int cep, String uf, String cidade, String rua, int numero, String complemento,
			List<Alunos> alunos) {
		super();
		this.id = id;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.alunos = alunos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
