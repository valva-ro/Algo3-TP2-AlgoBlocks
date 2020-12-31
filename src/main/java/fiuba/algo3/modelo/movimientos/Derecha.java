package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.bloques.Estado;

public class Derecha extends Movimiento {

    public Derecha(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir() {
        return new Izquierda(estado);
    }
}
