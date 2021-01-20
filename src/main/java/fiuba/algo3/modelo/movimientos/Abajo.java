package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.bloques.Estado;

public class Abajo extends Movimiento {

    public Abajo(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir() {
        return new Arriba(estado);
    }

    @Override
    public boolean esIgualA(Movimiento movimiento) {
        return (movimiento instanceof Abajo && this.estado.estaDibujado() == movimiento.estaDibujado());
    }
}
