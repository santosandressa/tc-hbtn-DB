package entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_curso")
    private String nome;

    @Column(name = "sigla_curso")
    private String sigla;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name ="professor_id", referencedColumnName = "id")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "curso_aluno", joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"))
    private List<Aluno> alunos = new ArrayList<>();

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private MaterialCurso materialCurso;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public MaterialCurso getMaterialCurso() {
        return materialCurso;
    }

    public void setMaterialCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }
}