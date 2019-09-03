package Provas.MineProva;

import java.util.Arrays;

public class TesteFuncionamento {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 31/08/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    public static void main(String[] args) {
        Produto Cimento = new Produto("Cimento", "Cimento para uso geral", 21.90, "kgs");
        Produto Vedacit = new Produto("Vedacit", "Vedacit  para uso geral", 3.90, "litros");
        Produto Espuma = new Produto("Espuma", "Espuma para uso geral", 15.50, "ml");
        Produto Telha = new Produto("Telha", "Telha para uso geral", 58.00, "mm");

        Fornecedor telhaNorte = new Fornecedor("Telha Norte");
        telhaNorte.CadastrarProduto(Cimento);

        Fornecedor casaBoa = new Fornecedor("Casa boa");
        casaBoa.CadastrarProduto(Vedacit);
        casaBoa.CadastrarProduto(Cimento);

        Fornecedor minhaCaca = new Fornecedor("Minha Casa");
        casaBoa.CadastrarProduto(Espuma);
        casaBoa.CadastrarProduto(Telha);

        Cotacao cotacao1 = new Cotacao(Cimento, 28, "30/08/2019", "Reinan", telhaNorte, 21.90);
        Cotacao cotacao2 = new Cotacao(Vedacit, 14, "30/08/2019", "Gabriel", casaBoa, 3.90);
        Cotacao cotacao3 = new Cotacao(Cimento, 28, "30/08/2019", "Lucas", minhaCaca, 22.90);

        Orcamento orcamento = new Orcamento("Minha Casa", "Vai ser uma boa casa");
        orcamento.CadastrarCotacao(cotacao1);
        orcamento.CadastrarCotacao(cotacao2);
        orcamento.CadastrarCotacao(cotacao3);

        System.out.println(orcamento.ListarCotacaoes());
        System.out.println(Arrays.toString(orcamento.BuscarCotacaoPorFornecedor(telhaNorte)));
        System.out.println(orcamento.ObterCotacaoMenorValor());

        System.out.println("\n");

        System.out.println(orcamento.ListarCotacaoes(20.00, 30.00));
    }
}
