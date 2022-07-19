package com.example.CadastroAluno.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CadastroAluno.Model.Curso;

@Repository
public interface CursoRepository  extends CrudRepository<Curso, Integer>{
	
	
}
