package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;

public class PreguntaGrupo implements Pregunta{
    private final ArrayList<Respuesta> respuestasGrupoA;
    private final ArrayList<Respuesta> respuestasGrupoB;
    private final ArrayList<Respuesta> respuestasElegibles;
    private ExclusividadPuntaje exclusividad;

    public PreguntaGrupo(int cantidadGrupoA, int cantidadGrupoB){
        this.respuestasGrupoA = new ArrayList<>();
        this.respuestasGrupoB = new ArrayList<>();
        this.respuestasElegibles = new ArrayList<>();
        this.exclusividad= new ExlusividadNula();
        for (int i=0;i < cantidadGrupoA+cantidadGrupoB; i++){
            if (i < cantidadGrupoA){
                respuestasGrupoA.add(new Respuesta("Algo"));
            }
            else {
                respuestasGrupoB.add(new Respuesta("Algo"));
            }
        }
        respuestasElegibles.addAll(respuestasGrupoA);
        respuestasElegibles.addAll(respuestasGrupoB);
    }

    public Respuesta elegirRespuesta(int idx){
        return respuestasElegibles.get(idx);
    }

    @Override
    public ArrayList<Respuesta> devolverRespuestasPosibles() {
        return this.respuestasElegibles;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        ArrayList<Evaluador> evaluadores = new ArrayList<>();
        Iterator<RespuestasJugador> iterator = respuestasVariosJugadores.iterator();
        while (iterator.hasNext()){
            EvaluadorGrupo evaluador= new EvaluadorGrupo(respuestasGrupoA,respuestasGrupoB,iterator);
            evaluador.sumarPuntosParciales();
            evaluadores.add(evaluador);
        }
        exclusividad.agregarEvaluador(evaluadores.get(0),evaluadores.get(1));
        exclusividad.puntuarJugadores();
    }

    @Override
    public JsonObject guardar() {
        return null;
    }

    @Override
    public String devolverEnunciado() {
        return null;
    }

    public void usarExclusividad() {
        this.exclusividad=this.exclusividad.cambiarExclusividad();
    }
}
