package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class ProdutoModel {

    // Instanciando o EntityManager com as configurações que estão no arquivo persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    // Instancia para manter a conexão com o banco de dados
    EntityManager em = emf.createEntityManager();

    public void create(Produto p) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit(); // Confirmando as alterações feitas
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        em.merge(p);
    }

    public Produto delete(Produto p) {
        em.remove(p);
        System.out.println("Produto excluído com sucesso");
        return p;
    }

    public Produto findById(Long id) {
        Produto produto = em.find(Produto.class, id);
        //System.out.println(produto);
        return produto;
    }

    public List<Produto> findAll() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
}

