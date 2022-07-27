package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class PessoaModel {

    // Instanciando o EntityManager com as configurações que estão no arquivo persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    // Instancia para manter a conexão com o banco de dados
    EntityManager em = emf.createEntityManager();

    public void create(Pessoa pessoa) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(pessoa);
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

    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public Pessoa delete(Pessoa pessoa) {
        em.remove(pessoa);
        System.out.println("Produto excluído com sucesso");
        return pessoa;
    }

    public Pessoa findById(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        //System.out.println(produto);
        return pessoa;
    }

    public List<Pessoa> findAll() {
        String jpql = "SELECT pes FROM Produto pes";
        return em.createQuery(jpql, Pessoa.class).getResultList();
    }
}

