package br.concurso;

public class LimiteExcedidoException extends Exception {
    public LimiteExcedidoException() {
        super("Limite do repositório foi excedido.");
    }

    public LimiteExcedidoException(String message) {
        super(message);
    }
}
