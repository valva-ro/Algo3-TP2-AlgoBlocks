package fiuba.algo3.modelo.direcciones;

import fiuba.algo3.modelo.Posicion;

public abstract class Direccion {

    protected int x, y;

    public Posicion actualizarPosicion(Posicion posicion) {
        return posicion.actualizarCoordenadas(this.x, this.y);
    }

    public abstract Direccion invertir();
}