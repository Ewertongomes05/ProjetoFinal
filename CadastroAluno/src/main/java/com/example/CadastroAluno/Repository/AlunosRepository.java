package com.example.CadastroAluno.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CadastroAluno.Model.Alunos;


@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {
	
	List<Alunos> findByNomeContains(String nome);
	
}
