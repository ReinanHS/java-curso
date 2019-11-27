package br.ifsrobot.api;
//Interface que representa um aspirador de pó capaz de identificar se o local está sujo e limpá-lo, se for necessário.
public interface IVacuumCleaner {
    // Liga o aspirador de pó.
    void turnOn();
    // Desliga o aspirador de pó.
    void turnOff();
    // Verifica se o local está sujo.
    boolean isDirty();
    // Limpa o local onde o aspirador está.
    void clean();
}
