package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a criação do aluno...");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("Iniciando a busca do ALuno de id: " + id);
            Aluno aluno = em.find(Aluno.class, id);
            System.out.println("Aluno de id: " + id + " encontrado com sucesso!");
            return aluno;
        } catch (Exception e){
            System.out.println("Erro ao buscar pessoa de id " + id + " " + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("Iniciando a busca de todos os alunos");
            List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
            System.out.println("Alunos encontrados com sucesso: " + alunos.size());
            return alunos;
        } catch (Exception e){
            System.out.println("Erro ao buscar todas as pessoas " + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a atulição do aluno de id " + aluno.getId());
            em.getTransaction().begin();
            aluno = em.find(Aluno.class, aluno.getId());
            System.out.println("Aluno econtrado com sucesso");
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno de id " + aluno.getId() + " atualizado com sucesso!");
        } catch (Exception e){
            System.out.println("Erro ao atualizar aluno de id " + aluno.getId() + " " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("Removendo aluno de id " + aluno.getId());
            em.getTransaction().begin();
            aluno = em.find(Aluno.class, aluno.getId());
            em.remove(aluno);
            em.flush();
            System.out.println("Aluno de id " + aluno.getId() + " excluído com sucesso!");
        } catch (Exception e){
            em.close();
            System.out.println("Erro ao excluir aluno de id " + aluno.getId() + " " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }
}