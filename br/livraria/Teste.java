package br.livraria;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Nome 1");

        Pessoa reinan = new Pessoa(1, "Reinan");
        Pessoa gabriel = new Pessoa(2, "Gabriel");
        Pessoa joao = new Pessoa(3, "Joao");
        Pessoa maria = new Pessoa(4, "Maria");
        Pessoa paulo = new Pessoa(5, "Paulo");

        CadastroDePessoa cadastroDePessoa = new CadastroDePessoa();

        cadastroDePessoa.adicionarPessoa(gabriel);
        cadastroDePessoa.adicionarPessoa(reinan);

        boolean result = cadastroDePessoa.adicionarPessoa(null);


        System.out.println(result);

        System.out.println(cadastroDePessoa.toString());

        System.out.println(cadastroDePessoa.getPessoa().length);

        System.out.println(cadastroDePessoa.buscarPessoaPorNome("Reinan"));

        Filme eraDoGelo = new Filme(2, "Era do gelo", "x", "l");
        result = eraDoGelo.addAtores(reinan);
        eraDoGelo.addAtores(joao);
        eraDoGelo.addAtores(maria);
        eraDoGelo.addAtores(paulo);

        System.out.println(result);
        System.out.println(eraDoGelo.toString());

        System.out.println(eraDoGelo.temEssaPessoa(gabriel));

        Livro amor = new Livro(3, "Amor", reinan,"Brasil", 2019);

        CadastroDeProduto cadastroDeProduto = new CadastroDeProduto(3);

        result = cadastroDeProduto.adicionarProduto(amor);

        cadastroDeProduto.adicionarProduto(eraDoGelo);
        result = cadastroDeProduto.adicionarProduto(p1);

        System.out.println(cadastroDeProduto.buscarProdutoPorId(1));

        cadastroDeProduto.removerProduto(p1);
        cadastroDeProduto.removerProduto(eraDoGelo);
        cadastroDeProduto.removerProduto(amor);
        cadastroDeProduto.adicionarProduto(eraDoGelo);
        cadastroDeProduto.adicionarProduto(amor);

        System.out.println(Arrays.toString(cadastroDeProduto.listarProdutos()));
        System.out.println(Arrays.toString(cadastroDeProduto.listarProdutosDaPessoa(gabriel)));
        System.out.println(Arrays.toString(cadastroDeProduto.listarLivrosDoAutor(reinan)));
        System.out.println(Arrays.toString(cadastroDeProduto.listarLivrosDaEditorarNoPeriodo("Brasil", 2019, 2020)));
        System.out.println(Arrays.toString(cadastroDeProduto.listarFilmesDoAtorDaCategoriaDaClassificacao(reinan,"x","l")));


        System.out.println(Arrays.toString(cadastroDeProduto.getProduto()));
    }
}
