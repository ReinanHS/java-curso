package Provas.MineProva;

import javax.swing.*;

public class Main {
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

        int flag = 0;

        do{

            String mgs = "";
            mgs += "1 - Obter Cotação de Menor Valor\n";
            mgs += "2 - Buscar Cotação Por Fornecedor\n";
            mgs += "3 - Listar Cotaçãoes\n";
            mgs += "4 - Sair\n";

            flag = Integer.parseInt(JOptionPane.showInputDialog(mgs));

            switch (flag){
                case 1:{

                    Cotacao menor = orcamento.ObterCotacaoMenorValor();

                    mgs = "";
                    mgs += "ID: "+menor.getId()+"\n";
                    mgs += "Fornecedor: "+menor.getFornecedor().getNome()+"\n";
                    mgs += "Produto: "+menor.getProduto().getNome()+"\n";
                    mgs += "Valor Cotação: "+String.format("%.2f",menor.getValorCotacao())+"\n";
                    mgs += "Qtd Produtos: "+menor.getQtdProdutos()+"\n\n";

                    JOptionPane.showMessageDialog(null, mgs);
                    break;
                }
                case 2:{
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Fornecedor: \n"));
                    boolean achou = false;
                    mgs = "";

                    for (int i = 0; i < orcamento.getListaCotacoes().length ; i++) {
                        if(orcamento.getListaCotacoes()[i].getFornecedor().getId() == id){


                            mgs += "Nome Solicitante: "+orcamento.getListaCotacoes()[i].getNome_Solicitante()+"\n";
                            mgs += "Fornecedor: "+orcamento.getListaCotacoes()[i].getFornecedor().getNome()+"\n";
                            mgs += "Produto: "+orcamento.getListaCotacoes()[i].getProduto().getNome()+"\n";
                            mgs += "Valor Cotação: "+String.format("%.2f", orcamento.getListaCotacoes()[i].getValorCotacao())+"\n";
                            mgs += "Qtd Produtos: "+orcamento.getListaCotacoes()[i].getQtdProdutos()+"\n\n";

                            achou = true;
                        }
                    }

                    if(!achou){
                        JOptionPane.showMessageDialog(null, "Id não registrado!");
                    }else{
                        JOptionPane.showMessageDialog(null, mgs);
                    }

                    break;
                }
                case 3: {

                    //Double menor = Double.parseDouble(JOptionPane.showInputDialog("Digite o menor valor: \n"));
                    //Double maior = Double.parseDouble(JOptionPane.showInputDialog("Digite o maior valor: \n"));

                    JOptionPane.showMessageDialog(null, orcamento.ListarCotacaoes());
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(null, "Fim.");
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                    break;
                }
            }

        }while (flag != 4);
    }
}
