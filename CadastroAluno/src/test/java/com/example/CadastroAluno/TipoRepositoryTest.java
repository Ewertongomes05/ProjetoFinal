package com.example.CadastroAluno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.CadastroAluno.Model.Tipo;
import com.example.CadastroAluno.Repository.TipoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TipoRepositoryTest {

    @Autowired
    private TipoRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void TestCreatedTipo(){
        Tipo tipo = new Tipo();

        tipo.setTipo("Primeiro");

        Tipo savedTipo = repo.save(tipo);

        Tipo existTipo = entityManager.find(Tipo.class, savedTipo.getId());

        assert(existTipo.getTipo().equals(tipo.getTipo()));
    }

}
