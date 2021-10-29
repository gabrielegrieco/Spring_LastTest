package it.euris.academy.aca_esame.exception;

public class VietatoAiMinori extends RuntimeException {

    public VietatoAiMinori() {
        super("il film è vietato ai minori di 18 anni");
    }

    public VietatoAiMinori(String message) {
        super(message);
    }
}
