package fiuba.algo3.modelo.dibujo;

import fiuba.algo3.modelo.Posicion;

public class Arista {

    private Posicion origen, destino;

    public Arista(Posicion origen, Posicion destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public boolean contiene(Posicion posicion) {
        return (this.origen.esIgual(posicion) || this.destino.esIgual(posicion));
    }

    public boolean contiene(Posicion origen, Posicion destino) {
        return (this.origen.esIgual(origen) && this.destino.esIgual(destino));
    }

    public Posicion obtenerDestino() {
        return destino;
    }
}