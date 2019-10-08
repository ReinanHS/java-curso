package br.semanaAcademica;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static GerenciarEventos gerenciarEventos = new GerenciarEventos();

    public static void main(String[] args) {
        SistemaInteracao.UI_TIPO = tipoMenu();
        menu();
    }

    public static Class tipoMenu(){
        int tipo = 0;

        do{
            tipo = SistemaInteracao.getIntUI("Digite o tipo de interface que você quer: \n\n[01] - CMD\n[02] - Interface grafica\n\n");
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
        String mgs = "";
        mgs += "[01] - Participante Menu\n";
        mgs += "[02] - Eventos Menu\n";
        mgs += "[03] - Recursos Menu\n";
        mgs += "[04] - Sair\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.getIntUI(mgs);
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
        String mgs = "";
        mgs += "[01] - Participantes Listar\n";
        mgs += "[02] - Cadastrar Participante\n";
        mgs += "[03] - Cadastrar Aluno\n";
        mgs += "[04] - Cadastrar Professor\n";
        mgs += "[05] - Remover um Participante\n";
        mgs += "[06] - Voltar\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.getIntUI(mgs);
        }while (flag < 1 && flag >= 6);

        switch (flag){
            case 1: {
                SistemaInteracao.showMessage(gerenciarEventos.listarParticipantesToString());
                menuParticipante();
                break;
            }
            case 2: {
                gerenciarEventos.cadastrarPartipantes(SistemaInteracao.criarParticipante());
                menuParticipante();
                break;
            }
            case 3: {
                gerenciarEventos.cadastrarPartipantes(SistemaInteracao.criarAlunos());
                menuParticipante();
                break;
            }
            case 4: {
                gerenciarEventos.cadastrarPartipantes(SistemaInteracao.criarProfessor());
                menuParticipante();
                break;
            }
            case 5: {
                String matricula = SistemaInteracao.getUI("Digite a matricula: ");
                try{
                    for(Participante x : gerenciarEventos.getParticipantes()){
                        if(x.getMatricula().equals(matricula)){
                            gerenciarEventos.removerParticipante(x);
                            menuParticipante();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não tem participantes");
                    //menuParticipante();
                }
                SistemaInteracao.showMessage("Não foi encontrado nenhum participante com essa matrícula");
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
        String mgs = "";
        mgs += "[01] - Eventos  Listar\n";
        mgs += "[02] - Cadastrar Evento\n";
        mgs += "[03] - Cadastrar Palestra\n";
        mgs += "[04] - Cadastrar Mini Curso\n";
        mgs += "[05] - Remover um Evento\n";
        mgs += "[06] - Cadastrar Recurso em um Evento\n";
        mgs += "[07] - Cadastrar Participante em um Evento\n";
        mgs += "[08] - Voltar\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.getIntUI(mgs);
        }while (flag < 1 && flag >= 7);

        switch (flag){
            case 1: {
                SistemaInteracao.showMessage(gerenciarEventos.listarEventosToString());
                menuEvento();
                break;
            }
            case 2: {
                gerenciarEventos.cadastroDeEventos(SistemaInteracao.criarEvento());
                menuEvento();
                break;
            }
            case 3: {
                gerenciarEventos.cadastroDeEventos(SistemaInteracao.criarPalestra());
                menuEvento();
                break;
            }
            case 4: {
                gerenciarEventos.cadastroDeEventos(SistemaInteracao.criarMinicurso());
                menuEvento();
                break;
            }
            case 5: {
                String titulo = SistemaInteracao.getUI("Digite um titulo: ");
                try{
                    for(Evento x : gerenciarEventos.getEventos()){
                        if(x.getTitulo().equals(titulo)){
                            gerenciarEventos.removerEventos(x);
                            menuEvento();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não tem evento!");
                }
                SistemaInteracao.showMessage("Não foi encontrado o evento com esse titulo!");
                menuEvento();
                break;
            }
            case 6: {
                String titulo = SistemaInteracao.getUI("Digite um titulo do evento para cadastrar um recurso: ");
                try{
                    for(Evento x : gerenciarEventos.getEventos()){
                        if(x.getTitulo().equals(titulo)){

                            int codigo = SistemaInteracao.getIntUI("Digite o código do recurso: ");

                            try{
                                for(Recursos y : gerenciarEventos.getRecursos()){
                                    if(y.getCodigo() == codigo){
                                        x.cadastroRecursos(y);
                                        gerenciarEventos.removerEventos(x);
                                        gerenciarEventos.cadastroDeEventos(x);
                                        menuEvento();
                                        break;
                                    }
                                }
                            }catch (NullPointerException ex){
                                SistemaInteracao.showMessage("Não tem recurso");
                            }

                            SistemaInteracao.showMessage("Não foi encontrado o recurso com esse código!");
                            menuEvento();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não tem evento!");
                    //menuEvento();
                }
                SistemaInteracao.showMessage("Não foi encontrado o evento com esse titulo!");
                menuEvento();
                break;
            }
            case 7: {
                String titulo = SistemaInteracao.getUI("Digite um titulo do evento para cadastrar um participante: ");
                try{
                    for(Evento x : gerenciarEventos.getEventos()){
                        if(x.getTitulo().equals(titulo)){

                            String matricula = SistemaInteracao.getUI("Digite a matricula do Participante: ");

                            try{
                                for(Participante y : gerenciarEventos.getParticipantes()){
                                    if(y.getMatricula().equals(matricula)){
                                        x.cadastroParticipantes(y);
                                        gerenciarEventos.removerEventos(x);
                                        gerenciarEventos.cadastroDeEventos(x);
                                        menuEvento();
                                        break;
                                    }
                                }
                            }catch (NullPointerException ex){
                                SistemaInteracao.showMessage("Não tem participante");
                                //menuEvento();
                            }

                            SistemaInteracao.showMessage("Não foi encontrado um participante com essa marticula!");
                            menuEvento();

                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não tem evento!");
                    //menuEvento();
                }
                SistemaInteracao.showMessage("Não foi encontrado o evento com esse titulo!");
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
        String mgs = "";
        mgs += "[01] - Recursos  Listar\n";
        mgs += "[02] - Cadastrar Recursos\n";
        mgs += "[03] - Remover um Evento\n";
        mgs += "[04] - Voltar\n";

        int flag = 0;

        do{
            flag = SistemaInteracao.getIntUI(mgs);
        }while (flag < 1 && flag > 4);

        switch (flag){
            case 1: {
                SistemaInteracao.showMessage(gerenciarEventos.listarRecurosToString());
                menuRecursos();
                break;
            }
            case 2: {
                gerenciarEventos.cadastroDeRecursos(SistemaInteracao.criarRecursos());
                menuRecursos();
                break;
            }
            case 3: {
                int codigo = SistemaInteracao.getIntUI("Digite um codigo: ");
                try{
                    for(Recursos x : gerenciarEventos.getRecursos()){
                        if(x.getCodigo() == codigo){
                            gerenciarEventos.removerRecurso(x);
                            menuRecursos();
                            break;
                        }
                    }
                }catch (NullPointerException ex){
                    SistemaInteracao.showMessage("Não foi encontrado um recurso com esse código");
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
