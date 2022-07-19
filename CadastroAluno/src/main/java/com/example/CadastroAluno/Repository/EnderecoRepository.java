package com.example.CadastroAluno.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CadastroAluno.Model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

}
