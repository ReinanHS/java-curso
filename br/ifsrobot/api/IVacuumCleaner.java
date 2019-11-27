package br.ifsrobot.api;
//Interface que representa um aspirador de p� capaz de identificar se o local est� sujo e limp�-lo, se for necess�rio.
public interface IVacuumCleaner {
    // Liga o aspirador de p�.
    void turnOn();
    // Desliga o aspirador de p�.
    void turnOff();
    // Verifica se o local est� sujo.
    boolean isDirty();
    // Limpa o local onde o aspirador est�.
    void clean();
}
