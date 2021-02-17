package fiuba.algo3.modelo.dibujo;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direcciones.Direccion;

public class Vertice {

    private final Posicion posicion;

    public Vertice() {
        this.posicion = new Posicion(0,0);
    }

    public Vertice(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean contiene(Posicion posicion) {
        return this.posicion.esIgual(posicion);
    }

    public Vertice actualizar(Direccion direccion) {
        return new Vertice(direccion.actualizarPosicion(this.posicion));
    }
}
