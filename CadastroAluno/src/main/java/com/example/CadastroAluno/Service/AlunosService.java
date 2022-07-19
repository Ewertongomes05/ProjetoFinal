package com.example.CadastroAluno.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CadastroAluno.InterfaceService.AlunosInterface;
import com.example.CadastroAluno.Model.Alunos;
import com.example.CadastroAluno.Repository.AlunosRepository;

@Service
public class AlunosService implements AlunosInterface{
	
	
	@Autowired
	private AlunosRepository data;
	
	@Override
	public List<Alunos> listar(){
		return (List<Alunos>) data.findAll();
		
	}
	
	@Override
	public Optional<Alunos> listarPeloId(Integer matricula){
		return (Optional<Alunos>) data.findById(matricula);	
		
	}
	
}
