package br.concurso;
// Interface que representa uma quest�o.
// O tipo de gabarito da quest�o depende do tipo de quest�o a ser instanciado, portanto, utilize o tipo gen�rico representado pela letra G.
public interface IQuestao<G> {
    // M�todos
    // Obter o enunciado
    String getEnunciado();

    // Modificar o enunciado
    void setEnunciado(String enunciado);

    // Obter as alternativas de resposta
    Alternativa[] getAlternativas();

    // Modificar as alternativas de resposta
    void setAlternativas(Alternativa[] alternativas);

    // Adicionar uma alternativa a quest�o.
    // O m�todo lan�a uma exce��o do tipo LimiteExcedidoException ao tentar inserir uma alternativa acima do limite de alternativas para quest�o.
    void addAlternativa(Alternativa alternativa) throws LimiteExcedidoException;

    // Obter o gabarito da quest�o
    G getGabarito();

    // Obter o assunto da quest�o
    Assunto getAssunto();

    // Modificar o assunto da quest�o
    void setAssunto(Assunto assunto);

    // Obter a complexidade da quest�o
    Complexidade getComplexidade();

    // Modificar a complexidade da quest�o
    void setComplexidade(Complexidade complexidade);
}
