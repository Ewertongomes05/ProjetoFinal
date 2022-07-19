package com.example.CadastroAluno.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.example.CadastroAluno.Model.Alunos;

public interface AlunosInterface {
	
	public List<Alunos> listar();
	public Optional<Alunos> listarPeloId(Integer matricula);
}
