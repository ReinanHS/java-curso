package br.ifsrobot.api;
// Classe abstrata que representa um rob� aspirador de p� capaz de navegar no ambiente, identificar se o local est� sujo e
//limp�-lo, se for necess�rio.
public abstract class AbsVacuumCleanerRobot extends AbsBasicRobot implements IVacuumCleaner {
    // Atributos
    private boolean switchedOn;
    // Construtor com o ambiente em que o rob� aspirador de p� navegar� e limpar�.
    public AbsVacuumCleanerRobot(Environment environment){
        super(environment);
    }
    // M�todos
    // M�todo para ligar o rob�.
    public void turnOn(){
        this.switchedOn = true;
    }
    public void turnOff(){
        this.switchedOn = false;
    }
    // M�todo que retorna se a posi��o onde o rob� est� no ambiente possui sujeira.
    //O m�todo deve retornar True se estiver sujo ou False se estiver limpo.
    //Observa��o: O local est� sujo se a posi��o no ambiente est� marcada com 'S'.
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
