package com.example.CadastroAluno.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CadastroAluno.InterfaceService.TipoInterface;
import com.example.CadastroAluno.Model.Tipo;
import com.example.CadastroAluno.Repository.TipoRepository;

@Service
public class TipoService implements TipoInterface{
	
	@Autowired
	private TipoRepository data;
	
	@Override
	public List<Tipo> listar(){
		return (List<Tipo>) data.findAll();
		
	}

}
