package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Itanagra");
        endereco.setEndereco("Vila Bozzini");
        endereco.setNumero("967");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setCep(8230250);

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua Jupurabi");
        endereco2.setEndereco("Parque Fongaro");
        endereco2.setNumero("109");
        endereco2.setCidade("São Paulo");
        endereco2.setEstado("SP");
        endereco2.setCep(425780);

        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("98387-6567");

        Telefone telefone2 = new Telefone();
        telefone2.setDDD("11");
        telefone2.setNumero("99588-0923");

        // 1) Criando um aluno
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Juan Enrico João Silva");
        aluno.setMatricula("123456789");
        aluno.setNascimento(LocalDate.of(2002, 6, 14));
        aluno.setEmail("juan_silva@asconnet.com.br");
        aluno.setEndereco(List.of(endereco));
        aluno.setTelefones(List.of(telefone));

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("Eduarda Mariane Moraes");
        aluno2.setMatricula("1011121314");
        aluno2.setNascimento(LocalDate.of(2002, 1, 13));
        aluno2.setEmail("eduarda-moraes79@esctech.com.br");
        aluno2.setEndereco(List.of(endereco2));
        aluno2.setTelefones(List.of(telefone2));

        alunoModel.create(aluno);
        alunoModel.create(aluno2);

        // 2) Buscando aluno pelo id
        alunoModel.findById(1L);

        // 3) Buscando todos os alunos na base de dados
        alunoModel.findAll();

        // 4) Atualizando um aluno
        aluno.setNomeCompleto("Juan Enrico João Silva");
        alunoModel.update(aluno);

        // 5) Deletando um aluno
        alunoModel.delete(aluno);

        CursoModel cursoModel = new CursoModel();

        // 1) Criando um curso
        Professor professor = new Professor();
        professor.setNomeCompleto("Raimundo Raul Fernandes");
        professor.setMatricula("987654321");
        professor.setEmail("raimundo-fernandes83@tivit.com.br");

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("shorturl.at/kpqCZ");

        Curso curso = new Curso();
        curso.setNome("Java");
        curso.setSigla("JAVA");
        curso.setProfessor(professor);
        curso.setAlunos(List.of(aluno));
        curso.setMaterialCurso(materialCurso);

        cursoModel.create(curso);

        // 2) Buscando curso pelo id
        cursoModel.findById(1L);

        // 3) Buscando todos os cursos na base de dados
        cursoModel.findAll();

        //4) Atualizando um curso
        curso.setNome("Java básico");
        cursoModel.update(curso);

        // 5) Deletando um curso
        cursoModel.delete(curso);
    }
}