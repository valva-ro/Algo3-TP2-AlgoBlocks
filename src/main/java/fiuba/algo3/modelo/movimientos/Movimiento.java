package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.bloques.Estado;

public abstract class Movimiento {

    protected Estado estado;

    public boolean estaDibujado(){
        return estado.estaDibujado();
    }

    public abstract Movimiento invertir();

    public abstract boolean esIgualA(Movimiento movimiento);
}
