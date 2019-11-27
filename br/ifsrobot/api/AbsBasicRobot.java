package br.ifsrobot.api;
// Classe abstrata que representa um robô capaz de navegar no ambiente.
public abstract class AbsBasicRobot implements IRobot {
    // Atributos
    // Atributo que armazena o ambiente do robô.
    protected Environment environment;
    // Atributo que armazena posição atual do robô.
    protected Position currentPosition = new Position(0,0);
    // Atributo que armazena posição inicial (origem) do robô.
    protected Position initialPosition = new Position(0,0);
    // Atributo que armazena posição final (destino) do robô.
    protected Position finalPosition = new Position(0,0);

    // Construtores

    public AbsBasicRobot(Environment environment){
        this.environment = environment;
    }

    // Métodos
    // Método para definir a posição inicial do robô. O método deve lançar um exceção
    //do tipo RobotException com a mensagem "Posição inicial inválida." caso a
    //posição informada esteja fora dos limites do ambiente.
    public void setStartPosition(Position position) throws RobotException{
        try{

            if( position.getCol() <= this.environment.getLength() && position.getRow() <= this.environment.getWidth() ){
                this.initialPosition = position;
            }else{
                throw new RobotException("Posição inicial inválida. caso a posição informada esteja fora dos limites do ambiente.");
            }

            // Mudar isso depois
        }catch (NullPointerException ex){
            throw new RobotException("Posição inicial não iniciada");
        }
    }
    // Método para definir a posição final do robô. O método deve lançar um exceção
    //do tipo RobotException com a mensagem "Posição final inválida." caso a
    //posição informada esteja fora dos limites do ambiente.
    public void setFinalPosition(Position position) throws RobotException{
        try{

            if( position.getCol() <= this.environment.getLength() && position.getRow() <= this.environment.getWidth() ){
                this.finalPosition = position;
            }else{
                throw new RobotException("Posição final inválida. caso a posição informada esteja fora dos limites do ambiente.");
            }

            // Mudar isso depois
        }catch (NullPointerException ex){
            throw new RobotException("Posição final não iniciada");
        }
    }
//    Método que retorna o ambiente do robô.
    public Environment getEnvironment(){
        return this.environment;
    }
//    Método que retorna a posição inicial do robô.
    public Position getInitialPosition(){
        return this.initialPosition;
    }
//    Método que retorna a posição final do robô.
    public Position getFinalPosition(){
        return this.finalPosition;
    }
//    Método que retorna a posição atual do robô.
    public Position getCurrentPosition(){
        return this.currentPosition;

    }
//  Método que imprime a posição do robô no formato "\nO robô está na posição
//
//   "+<posição>+"."
    public void printPosition(){
        System.out.println("O robô está na posição ["+this.getCurrentPosition().getCol()+"]"+this.getCurrentPosition().getRow());
    }
}
