package demo;

import entities.Aluno;
import models.AlunoModel;

import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Aluno produtoModel = new Aluno();

        Aluno p1 = new Aluno();
        p1.setNomeCompleto("João Nascimento");
        p1.setMatricula("FF022539");
        p1.setEmail("joaovieirasilva@gmail.com");

        // 1) Criando um produto
        AlunoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Aluno> produtos = AlunoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());


    }
}
