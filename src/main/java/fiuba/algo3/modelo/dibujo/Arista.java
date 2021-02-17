package fiuba.algo3.modelo.dibujo;

import fiuba.algo3.modelo.Posicion;

public class Arista {

    private Vertice origen, destino;
    private boolean dibuja;

    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
        this.dibuja = true;
    }

    public Arista(Vertice origen, Vertice destino, boolean dibuja) {
        this.origen = origen;
        this.destino = destino;
        this.dibuja = dibuja;
    }

    public boolean contiene(Posicion posicion) {
        return (origen.contiene(posicion) || destino.contiene(posicion));
    }

    public boolean dibuja() {
        return dibuja;
    }

    public Vertice obtenerDestino() {
        return destino;
    }
}
