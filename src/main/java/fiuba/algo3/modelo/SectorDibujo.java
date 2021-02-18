package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Recorrido;
import fiuba.algo3.modelo.direcciones.Direccion;

public class SectorDibujo {

    private Recorrido recorridoDibujado = new Recorrido();
    private Recorrido recorridoTotal = new Recorrido();

    public void dibujar(Direccion direccion) {
        this.recorridoDibujado.agregarArista(direccion, this.recorridoTotal);
        this.recorridoTotal.agregarArista(direccion, this.recorridoTotal);
    }

    public void noDibujar(Direccion direccion) {
        this.recorridoTotal.agregarArista(direccion, this.recorridoTotal);
    }

    public boolean existePosicion(Posicion posicion) {
        return this.recorridoDibujado.existeVertice(posicion);
    }

    public boolean existeArista(Posicion origen, Posicion destino) {
        return this.recorridoDibujado.existeArista(origen, destino);
    }
}
