package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Dibujo;
import fiuba.algo3.modelo.direcciones.Direccion;

public class SectorDibujo {

    private Dibujo dibujo = new Dibujo();
    private boolean dibuja = false;

    public void invertirDibuja() {
        this.dibuja = !this.dibuja;
    }

    public void dibujar(Direccion direccion) {
        if (dibuja)
            dibujo.agregarTrazo(direccion, dibuja);
    }

    public boolean dibuja() {
        return this.dibuja;
    }

    public boolean existe(Posicion posicion) {
        return dibujo.existe(posicion);
    }
}
