package com.example.CadastroAluno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CadastroAluno.Model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer>{
}
