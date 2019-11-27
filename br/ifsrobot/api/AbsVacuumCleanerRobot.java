package br.ifsrobot.api;
// Classe abstrata que representa um robô aspirador de pó capaz de navegar no ambiente, identificar se o local está sujo e
//limpá-lo, se for necessário.
public abstract class AbsVacuumCleanerRobot extends AbsBasicRobot implements IVacuumCleaner {
    // Atributos
    private boolean switchedOn;
    // Construtor com o ambiente em que o robô aspirador de pó navegará e limpará.
    public AbsVacuumCleanerRobot(Environment environment){
        super(environment);
    }
    // Métodos
    // Método para ligar o robô.
    public void turnOn(){
        this.switchedOn = true;
    }
    public void turnOff(){
        this.switchedOn = false;
    }
    // Método que retorna se a posição onde o robô está no ambiente possui sujeira.
    //O método deve retornar True se estiver sujo ou False se estiver limpo.
    //Observação: O local está sujo se a posição no ambiente está marcada com 'S'.
    public boolean isDirty(){
        char valor = this.environment.getValue(this.currentPosition);

        return valor == 'S';
    }
    //
    public void clean(){
        if(this.isDirty()){
            this.environment.setValue(' ',this.currentPosition);
        }
    }


    public boolean isSwitchedOn(){
        return this.switchedOn;
    }
}
