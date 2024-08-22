package br.com.paiva.hexagonal.application.port;

public abstract class UseCase<INPUT, OUTPUT> {
    public abstract OUTPUT execute(INPUT input);
}
