package br.ifsrobot.api;
// Classe de exce��o que representa exce��es do rob�. Ela � subclasse de Exception.
public class RobotException extends Exception {
    public RobotException(String message) {
        super(message);
    }

    public RobotException() {
        super("Error");
    }
}
