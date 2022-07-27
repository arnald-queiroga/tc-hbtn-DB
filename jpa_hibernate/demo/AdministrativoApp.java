package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Produto p2 = new Produto();
        p1.setNome("X-Box One");
        p1.setPreco(3000.0);
        p1.setQuantidade(15);
        p1.setStatus(true);

        Produto p3 = new Produto();
        p1.setNome("Echo Dot (4ª Geração) - Alexia");
        p1.setPreco(379);
        p1.setQuantidade(10);
        p1.setStatus(true);

        Pessoa pes1 = new Pessoa();
        pes1.setNome("Alê Souza");
        pes1.setEmail("aleribeiro@gmail.com");
        pes1.setIdade(22);
        pes1.setCpf("11111111");



        // 1) Criando um produto
        produtoModel.create(p1);

        // Criando uma pessoa
        pessoaModel.create(pes1);


        //2) Buscando produto por Id
        Produto produtos = em.find(Produto.class, 2L);
        System.out.println("Nome do Pedido : " + produtos.getNome());

        //3) Removendo produto
        Produto p = em.find(Produto.class, 1L);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();


        // TODO - Testar os demais metódos das classes: ProdutoModel e PessoaModel

    }
}
