package com.example.CadastroAluno.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CadastroAluno.InterfaceService.CursoInterface;
import com.example.CadastroAluno.Model.Curso;
import com.example.CadastroAluno.Repository.CursoRepository;

@Service
public class CursoService implements CursoInterface{
	
	@Autowired
	private CursoRepository data;

	@Override
	public List<Curso> listar() {
		return (List<Curso>) data.findAll();
		
	}
}
