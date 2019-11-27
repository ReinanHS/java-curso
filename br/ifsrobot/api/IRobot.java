package br.ifsrobot.api;
// Interface que representa um robô capaz de navegar em um ambiente.
public interface IRobot {
    void setStartPosition(Position position) throws RobotException;
    void setFinalPosition(Position position) throws RobotException;
    void printPosition();
    Position getCurrentPosition();
    Position move();
}
