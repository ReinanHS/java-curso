package br.concurso;
// Interface que representa uma questão.
// O tipo de gabarito da questão depende do tipo de questão a ser instanciado, portanto, utilize o tipo genérico representado pela letra G.
public interface IQuestao<G> {
    // Métodos
    // Obter o enunciado
    String getEnunciado();

    // Modificar o enunciado
    void setEnunciado(String enunciado);

    // Obter as alternativas de resposta
    Alternativa[] getAlternativas();

    // Modificar as alternativas de resposta
    void setAlternativas(Alternativa[] alternativas);

    // Adicionar uma alternativa a questão.
    // O método lança uma exceção do tipo LimiteExcedidoException ao tentar inserir uma alternativa acima do limite de alternativas para questão.
    void addAlternativa(Alternativa alternativa) throws LimiteExcedidoException;

    // Obter o gabarito da questão
    G getGabarito();

    // Obter o assunto da questão
    Assunto getAssunto();

    // Modificar o assunto da questão
    void setAssunto(Assunto assunto);

    // Obter a complexidade da questão
    Complexidade getComplexidade();

    // Modificar a complexidade da questão
    void setComplexidade(Complexidade complexidade);
}
