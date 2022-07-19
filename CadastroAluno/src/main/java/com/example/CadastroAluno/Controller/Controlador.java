package com.example.CadastroAluno.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CadastroAluno.InterfaceService.AlunosInterface;
import com.example.CadastroAluno.InterfaceService.CursoInterface;
import com.example.CadastroAluno.InterfaceService.TipoInterface;

import com.example.CadastroAluno.Model.Alunos;
import com.example.CadastroAluno.Model.Curso;
import com.example.CadastroAluno.Model.Tipo;

import com.example.CadastroAluno.Repository.AlunosRepository;
import com.example.CadastroAluno.Repository.CursoRepository;
import com.example.CadastroAluno.Repository.EnderecoRepository;
import com.example.CadastroAluno.Repository.TipoRepository;



@Controller
@RequestMapping
public class Controlador {
	
	
	@Autowired
	private AlunosInterface servicealunos;
	
	@Autowired
	private AlunosRepository repoalunos;
	
	@Autowired
	private CursoInterface servicecursos;
	
	@SuppressWarnings("unused")
	@Autowired
	private CursoRepository repocursos;
	
	@Autowired
	private TipoInterface servicetipos;
	
	@SuppressWarnings("unused")
	@Autowired
	private TipoRepository repotipos;
	
	@Autowired
	private EnderecoRepository repoendereco;
	
	
	// Pagina de Login
	@GetMapping("/login")
	public String Login() {
		return"login";
	}
	
	//Pagina index (listagem dos alunos cadastrados
	@GetMapping("/")
	public String Index(Model model) {
		
		List <Alunos> alunos = servicealunos.listar();
		model.addAttribute("alunos", alunos);
		
		return "index";
	}
	
	@GetMapping(value = "/{matricula}")
    public String userView(@PathVariable("matricula") Integer matricula, Model model){

        Alunos aluno = repoalunos.findById(matricula).get();
        model.addAttribute("alunos", aluno);

        return "index";
    }

	@GetMapping("/Cadastrar")
    public String Cadastrar(Model model){
		
		//Cadastro de alunos
        Alunos alunos = new Alunos();
        model.addAttribute("alunos", alunos);
        
        //lista os cursos da tabela Curso
        List<Curso> cursos = servicecursos.listar();
        model.addAttribute("cursos", cursos);
        
      //lista os tipos da tabela Tipo
        List<Tipo> tipos = servicetipos.listar();
        model.addAttribute("tipos", tipos);

        return "insert-update/cadastro";
    }

	
	//Pagina de cadastro realizado
	@GetMapping(value = "/Cadastrar/sucesso")
	public String SucessForm() {
		return "insert-update/sucesso";
	}

	//Pagina de editar matricula
	@GetMapping(value = "/editar/{matricula}")
	public String EditForm(@PathVariable("matricula") Integer matricula, Model model) {
		
		//Edição de cadastro de alunos
		Optional<Alunos> aluno = repoalunos.findById(matricula);
		model.addAttribute("pessoaobj", aluno.get());
		
		//Listagem de Cursos
		List<Curso> cursos = servicecursos.listar();
		model.addAttribute("cursos", cursos);
		
		//Listagem de Tipo
		List<Tipo> tipos = servicetipos.listar();
		model.addAttribute("tipos", tipos);
		
		return "insert-update/editar";
	}
	
	@GetMapping(value = "/remove/{matricula}")
    public String deleteForm(@PathVariable("matricula") Integer matricula){

		//Exclusão de aluno + cascateamento de endereço.
        Alunos aluno = repoalunos.findById(matricula).get();
        repoendereco.delete(aluno.getEndereco());
        repoalunos.delete(aluno);

        return "redirect:/";
    }
	
	@PostMapping(value = "/salvar")
    public String CadastroForm(@ModelAttribute ("Alunos") Alunos alunos){

        repoendereco.save(alunos.getEndereco());
        repoalunos.save(alunos);

        return "redirect:Cadastrar/sucesso";
    }
	
	@PostMapping(value = "/editar")
    public String EditarForm(@ModelAttribute ("Alunos") Alunos alunos){

		//Edição de endereço dentro da edição de alunos e endereço
        repoendereco.save(alunos.getEndereco());
        repoalunos.save(alunos);

        return "redirect:/";
    }
}





















