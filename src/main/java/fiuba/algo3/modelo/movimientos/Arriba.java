package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.bloques.Estado;

public class Arriba extends Movimiento {

    public Arriba(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir()  {
        return new Abajo(estado);
    }

    @Override
    public boolean esIgualA(Movimiento movimiento) {
        return (movimiento instanceof Arriba && this.estado.estaDibujado() == movimiento.estaDibujado());
    }
}
