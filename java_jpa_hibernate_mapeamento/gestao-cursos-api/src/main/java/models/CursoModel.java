package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {

    public void create(Curso curso){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a criação de um curso");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso!!");
        } catch (Exception e){
            em.close();
            System.out.println("Finalizando a transação " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("Iniciando a busca do curso de id " + id);
            Curso curso = em.find(Curso.class, id);
            System.out.println("Aluno de id " + id + " encontrado com sucesso!");
            return curso;
        } catch (Exception e){
            em.close();
            System.out.println("Erro ao buscar curso de id " + id + " " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public List<Curso> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a busca de todos os cursos");
            List<Curso> cursos = em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
            System.out.println("Cursos encontrados com sucesso!! " + cursos.get(0).getNome());
            return cursos;
        } catch (Exception e){
            System.out.println("Erro ao buscar cursos " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a atualização do curso");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso!!");
        } catch (Exception e){
            em.close();
            System.out.println("Erro ao atualizar curso " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public void delete(Curso curso){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a exclusão do curso");
            em.getTransaction().begin();
            curso = em.find(Curso.class, curso.getId());
            em.remove(curso);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Curso excluído com sucesso!!");
        } catch (Exception e){
            em.close();
            System.out.println("Erro ao excluir curso " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

}