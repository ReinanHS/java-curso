package Aulas.Inteface;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {

        Produto produto1 = new Produto(1, "Casa");
        Produto produto2 = new Produto(6, "Bola");
        Produto produto3 = new Produto(3, "Carro");
        Produto produto4 = new Produto(4, "Notebook");
        Produto produto5 = new Produto(5, "PC");
        Produto produto6 = new Produto(2, "TV");

        RepositorioDeProduto repositorioDeProduto = new RepositorioDeProduto(3);

        boolean log = repositorioDeProduto.inserir(produto1);
        System.out.println("Resultado do cadastro 1: "+log);

        log = repositorioDeProduto.inserir(produto2);
        System.out.println("Resultado do cadastro 2: "+log);

        log = repositorioDeProduto.inserir(produto3);
        System.out.println("Resultado do cadastro 3: "+log);

        log = repositorioDeProduto.inserir(produto4);
        System.out.println("Resultado do cadastro 4: "+log);


        Object obj = repositorioDeProduto.remover(1);
        System.out.println("Resultado do remover 1: "+obj);

        obj = repositorioDeProduto.remover(6);
        System.out.println("Resultado do remover 1: "+obj);

        obj = repositorioDeProduto.remover(2);
        System.out.println("Resultado do remover 1: "+obj);

        obj = repositorioDeProduto.remover(3);
        System.out.println("Resultado do remover 1: "+obj);

        obj = repositorioDeProduto.remover(5);
        System.out.println("Resultado do remover 1: "+obj);

        System.out.println(Arrays.toString(repositorioDeProduto.listar()));

        log = repositorioDeProduto.inserir(produto4);
        System.out.println("Resultado do cadastro 4: "+log);

        log = repositorioDeProduto.inserir(produto5);
        System.out.println("Resultado do cadastro 5: "+log);

        log = repositorioDeProduto.inserir(produto6);
        System.out.println("Resultado do cadastro 6: "+log);

        System.out.println(Arrays.toString(repositorioDeProduto.listar()));

        System.out.println("Resultado da busca pelo ID 1: "+repositorioDeProduto.buscar(1));
        System.out.println("Resultado da busca pelo ID 5: "+repositorioDeProduto.buscar(5));
        System.out.println("Resultado da busca pelo ID 2: "+repositorioDeProduto.buscar(2));
    }
}
