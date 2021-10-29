package it.euris.academy.aca_esame.exception;

public class PostiEsauriti extends RuntimeException{
    public PostiEsauriti() {
        super("Non ci sono più posti disponibili");
    }

    public PostiEsauriti(String message) {
        super(message);
    }
}
