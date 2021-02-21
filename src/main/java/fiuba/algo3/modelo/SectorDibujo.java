package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Recorrido;
import fiuba.algo3.modelo.direcciones.Direccion;

public class SectorDibujo {

    private Recorrido recorrido = new Recorrido();
    private Posicion posicionFinal = new Posicion();

    public void dibujar(Direccion direccion) {
        this.posicionFinal = this.recorrido.agregarArista(direccion, posicionFinal);
    }

    public void noDibujar(Direccion direccion) {
        this.posicionFinal = direccion.actualizarPosicion(posicionFinal);
    }

    public boolean existePosicion(Posicion posicion) {
        return this.recorrido.existeVertice(posicion);
    }

    public boolean existeArista(Posicion origen, Posicion destino) {
        return this.recorrido.existeArista(origen, destino);
    }
}