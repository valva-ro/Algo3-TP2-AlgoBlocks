package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Recorrido;
import fiuba.algo3.modelo.direcciones.Direccion;

import java.util.ArrayList;

public class SectorDibujo implements DibujoObservable {

    private Recorrido recorrido = new Recorrido();
    private Posicion posicionFinal = new Posicion();
    private ArrayList<ObservadorDibujo> observadores;

    public SectorDibujo() {
        this.observadores = new ArrayList<>();
    }

    public void dibujar(Direccion direccion) {
        Posicion unaPosicion = this.recorrido.agregarArista(direccion, posicionFinal);
        notificarObservadores(true, this.posicionFinal, unaPosicion);
        this.posicionFinal = unaPosicion;

    }

    public void noDibujar(Direccion direccion) {
        Posicion unaPosicion = direccion.actualizarPosicion(posicionFinal);
        notificarObservadores(false, this.posicionFinal, unaPosicion);
        this.posicionFinal = unaPosicion;
    }

    public boolean existePosicion(Posicion posicion) {
        return this.recorrido.existeVertice(posicion);
    }

    public boolean existeArista(Posicion origen, Posicion destino) {
        return this.recorrido.existeArista(origen, destino);
    }

    @Override
    public void notificarObservadores(Boolean bool, Posicion posicionInicial, Posicion posicionFinal) {
        for (ObservadorDibujo obs : observadores)
            obs.actualizar(bool, posicionInicial, posicionFinal);
    }

    @Override
    public void agregarObservador(ObservadorDibujo obs) {
        this.observadores.add(obs);
    }
}