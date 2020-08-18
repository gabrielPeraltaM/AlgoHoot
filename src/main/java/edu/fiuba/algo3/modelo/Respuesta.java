package edu.fiuba.algo3.modelo;

import java.io.Serializable;

public class Respuesta implements Serializable {
    private ValidezRespuesta validez;
    private final String enunciado;

    public Respuesta(String enunciado) {
        this.validez = new Incorrecta();
        this.enunciado = enunciado;
    }

    public void establecerComoRespuestaAcertada() {
        this.validez = new Correcta();
    }

    public void evaluarCon(Evaluador evaluador) {
        this.validez.evaluarCon(evaluador);
    }

    public String devolverEnunciado() {
        return this.enunciado;
    }
}
