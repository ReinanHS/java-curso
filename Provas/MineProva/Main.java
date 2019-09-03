package Provas.MineProva;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
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

            String mgs = "Sistema de Orçamentos\n";
            mgs += "IFS - Prova de POO\n\n";

            mgs += "01 - Lista Produtos Cadastrados\n";
            mgs += "02 - Lista Fornecedores Cadastrados\n";
            mgs += "03 - Lista Cotações Cadastrados\n";
            mgs += "04 - Lista Orçamentos Cadastrados\n\n";
            mgs += "05 - Cadastrar Produtos\n";
            mgs += "06 - Cadastrar Fornecedores\n";
            mgs += "07 - Cadastrar Cotações\n";
            mgs += "08 - Cadastrar Orçamentos\n";

            mgs += "09 - Opções avançadas relacionadas ao orçamento\n\n";

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
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o Produto");
                        }
                        break;
                    }
                    case 6: {
                        if(!cadastrarFornecedor()){
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o Fornecedor");
                        }
                        break;
                    }
                    case 7: {
                        if(!cadastrarCotacao()){
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a Cotação");
                        }
                        break;
                    }
                    case 8: {
                        if(!cadastrarOrcamento()){
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o Orçacamento");
                        }
                        break;
                    }
                    case 9: {
                        String mgsOrcamento = "Opções avançadas para orçamento\n\n";

                        mgsOrcamento += "01 - Cadastrar Cotacao\n";
                        mgsOrcamento += "02 - Obter Cotação Menor Valor\n";
                        mgsOrcamento += "03 - Buscar Cotação Por Fornecedor\n";
                        mgsOrcamento += "04 - Listar Cotações\n\n";
                        mgsOrcamento += "05 - Voltar\n";

                        int ValorOpicao = 0;

                        do{
                            try{
                                ValorOpicao = Integer.parseInt(JOptionPane.showInputDialog(mgsOrcamento));


                                if(orcamentosIndex > 0){
                                    switch (ValorOpicao){
                                        case 1: {

                                            try {
                                                int indexOrcamento = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o index do orçamento: "));
                                                int idCotacao = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o ID da cotação que você vai cadastrar: "));

                                                for (int i = 0; i < cotacaoesIndex; i++) {
                                                    if(cotacaos[i].getId() == idCotacao){
                                                        if(orcamentos[indexOrcamento].CadastrarCotacao(cotacaos[i])){
                                                            JOptionPane.showMessageDialog(null, "Cotação cadastrada no Orçamento!");
                                                        }
                                                    }
                                                }
                                            }catch (NullPointerException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }catch (ArrayIndexOutOfBoundsException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }

                                            break;
                                        }
                                        case 2: {

                                            try {
                                                int indexOrcamento = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o index do orçamento: "));

                                                JOptionPane.showMessageDialog(null, "A cotação de menor valor é: \nNome Do solicitante: "+orcamentos[indexOrcamento].ObterCotacaoMenorValor().getNomeSolicitante()+"  ID: "+orcamentos[indexOrcamento].ObterCotacaoMenorValor().getId());

                                            }catch (NullPointerException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }catch (ArrayIndexOutOfBoundsException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }

                                            break;
                                        }
                                        case 3: {

                                            try {
                                                int indexOrcamento = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o index do orçamento: "));
                                                int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o ID do Fornecedor: "));

                                                for (int i = 0; i < fornecedoresIndex; i++) {
                                                    if(fornecedors[i].getId() == idFornecedor){

                                                        Cotacao Lista[] = orcamentos[indexOrcamento].BuscarCotacaoPorFornecedor( fornecedors[i] );

                                                        if(Lista != null){

                                                            String mgsCotacoes = "";

                                                            for (int j = 0; j < Lista.length; j++) {
                                                                mgsCotacoes += "Nome Solicitante: "+Lista[j].getNomeSolicitante()+" ID: "+Lista[j].getId()+"\n";
                                                            }

                                                            JOptionPane.showMessageDialog(null, mgsCotacoes);
                                                        }
                                                    }
                                                }

                                                JOptionPane.showMessageDialog(null, "A cotação de menor valor é: \nNome Do solicitante: "+orcamentos[indexOrcamento].ObterCotacaoMenorValor().getNomeSolicitante()+"  ID: "+orcamentos[indexOrcamento].ObterCotacaoMenorValor().getId());

                                            }catch (NullPointerException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }catch (ArrayIndexOutOfBoundsException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }

                                            break;
                                        }
                                        case 4: {

                                            try {
                                                int indexOrcamento = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o index do orçamento: "));
                                                double MairValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o maior valor: "));

                                                JOptionPane.showMessageDialog(null, orcamentos[indexOrcamento].ListarCotacaoes( MairValor ));


                                            }catch (NullPointerException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }catch (ArrayIndexOutOfBoundsException ex){
                                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cotação veja o index da cotação");
                                            }

                                            break;
                                        }
                                        case 5: {
                                            System.out.println("Voltar");
                                            break;
                                        }
                                        default:{
                                            JOptionPane.showMessageDialog(null, "Você digitou um valor inválido por favor digite novamente!");
                                            break;
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não foi cadastrado nenhuma orcamento então você não pode utilizar essa opição!");
                                }


                                break;

                            }catch (NumberFormatException ex){
                                ValorOpicao = 0;
                                JOptionPane.showMessageDialog(null, "Você digitou um valor inválido por favor digite novamente!");
                            }
                        }while (ValorOpicao != 5);

                        break;
                    }
                    case 10: {
                        JOptionPane.showMessageDialog(null, "Você ira fechar o programa");
                        break;
                    }
                    default:{
                        JOptionPane.showMessageDialog(null, "Você digitou um valor inválido por favor digite novamente!");
                    }
                }

            }catch (NumberFormatException ex){
                flag = 0;
                JOptionPane.showMessageDialog(null, "Você digitou um valor inválido por favor digite novamente!");
            }

        }while (flag != 10);
    }

    public static boolean cadastrarProduto(){

        try {
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Atenção você só poderá fechar essa tela ao completar o registro!\n\n Digite um ID para o produto: "));

            String Nome = JOptionPane.showInputDialog("ID: "+Id+"\nDigite um nome para o produto: ");
            Nome = Nome.length() > 0 ? Nome : "Não foi informado";

            String Descricao = JOptionPane.showInputDialog("ID: "+Id+"\nNome: "+Nome+"\nDigite uma descrição para o produto: ");
            Descricao = Descricao.length() > 0 ? Descricao : "Não foi informado";

            Double ValorUnitario = Double.parseDouble(JOptionPane.showInputDialog("ID: "+Id+"\nNome: "+Nome+"\nDescrição: "+Descricao+"\nDigite o valor do produto: "));

            String UnidadeMedida = JOptionPane.showInputDialog("ID: "+Id+"\nNome: "+Nome+"\nDescrição: "+Descricao+"\nValor: R$"+String.format("%.2f",ValorUnitario)+"\nDigite a unidade de medida para o produto: ");
            UnidadeMedida = UnidadeMedida.length() > 0 ? UnidadeMedida : "UND";

            if(produtosIndex < 50){

                Produto meuProduto = new Produto(Id, Nome, Descricao, ValorUnitario, UnidadeMedida);

                produtos[produtosIndex] = meuProduto;

                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso no index "+produtosIndex);

                produtosIndex++;

                return true;
            }else return false;

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Você digitou uma String no lugar de um número ou\n tentou fechar o programa sem completar o registro por favor tente novamente!");
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
                int Id = Integer.parseInt(JOptionPane.showInputDialog("Atenção você só poderá fechar essa tela ao completar o registro!\n\n Digite um ID para o Fornecedor: "));

                String Nome = JOptionPane.showInputDialog("ID: "+Id+"\nDigite um nome para o fornecedor: ");
                Nome = Nome.length() > 0 ? Nome : "Não foi informado";

                Fornecedor meuFornecedor = new Fornecedor(Id, Nome);

                int qtdProdutos = Integer.parseInt(JOptionPane.showInputDialog("ID: "+Id+"\nO menor valor será  1 é o maior valor "+produtosIndex+"\nDigite a quantidade de produtos que você deseja cadastrar: "));

                if(qtdProdutos > 0 && qtdProdutos <= produtosIndex){

                    boolean cadastrouPeloProduto = false;
                    int ultimoId = 0;

                    String mgsListaDeProdutos = "Lista De Todos os produtos oferecidos: \n\n";

                    for (int j = 0; j < produtosIndex; j++) {
                        mgsListaDeProdutos += "Nome Do Produto: "+produtos[j].getNome()+"   ID: "+produtos[j].getId()+"\n";
                    }

                    mgsListaDeProdutos += "\n\nDigite aqui o Id do produto que você deseja cadastrar no fornecedor "+Nome+":";

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
                                }else if(produtos[i].getId() != ultimoId) JOptionPane.showMessageDialog(null, "Produto já cadastrado");
                            }
                        }

                        if(!achouProdutoPeloId){
                            JOptionPane.showMessageDialog(null, "Produto não encontrado pelo Id que você digitou.\nTalvez você não tenha cadastrado esse produto\n");
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

                    JOptionPane.showMessageDialog(null, "Você não cadastrou nenhum produto então terá que fazer todo o procedimento novamente");
                    return cadastrarFornecedor();

                }else{
                    JOptionPane.showMessageDialog(null, "Você digitou valores inválidos para a quantidade de produtos por favor tente novamente!");
                    return cadastrarFornecedor();
                }

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Você digitou uma String no lugar de um número ou\n tentou fechar o programa sem completar o registro por favor tente novamente!");
                return cadastrarFornecedor();
            }
        }else{

            JOptionPane.showMessageDialog(null, "Você não pode cadastrar um Fornecedor agora porque nenhum produto foi cadastrado no momento");

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
                int Id = Integer.parseInt(JOptionPane.showInputDialog("Atenção você só poderá fechar essa tela ao completar o registro!\n\n Digite um ID para o Fornecedor: "));

                int qtdProdutos = Integer.parseInt(JOptionPane.showInputDialog("ID: "+Id+"\nDigite a quantidade de produtos que você tem no estoque: "));
                qtdProdutos = qtdProdutos < 0 ? 0 : qtdProdutos;

                String DataSolicitacao = JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nDigite a data de solicitação: ");

                Date dataAtual = new Date();
                DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

                DataSolicitacao = DataSolicitacao.length() < 9 ? dataFormatada.format(dataAtual) : DataSolicitacao;

                String NomeSolicitante = JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nData: "+DataSolicitacao+"\nDigite o nome do solicitante: ");
                NomeSolicitante = NomeSolicitante.length() > 0 ? NomeSolicitante : "Usuário Anônimo";

                double ValorCotacao = Double.parseDouble(JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nData: "+DataSolicitacao+"\nNome Do Solicitante: "+NomeSolicitante+"\nDigite um valor para a cotação: "));
                ValorCotacao = ValorCotacao < 0 ? 0.0 : ValorCotacao;

                boolean achouID = false;

                do{

                    String mgsListaDosFornecedor = "Lista De Todos os fornecedores: \n\n";

                    for (int i = 0; i < fornecedoresIndex; i++) {
                        mgsListaDosFornecedor += "Nome Do Fornecedor: "+fornecedors[i].getId()+"   ID: "+fornecedors[i].getId()+"\n";
                    }

                    int IdFornecedor = Integer.parseInt(JOptionPane.showInputDialog("ID: "+Id+"\nQuantidade: "+qtdProdutos+"\nData: "+DataSolicitacao+"\nNome Do Solicitante: "+NomeSolicitante+"Valor Da Cotação: R$"+String.format("%.2f", ValorCotacao)+"\n"+mgsListaDosFornecedor+"\nDigite o ID de um Fornecedor: "));

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

                                                    JOptionPane.showMessageDialog(null, "Cotação cadastradoda com sucesso no index "+cotacaoesIndex);

                                                    cotacaoesIndex++;
                                                    return true;
                                                }else return false;
                                            }
                                        }
                                    }

                                    if(!achou){
                                        JOptionPane.showMessageDialog(null, "O Id que você digitou para o Produto é inválido");
                                        return false;
                                    }

                                }catch (NullPointerException ex){
                                    System.out.println("ID inválido");
                                }
                            }while (!cotacaoCadastrou);

                            break;
                        }
                    }

                }while (achouID);


                return false;

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Você digitou uma String no lugar de um número ou\n tentou fechar o programa sem completar o registro por favor tente novamente!");
                return cadastrarFornecedor();
            }
        }else{

            JOptionPane.showMessageDialog(null, "Você não pode cadastrar uma cotação agora porque nenhum produto ou fornecedores foram cadastrado no momento");

            return false;
        }
    }

    public static String listaCotacaoCadastradas(){
        if(cotacaoesIndex > 0){

            String listaDeCotacoes = "Listagem de Todos as Cotações Cadastrados\n\n";

            for (int i = 0; i < cotacaoesIndex; i++) {
                listaDeCotacoes += "Nome Do Solicitante: "+cotacaos[i].getNomeSolicitante()+"   Data: "+cotacaos[i].getDataSolicitacao() +"   ID: "+cotacaos[i].getId()+"\n";
            }

            return listaDeCotacoes;
        }else return "No momento nenhuma cotação foi cadastrado";
    }

    public static boolean cadastrarOrcamento(){
        if(cotacaoesIndex > 0){
            String Nome = JOptionPane.showInputDialog("Digite um nome para o seu orçamento: ");
            Nome = Nome.length() > 0 ? Nome : "Não foi informado";

            String Descricao = JOptionPane.showInputDialog("Nome: "+Nome+"\nDigite uma descrição para o orçamento: ");
            Descricao = Descricao.length() > 0 ? Descricao : "Não foi informado";

            if(orcamentosIndex < 50){

                Orcamento meuOrcamento = new Orcamento(Nome, Descricao);

                orcamentos[orcamentosIndex] = meuOrcamento;

                JOptionPane.showMessageDialog(null, "Orçamento cadastrado com sucesso no index "+orcamentosIndex);

                orcamentosIndex++;

                return true;
            }else return false;
        }

        JOptionPane.showMessageDialog(null, "Você não pode cadastrar um orçamento porque não tem nenhuma cotação cadastrada!");

        return false;
    }

    public static String listaOrcamentosCadastradas(){
        if(orcamentosIndex > 0){

            String listaDeOrcamentos = "Listagem de Todos os Orçamentos Cadastrados\n\n";

            for (int i = 0; i < orcamentosIndex; i++) {
        listaDeOrcamentos += "Nome Do Orcamento: "+orcamentos[i].getNomeObra()+"   Descrição: "+orcamentos[i].getDescricaoReforma()+"  ID:  "+i+"\n";
            }

            return listaDeOrcamentos;
        }else return "No momento nenhum orçamento foi cadastrado";
    }
}
