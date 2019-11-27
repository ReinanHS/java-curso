package br.ifsrobot.api;
// Classe de exceção que representa exceções do robô. Ela é subclasse de Exception.
public class RobotException extends Exception {
    public RobotException(String message) {
        super(message);
    }

    public RobotException() {
        super("Error");
    }
}
