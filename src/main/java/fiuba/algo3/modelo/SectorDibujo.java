package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Recorrido;
import fiuba.algo3.modelo.direcciones.Direccion;

public class SectorDibujo {

    private Recorrido recorridoDibujado = new Recorrido();
    private Posicion posicionFinal = new Posicion();

    public void dibujar(Direccion direccion) {
        this.posicionFinal = this.recorridoDibujado.agregarArista(direccion, posicionFinal);
    }

    public void noDibujar(Direccion direccion) {
        this.posicionFinal = direccion.actualizarPosicion(posicionFinal);
    }

    public boolean existePosicion(Posicion posicion) {
        return this.recorridoDibujado.existeVertice(posicion);
    }

    public boolean existeArista(Posicion origen, Posicion destino) {
        return this.recorridoDibujado.existeArista(origen, destino);
    }
}