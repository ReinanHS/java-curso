package br.ifsrobot.api;

import br.ifsrobot.api.Environment;
import br.ifsrobot.api.LeftRigthVacuumCleanerRobot;
import br.ifsrobot.api.Position;

public class TestVacuumCleaner {

    public static Environment environment;
    public static LeftRigthVacuumCleanerRobot robot;

    public static void inicialize() {
        char[][] mapOriginal = {{' ','S',' '}, {' ','S',' '}, {'S',' ',' '}};
        environment = new Environment(mapOriginal);
        robot = new LeftRigthVacuumCleanerRobot(environment);
    }

    public static boolean testLRVacuumCleanerTurnOn() {
        inicialize();
        robot.turnOn();
        return robot.isSwitchedOn();
    }

    public static boolean testLRVacuumCleanerTurnOff() {
        inicialize();
        robot.turnOn();
        robot.turnOff();
        return !robot.isSwitchedOn();
    }

    public static boolean testInitialPosition() {
        inicialize();
        return robot.getInitialPosition().equals(new Position(0,0));
    }

    public static boolean testFinalPosition() {
        inicialize();
        return robot.getFinalPosition().equals(new Position(2,2));
    }

    public static boolean testCurrentPositionAfterOneMove() {
        inicialize();
        robot.move();
        return robot.getCurrentPosition().equals(new Position(0,1));
    }

    public static boolean testCurrentPositionAfterThreeMoves() {
        inicialize();
        for (int i = 0; i < 3; i++)
            robot.move();

        return robot.getCurrentPosition().equals(new Position(1,0));
    }

    public static boolean testInitialEnvironment() {
        inicialize();
        char[][] mapGoal = {{' ','S',' '}, {' ','S',' '}, {'S',' ',' '}};
        Environment environmentGoal = new Environment(mapGoal);

        return robot.getEnvironment().equals(environmentGoal);
    }


    public static boolean testEnvironmentAfterOneMoveAndOneClean() {
        inicialize();
        char[][] mapGoal = {{' ',' ',' '}, {' ','S',' '}, {'S',' ',' '}};
        Environment environmentGoal = new Environment(mapGoal);
        robot.move();
        robot.clean();

        return robot.getEnvironment().equals(environmentGoal);
    }

    public static boolean testEnvironmentAfterThreeMovesAndOneClean() {
        inicialize();
        char[][] mapGoal = {{' ','S',' '}, {' ','S',' '}, {'S',' ',' '}};
        Environment environmentGoal = new Environment(mapGoal);
        for (int i = 0; i < 3; i++)
            robot.move();
        robot.clean();

        return robot.getEnvironment().equals(environmentGoal);
    }

    public static boolean testEnvironmentAfterFourMovesAndOneClean() {
        inicialize();
        char[][] mapGoal = {{' ','S',' '}, {' ',' ',' '}, {'S',' ',' '}};
        Environment environmentGoal = new Environment(mapGoal);
        for (int i = 0; i < 4; i++)
            robot.move();
        robot.clean();

        return robot.getEnvironment().equals(environmentGoal);
    }


    public static boolean testEnvironmentAfterOneMoveAndCleanAndAfterThreeMovesAndClean() {
        inicialize();
        char[][] mapGoal = {{' ',' ',' '}, {' ',' ',' '}, {'S',' ',' '}};
        Environment environmentGoal = new Environment(mapGoal);
        robot.move();
        robot.clean();

        for (int i = 0; i < 3; i++)
            robot.move();
        robot.clean();

        return robot.getEnvironment().equals(environmentGoal);
    }

    public static void main(String[] args) {
        int totalTest = 11;
        String[] testName = new String[totalTest];
        boolean[] testResu = new boolean[totalTest];
        double[] score = {0.5, 0.5, 0.5, 0.5, 0.5, 0.75, 0.75, 1.0, 1.0, 1.0, 1.0};

        testName[0] = "Testar ligar aspirador de pó.";
        testResu[0] = testLRVacuumCleanerTurnOn();

        testName[1] = "Testar desligar aspirador de pó.";
        testResu[1] = testLRVacuumCleanerTurnOff();

        testName[2] = "Testar posição inicial.";
        testResu[2] = testInitialPosition();

        testName[3] = "Testar posição final.";
        testResu[3] = testFinalPosition();

        testName[4] = "Testar posição atual após um movimento.";
        testResu[4] = testCurrentPositionAfterOneMove();

        testName[5] = "Testar posição atual após três movimentos.";
        testResu[5] = testCurrentPositionAfterThreeMoves();

        testName[6] = "Testar o ambiente inicial.";
        testResu[6] = testInitialEnvironment();

        testName[7] = "Testar o ambiente após um movimento e uma limpeza.";
        testResu[7] = testEnvironmentAfterOneMoveAndOneClean();

        testName[8] = "Testar o ambiente após três movimentos e uma limpeza.";
        testResu[8] = testEnvironmentAfterThreeMovesAndOneClean();

        testName[9] = "Testar o ambiente após quatro movimentos e uma limpeza.";
        testResu[9] = testEnvironmentAfterFourMovesAndOneClean();

        testName[10] = "Testar o ambiente após um movimento e limpar, depois mais três movimentos e limpar.";
        testResu[10] = testEnvironmentAfterOneMoveAndCleanAndAfterThreeMovesAndClean();

        System.out.println("::: Correção da Prova :::");

        double notaFinal = 0;
        for (int i = 0; i < totalTest; i++) {
            String resultado = (testResu[i])?"Aprovado":"Reprovado";
            double notaParcial = (testResu[i])? score[i]: 0.0;
            notaFinal = notaFinal + notaParcial;
            System.out.println("["+i+"] "+testName[i]+": "+resultado+" = "+notaParcial);
        }
        System.out.println("\nNota Final: " + notaFinal);
        System.out.println("\n\nOBSERVAÇÃO: \n1) A inspeção do código vale de 0,0 a 2,0 pontos.\n2)A prova é individual, portanto, será atribuída a nota 0,0 (zero) às provas semelhantes.");

    }
}