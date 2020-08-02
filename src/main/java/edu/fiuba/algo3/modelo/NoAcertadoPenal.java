package edu.fiuba.algo3.modelo;

public class NoAcertadoPenal implements Validez {
    public int puntuar(){
        return -1;
    }

    public boolean esAcertado() { return false; }

    public void evaluarCon(Puntuador puntuador) { puntuador.fallido(); }
}

