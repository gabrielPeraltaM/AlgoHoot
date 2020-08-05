package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class PreguntaChoiceOrderer {
    private ArrayList<Respuesta> opcionesOrdenadas;
    private int cantidadOpciones;

    public PreguntaChoiceOrderer(int cantidadOpciones){
        this.cantidadOpciones = cantidadOpciones;
        this.opcionesOrdenadas = new ArrayList<>();
        for (int i=0;i < this.cantidadOpciones; i++){
            opcionesOrdenadas.add(new Respuesta());
        }
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorOrdered(opcionesOrdenadas,iterador));
        }
    }

    public Respuesta elegirRespuesta(int idx){
        return opcionesOrdenadas.get(idx);
    }
}
