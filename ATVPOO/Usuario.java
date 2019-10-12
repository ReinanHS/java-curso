package CadastroEventos;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Usuario {

    public static GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos();

    public static void main(String[] args) {
        SistemaInteracao.Interface = tipoMenu();
        menu();
    }

    public static Class tipoMenu(){

        int tipo = 0;

        do{
            tipo = SistemaInteracao.TipoInterface("\n Tipos de Interface: \n\n 1 - CMD\n 2 - Interface\n\n");
        }while (tipo < 0 && tipo > 2);

        switch (tipo){
            case 2: {
                return JOptionPane.class;
            }
            default: {
                return Scanner.class;
            }
        }
    }

    public static void menu(){
        String msg = "";
        msg += "---- Escolha o Menu ----\n";
        msg += "1 - Participante\n";
        msg += "2 - Eventos\n";
        msg += "3 - Recursos\n";
        msg += ""
        		+ "4 - Sair\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.TipoInterface(msg);
        }while (flag < 1 && flag >= 4);

        switch (flag){
            case 1: {
                menuParticipante();
                break;
            }
            case 2: {
                menuEvento();
                break;
            }
            case 3: {
                menuRecursos();
                break;
            }
        }
    }

    public static void menuParticipante(){
        String msg = "";
        msg += "--- Menu de Participantes ---\n";
        msg += "1 - Listar Participantes\n";
        msg += "2 - Cadastrar Participante\n";
        msg += "3 - Cadastrar Aluno\n";
        msg += "4 - Cadastrar Professor\n";
        msg += "5 - Remover um Participante\n";
        msg += "6 - Voltar\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.TipoInterface(msg);
        }while (flag < 1 && flag >= 6);

        switch (flag){
            case 1: {
                SistemaInteracao.showMessage(gerenciadorDeEventos.listarParticipantesToString());
                menuParticipante();
                break;
            }
            case 2: {
                gerenciadorDeEventos.cadastroDePartipantes(SistemaInteracao.criarParticipante());
                menuParticipante();
                break;
            }
            case 3: {
                gerenciadorDeEventos.cadastroDePartipantes(SistemaInteracao.criarAlunos());
                menuParticipante();
                break;
            }
            case 4: {
                gerenciadorDeEventos.cadastroDePartipantes(SistemaInteracao.criarProfessor());
                menuParticipante();
                break;
            }
            case 5: {
                String matricula = SistemaInteracao.pegarInterface("Matricula: ");
                try{
                    for(Participantes x : gerenciadorDeEventos.getParticipantes()){
                        if(x.getMatricula().equals(matricula)){
                            gerenciadorDeEventos.removerParticipante(x);
                            menuParticipante();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não exitem participantes cadastrados");
                }
                SistemaInteracao.showMessage("Não foi encontrado nenhum participante com esta matrícula");
                menuParticipante();
                break;
            }
            case 6: {
                menu();
                break;
            }
            default: {
                menuParticipante();
            }
        }
    }

    public static void menuEvento(){
        String msg = "";
        msg += "--- Menu de Eventos ---\n";
        msg += "1 - Listar Eventos\n";
        msg += "2 - Cadastrar Evento\n";
        msg += "3 - Cadastrar Palestra\n";
        msg += "4 - Cadastrar Mini Curso\n";
        msg += "5 - Remover um Evento\n";
        msg += "6 - Cadastrar Recurso em um Evento\n";
        msg += "7 - Cadastrar Participante em um Evento\n";
        msg += "8 - Voltar\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.TipoInterface(msg);
        }while (flag < 1 && flag >= 7);

        switch (flag){
            case 1: {
                SistemaInteracao.showMessage(gerenciadorDeEventos.listarEventosToString());
                menuEvento();
                break;
            }
            case 2: {
                gerenciadorDeEventos.cadastroDeEventos(SistemaInteracao.criarEvento());
                menuEvento();
                break;
            }
            case 3: {
                gerenciadorDeEventos.cadastroDeEventos(SistemaInteracao.criarPalestra());
                menuEvento();
                break;
            }
            case 4: {
                gerenciadorDeEventos.cadastroDeEventos(SistemaInteracao.criarMinicurso());
                menuEvento();
                break;
            }
            case 5: {
                String titulo = SistemaInteracao.pegarInterface("Titulo: ");
                try{
                    for(Evento x : gerenciadorDeEventos.getEventos()){
                        if(x.getTitulo().equals(titulo)){
                            gerenciadorDeEventos.removerEventos(x);
                            menuEvento();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não existem eventos cadastrados!");
                }
                SistemaInteracao.showMessage("Não foi encontrado nenhum evento com este titulo!");
                menuEvento();
                break;
            }
            case 6: {
                String titulo = SistemaInteracao.pegarInterface("Digite o titulo do evento para cadastrar um recurso: ");
                try{
                    for(Evento x : gerenciadorDeEventos.getEventos()){
                        if(x.getTitulo().equals(titulo)){

                            int codigo = SistemaInteracao.TipoInterface("Digite o código do recurso: ");

                            try{
                                for(Recurso y : gerenciadorDeEventos.getRecursos()){
                                    if(y.getCodigo() == codigo){
                                        x.cadastrodeRecursos(y);
                                        gerenciadorDeEventos.removerEventos(x);
                                        gerenciadorDeEventos.cadastroDeEventos(x);
                                        menuEvento();
                                        break;
                                    }
                                }
                            }catch (NullPointerException ex){
                                SistemaInteracao.showMessage("Não existem recursos cadastrados");
                            }

                            SistemaInteracao.showMessage("Não foi encontrado o recurso com esse código!");
                            menuEvento();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não existe nenhum evento cadastrado!");
                }
                SistemaInteracao.showMessage("Não foi encontrado o evento com esse titulo!");
                menuEvento();
                break;
            }
            case 7: {
                String titulo = SistemaInteracao.pegarInterface("Digite o titulo do evento para cadastrar um participante: ");
                try{
                    for(Evento x : gerenciadorDeEventos.getEventos()){
                        if(x.getTitulo().equals(titulo)){

                            String matricula = SistemaInteracao.pegarInterface("Matricula do Participante: ");

                            try{
                                for(Participantes y : gerenciadorDeEventos.getParticipantes()){
                                    if(y.getMatricula().equals(matricula)){
                                        x.cadastroParticipantes(y);
                                        gerenciadorDeEventos.removerEventos(x);
                                        gerenciadorDeEventos.cadastroDeEventos(x);
                                        menuEvento();
                                        break;
                                    }
                                }
                            }catch (NullPointerException ex){
                                SistemaInteracao.showMessage("Não existe nenhum participante cadastrado");
                            }

                            SistemaInteracao.showMessage("Não foi encontrado nenhum participante com esta marticula!");
                            menuEvento();

                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não existe nenhum evento cadastrado!");
                }
                SistemaInteracao.showMessage("Não foi encontrado nenhum evento com este titulo!");
                menuEvento();
                break;
            }
            case 8: {
                menu();
                break;
            }
            default: {
                menuEvento();
            }
        }
    }

    public static void menuRecursos(){
        String msg = "";
        msg += "--- Menu de Recursos ---\n";
        msg += "1 - Listar Recursos\n";
        msg += "2 - Cadastrar Recursos\n";
        msg += "3 - Remover um Evento\n";
        msg += "4 - Voltar\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.TipoInterface(msg);
        }while (flag < 1 && flag > 4);

        switch (flag){
            case 1: {
                SistemaInteracao.showMessage(gerenciadorDeEventos.listarRecurosToString());
                menuRecursos();
                break;
            }
            case 2: {
                gerenciadorDeEventos.cadastroDeRecursos(SistemaInteracao.criarRecursos());
                menuRecursos();
                break;
            }
            case 3: {
                int codigo = SistemaInteracao.TipoInterface("Código: ");
                try{
                    for(Recurso x : gerenciadorDeEventos.getRecursos()){
                        if(x.getCodigo() == codigo){
                            gerenciadorDeEventos.removerRecurso(x);
                            menuRecursos();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não foi encontrado nenhum recurso com esse código");
                }
                menuRecursos();
                break;
            }
            case 4: {
                menu();
                break;
            }
            default: {
                menuRecursos();
            }
        }
    }
}
