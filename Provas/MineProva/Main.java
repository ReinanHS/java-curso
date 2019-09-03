package Provas.MineProva;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 31/08/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */
    private static final int LIMIT_DADOS = 50;

    public static Produto produtos[] = new Produto[LIMIT_DADOS];
    public static int produtosIndex = 0;

    public static Fornecedor fornecedors[] = new Fornecedor[LIMIT_DADOS];
    public static int fornecedoresIndex = 0;

    public static Cotacao cotacaos[] = new Cotacao[LIMIT_DADOS];
    public static int cotacaoesIndex = 0;

    public static Orcamento orcamentos[] = new Orcamento[LIMIT_DADOS];
    public static int orcamentosIndex = 0;

    public static void main(String[] args) {
        int flag = 0;

        do{

            String mgs = "Sistema de Or�amentos\n";
            mgs += "IFS - Prova de POO\n\n";

            mgs += "01 - Lista Produtos Cadastrados\n";
            mgs += "02 - Lista Fornecedores Cadastrados\n";
            mgs += "03 - Lista Cota��es Cadastrados\n";
            mgs += "04 - Lista Or�amentos Cadastrados\n\n";
            mgs += "05 - Cadastrar Produtos\n";
            mgs += "06 - Cadastrar Fornecedores\n";
            mgs += "07 - Cadastrar Cota��es\n";
            mgs += "08 - Cadastrar Or�amentos\n";

            mgs += "19 - Op��es avan�adas relacionadas ao or�amento\n\n";

            mgs += "10 - Sair\n\n";

            try{
                flag = Integer.parseInt(JOptionPane.showInputDialog(mgs));

                switch (flag){
                    case 1: {
                        JOptionPane.showMessageDialog(null, listaProdutosCadastrados());
                        break;
                    }
                    case 2: {
                        JOptionPane.showMessageDialog(null, listaFornecedoresCadastrados());
                        break;
                    }
                    case 3:{
                        JOptionPane.showMessageDialog(null, listaCotacaoCadastradas());
                        break;
                    }
                    case 4:{
                        JOptionPane.showMessageDialog(null, listaOrcamentosCadastradas());
                        break;
                    }
                    case 5: {
                        if(!cadastrarProduto()){
                            JOptionPane.showMessageDialog(null, "N�o foi possivel cadastrar o Produto");
                        }
                        break;
                    }
                    case 6: {
                        if(!cadastrarFornecedor()){
                            JOptionPane.showMessageDialog(null, "N�o foi possivel cadastrar o Fornecedor");
                        }
                        break;
                    }
                    case 7: {
                        if(!cadastrarCotacao()){
                            JOptionPane.showMessageDialog(null, "N�o foi possivel cadastrar a Cota��o");
                        }
                        break;
                    }
                    case 8: {
                        if(!cadastrarOrcamento()){
                            JOptionPane.showMessageDialog(null, "N�o foi possivel cadastrar o Or�acamento");
                        }
                        break;
                    }
                    case 9: {
                        String mgsOrcamento = "Op��es avan�adas para or�amento\n\n";

                        mgsOrcamento += "01"

                        break;
                    }
                    case 10: {
                        JOptionPane.showMessageDialog(null, "Voc� ira fechar o programa");
                        break;
                    }
                    default:{
                        JOptionPane.showMessageDialog(null, "Voc� digitou um valor inv�lido por favor digite novamente!");
                    }
                }

            }catch (NumberFormatException ex){
                flag = 0;
                JOptionPane.showMessageDialog(null, "Voc� digitou um valor inv�lido por favor digite novamente!");
            }

        }while (flag != 10);
    }

    public static boolean cadastrarProduto(){

        try {
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Aten��o voc� s� poder� fechar essa tela ao completar o registro!\n\n Digite um ID para o produto: "));

            String Nome = JOptionPane.showInputDialog("ID: "+Id+"\nDigite um nome para o produto: ");
            Nome = Nome.length() > 0 ? Nome : "N�o foi informado";

            String Descricao = JOptionPane.showInputDialog("ID: "+Id+"\nNome: "+Nome+"\nDigite uma descri��o para o produto: ");
            Descricao = Descricao.length() > 0 ? Descricao : "N�o foi informado";

            Double ValorUnitario = Double.parseDouble(JOptionPane.showInputDialog("ID: "+Id+"\nNome: "+Nome+"\nDescri��o: "+Descricao+"\nDigite o valor do produto: "));

            String UnidadeMedida = JOptionPane.showInputDialog("ID: "+Id+"\nNome: "+Nome+"\nDescri��o: "+Descricao+"\nValor: R$"+String.format("%.2f",ValorUnitario)+"\nDigite a unidade de medida para o produto: ");
            UnidadeMedida = UnidadeMedida.length() > 0 ? UnidadeMedida : "UND";

            if(produtosIndex < 50){

                Produto meuProduto = new Produto(Id, Nome, Descricao, ValorUnitario, UnidadeMedida);

                produtos[produtosIndex] = meuProduto;

                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso no index "+produtosIndex);

                produtosIndex++;

                return true;
            }else return false;

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Voc� digitou uma String no lugar de um n�mero ou\n tentou fechar o programa sem completar o registro por favor tente novamente!");
            return cadastrarProduto();
        }
    }

    public static String listaProdutosCadastrados(){
        if(produtosIndex > 0){

            String listaDeProdutos = "Listagem de Todos os Produtos Cadastrados\n\n";

            for (int i = 0; i < produtosIndex; i++) {
                listaDeProdutos += "Nome Do Produto: "+produtos[i].getNome()+"   Valor: "+String.format("%.2f", produtos[i].getValorUnitario())+"   ID: "+produtos[i].getId()+"\n";
            }

            return listaDeProdutos;
        }else return "No momento nenhum produto foi cadastrado";
    }

    public static boolean cadastrarFornecedor(){
        if(produtosIndex > 0){
            try {
                int Id = Integer.parseInt(JOptionPane.showInputDialog("Aten��o voc� s� poder� fechar essa tela ao completar o registro!\n\n Digite um ID para o Fornecedor: "));

                String Nome = JOptionPane.showInputDialog("ID: "+Id+"\nDigite um nome para o fornecedor: ");
                Nome = Nome.length() > 0 ? Nome : "N�o foi informado";

                Fornecedor meuFornecedor = new Fornecedor(Id, Nome);

                int qtdProdutos = Integer.parseInt(JOptionPane.showInputDialog("ID: "+Id+"\nO menor valor ser�  1 � o maior valor "+produtosIndex+"\nDigite a quantidade de produtos que voc� deseja cadastrar: "));

                if(qtdProdutos > 0 && qtdProdutos <= produtosIndex){

                    boolean cadastrouPeloProduto = false;
                    int ultimoId = 0;

                    String mgsListaDeProdutos = "Lista De Todos os produtos oferecidos: \n\n";

                    for (int j = 0; j < produtosIndex; j++) {
                        mgsListaDeProdutos += "Nome Do Produto: "+produtos[j].getNome()+"   ID: "+produtos[j].getId()+"\n";
                    }

                    mgsListaDeProdutos += "\n\nDigite aqui o Id do produto que voc� deseja cadastrar no fornecedor "+Nome+":";

                    for (int i = 0; i < qtdProdutos; i++) {
                        int idProduto = Integer.parseInt(JOptionPane.showInputDialog(mgsListaDeProdutos));
                        boolean achouProdutoPeloId = false;
                        for (int j = 0; j < qtdProdutos; j++) {
                            if(produtos[i].getId() == idProduto){
                                achouProdutoPeloId = true;
                                if(meuFornecedor.CadastrarProduto(produtos[i])){
                                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                                    cadastrouPeloProduto = true;
                                    ultimoId = idProduto;
                                }else if(produtos[i].getId() != ultimoId) JOptionPane.showMessageDialog(null, "Produto j� cadastrado");
                            }
                        }

                        if(!achouProdutoPeloId){
                            JOptionPane.showMessageDialog(null, "Produto n�o encontrado pelo Id que voc� digitou.\nTalvez voc� n�o tenha cadastrado esse produto\n");
                        }
                    }

                    if(cadastrouPeloProduto){
                        if(fornecedoresIndex < 50){
                            fornecedors[fornecedoresIndex] = meuFornecedor;

                            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso no index "+fornecedoresIndex);

                            fornecedoresIndex++;
                            return true;
                        }else return false;
                    }

                    JOptionPane.showMessageDialog(null, "Voc� n�o cadastrou nenhum produto ent�o ter� que fazer todo o procedimento novamente");
                    return cadastrarFornecedor();

                }else{
                    JOptionPane.showMessageDialog(null, "Voc� digitou valores inv�lidos para a quantidade de produtos por favor tente novamente!");
                    return cadastrarFornecedor();
                }

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Voc� digitou uma String no lugar de um n�mero ou\n tentou fechar o programa sem completar o registro por favor tente novamente!");
                return cadastrarFornecedor();
            }
        }else{

            JOptionPane.showMessageDialog(null, "Voc� n�o pode cadastrar um Fornecedor agora porque nenhum produto foi cadastrado no momento");

            return false;
        }
    }

    public static String listaFornecedoresCadastrados(){
        if(fornecedoresIndex > 0){

            String listaDeFornecedores = "Listagem de Todos os Fornecedores Cadastrados\n\n";

            for (int i = 0; i < fornecedoresIndex; i++) {
                listaDeFornecedores += "Nome Do Fornecedor: "+fornecedors[i].getNome()+"   Produtos: "+fornecedors[i].getProdutos()[0].getNome()+"...   ID: "+fornecedors[i].getId()+"\n";
            }

            return listaDeFornecedores;
        }else return "No momento nenhum fornecedor foi cadastrado";
    }

    public static boolean cadastrarCotacao(){
        if(produtosIndex > 0 && fornecedoresIndex > 0){
            try {
                int Id = Integer.parseInt(JOptionPane.showInputDialog("Aten��o voc� s� poder� fechar essa tela ao completar o registro!\n\n Digite um ID para o Fornecedor: "));

                int qtdProdutos = Integer.parseInt(JOptionPane.showInputDialog("ID: "+Id+"\nDigite a quantidade de produtos que voc� tem no estoque: "));
                qtdProdutos = qtdProdutos < 0 ? 0 : qtdProdutos;

                String DataSolicitacao = JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nDigite a data de solicita��o: ");

                Date dataAtual = new Date();
                DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

                DataSolicitacao = DataSolicitacao.length() < 9 ? dataFormatada.format(dataAtual) : DataSolicitacao;

                String NomeSolicitante = JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nData: "+DataSolicitacao+"\nDigite o nome do solicitante: ");
                NomeSolicitante = NomeSolicitante.length() > 0 ? NomeSolicitante : "Usu�rio An�nimo";

                double ValorCotacao = Double.parseDouble(JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nData: "+DataSolicitacao+"\nNome Do Solicitante: "+NomeSolicitante+"\nDigite um valor para a cota��o: "));
                ValorCotacao = ValorCotacao < 0 ? 0.0 : ValorCotacao;

                boolean achouID = false;

                do{

                    String mgsListaDosFornecedor = "Lista De Todos os fornecedores: \n\n";

                    for (int i = 0; i < fornecedoresIndex; i++) {
                        mgsListaDosFornecedor += "Nome Do Fornecedor: "+fornecedors[i].getId()+"   ID: "+fornecedors[i].getId()+"\n";
                    }

                    int IdFornecedor = Integer.parseInt(JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nData: "+DataSolicitacao+"\nNome Do Solicitante: "+NomeSolicitante+"Valor Da Cota��o: R$"+String.format("%.2f", ValorCotacao)+"\n"+mgsListaDosFornecedor+"\nDigite o ID de um Fornecedor: "));

                    for (int i = 0; i < fornecedoresIndex; i++) {
                        if(fornecedors[i].getId() == IdFornecedor){
                            achouID = true;

                            boolean cotacaoCadastrou = false;

                            do {
                                // Listagem De Produtos
                                String mgsListaDeProdutosPeloFornecedor = "Lista De Todos os produtos oferecidos por esse fornecedor: \n\n";

                                for (int j = 0; j < fornecedors[i].getProdutos().length; j++) {
                                    mgsListaDeProdutosPeloFornecedor += "Nome Do Produto: "+fornecedors[i].getProdutos()[j].getNome()+"   ID: "+fornecedors[i].getProdutos()[j].getId()+"\n";
                                }

                                mgsListaDeProdutosPeloFornecedor += "\n\nDigite um dos itens listados acima: ";
                                // Fim Da Listagem

                                int idProduto = Integer.parseInt(JOptionPane.showInputDialog(mgsListaDeProdutosPeloFornecedor));

                                Cotacao minhaCotacao = new Cotacao(Id, qtdProdutos, DataSolicitacao, NomeSolicitante, ValorCotacao);
                                try {

                                    // For para pegar o Index do Produto
                                    boolean achou = false;
                                    for (int j = 0; j < produtosIndex; j++) {
                                        if(produtos[j].getId() == idProduto){
                                            achou = true;
                                            cotacaoCadastrou = minhaCotacao.CadastrarFornecedor(fornecedors[i], produtos[j]);

                                            if(cotacaoCadastrou){
                                                if(cotacaoesIndex < 50){
                                                    cotacaos[cotacaoesIndex] = minhaCotacao;

                                                    JOptionPane.showMessageDialog(null, "Cota��o cadastradoda com sucesso no index "+cotacaoesIndex);

                                                    cotacaoesIndex++;
                                                    return true;
                                                }else return false;
                                            }
                                        }
                                    }

                                    if(!achou){
                                        JOptionPane.showMessageDialog(null, "O Id que voc� digitou para o Produto � inv�lido");
                                        return false;
                                    }

                                }catch (NullPointerException ex){
                                    System.out.println("ID inv�lido");
                                }
                            }while (!cotacaoCadastrou);

                            break;
                        }
                    }

                }while (achouID);


                return false;

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Voc� digitou uma String no lugar de um n�mero ou\n tentou fechar o programa sem completar o registro por favor tente novamente!");
                return cadastrarFornecedor();
            }
        }else{

            JOptionPane.showMessageDialog(null, "Voc� n�o pode cadastrar uma cota��o agora porque nenhum produto ou fornecedores foram cadastrado no momento");

            return false;
        }
    }

    public static String listaCotacaoCadastradas(){
        if(cotacaoesIndex > 0){

            String listaDeCotacoes = "Listagem de Todos as Cota��es Cadastrados\n\n";

            for (int i = 0; i < cotacaoesIndex; i++) {
                listaDeCotacoes += "Nome Do Solicitante: "+cotacaos[i].getNomeSolicitante()+"   Data: "+cotacaos[i].getDataSolicitacao() +"   ID: "+cotacaos[i].getId()+"\n";
            }

            return listaDeCotacoes;
        }else return "No momento nenhuma cota��o foi cadastrado";
    }

    public static boolean cadastrarOrcamento(){
        if(cotacaoesIndex > 0){
            String Nome = JOptionPane.showInputDialog("Digite um nome para o seu or�amento: ");
            Nome = Nome.length() > 0 ? Nome : "N�o foi informado";

            String Descricao = JOptionPane.showInputDialog("Nome: "+Nome+"\nDigite uma descri��o para o or�amento: ");
            Descricao = Descricao.length() > 0 ? Descricao : "N�o foi informado";

            if(orcamentosIndex < 50){

                Orcamento meuOrcamento = new Orcamento(Nome, Descricao);

                orcamentos[orcamentosIndex] = meuOrcamento;

                JOptionPane.showMessageDialog(null, "Or�amento cadastrado com sucesso no index "+orcamentosIndex);

                orcamentosIndex++;

                return true;
            }else return false;
        }

        JOptionPane.showMessageDialog(null, "Voc� n�o pode cadastrar um or�amento porque n�o tem nenhuma cota��o cadastrada!");

        return false;
    }

    public static String listaOrcamentosCadastradas(){
        if(orcamentosIndex > 0){

            String listaDeOrcamentos = "Listagem de Todos os Or�amentos Cadastrados\n\n";

            for (int i = 0; i < orcamentosIndex; i++) {
        listaDeOrcamentos += "Nome Do Orcamento: "+orcamentos[i].getNomeObra()+"   Descri��o: "+orcamentos[i].getDescricaoReforma()+"  ID:  "+i+"\n";
            }

            return listaDeOrcamentos;
        }else return "No momento nenhum or�amento foi cadastrado";
    }
}
