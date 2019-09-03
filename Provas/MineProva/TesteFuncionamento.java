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
        Produto Cimento2 = new Produto("Cimento Top", "Cimento para uso geral", 25.00, "kgs");
        Produto Cimento3 = new Produto("Cimento Agora vai", "Cimento para uso geral", 21.99, "kgs");

        Produto Vedacit = new Produto("Vedacit", "Vedacit  para uso geral", 3.90, "litros");
        Produto Vedacit2 = new Produto("Vedacit Sol", "Vedacit  para uso geral", 3.95, "litros");
        Produto Vedacit3 = new Produto("Vedacit Brasil", "Vedacit  para uso geral", 3.75, "litros");

        Produto Espuma = new Produto("Espuma", "Espuma para uso geral", 15.50, "ml");
        Produto Espuma2 = new Produto("Espuma Do Bar", "Espuma para uso geral", 17.25, "ml");

        Produto Telha = new Produto("Telha", "Telha para uso geral", 58.00, "mm");

        Fornecedor telhaNorte = new Fornecedor("Telha Norte");
        telhaNorte.CadastrarProduto(Cimento);
        telhaNorte.CadastrarProduto(Vedacit);
        telhaNorte.CadastrarProduto(Telha);

        Fornecedor casaBoa = new Fornecedor("Casa boa");
        casaBoa.CadastrarProduto(Vedacit);
        casaBoa.CadastrarProduto(Vedacit2);
        casaBoa.CadastrarProduto(Cimento2);
        casaBoa.CadastrarProduto(Telha);

        Fornecedor minhaCaca = new Fornecedor("Minha Casa");
        minhaCaca.CadastrarProduto(Espuma2);
        minhaCaca.CadastrarProduto(Vedacit3);
        minhaCaca.CadastrarProduto(Cimento3);
        minhaCaca.CadastrarProduto(Telha);

        Cotacao cotacao1 = new Cotacao(Cimento, 28, "30/08/2019", "Reinan", telhaNorte, (Cimento.getValorUnitario() * 28) );
        Cotacao cotacao2 = new Cotacao(Vedacit, 14, "30/08/2019", "Gabriel", casaBoa, ( Vedacit.getValorUnitario() * 14) );
        Cotacao cotacao3 = new Cotacao(Cimento3, 28, "30/08/2019", "Lucas", minhaCaca, (Cimento3.getValorUnitario() * 28));
        Cotacao cotacao4 = new Cotacao(Vedacit3, 28, "30/08/2019", "Bruno", minhaCaca, (Vedacit3.getValorUnitario() * 28));
        Cotacao cotacao5 = new Cotacao(Telha, 28, "30/08/2019", "Maria", minhaCaca, (Telha.getValorUnitario() * 28));
        Cotacao cotacao6 = new Cotacao(Cimento2, 28, "30/08/2019", "Davi", casaBoa, (Cimento2.getValorUnitario() * 28));
        Cotacao cotacao7 = new Cotacao(Cimento3, 28, "30/08/2019", "Luiz", casaBoa, (Cimento3.getValorUnitario() * 28));

        Orcamento orcamento = new Orcamento("Minha Casa", "Vai ser uma boa casa");
        orcamento.CadastrarCotacao(cotacao1);
        orcamento.CadastrarCotacao(cotacao2);
        orcamento.CadastrarCotacao(cotacao3);
        orcamento.CadastrarCotacao(cotacao4);
        orcamento.CadastrarCotacao(cotacao5);
        orcamento.CadastrarCotacao(cotacao6);
        orcamento.CadastrarCotacao(cotacao7);

        System.out.println(orcamento.ListarCotacaoes());
        System.out.println(Arrays.toString(orcamento.BuscarCotacaoPorFornecedor(telhaNorte)));
        System.out.println(orcamento.ObterCotacaoMenorValor());

        System.out.println("\n");

        System.out.println(orcamento.ListarCotacaoes(20.00, 30.00));
    }
}
