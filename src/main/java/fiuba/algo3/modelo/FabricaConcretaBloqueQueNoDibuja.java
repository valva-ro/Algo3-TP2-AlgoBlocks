package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.NoDibuja;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.movimientos.Izquierda;

public class FabricaConcretaBloqueQueNoDibuja implements FabricaAbstractaDeBloques {

    @Override
    public BloqueMovimiento crearBloqueMovimientoArriba() {
        NoDibuja estado = new NoDibuja();
        Arriba arribaNoDibuja = new Arriba(estado);

        return new BloqueMovimiento(arribaNoDibuja);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoAbajo() {
        NoDibuja estado = new NoDibuja();
        Abajo abajoNoDibuja = new Abajo(estado);

        return new BloqueMovimiento(abajoNoDibuja);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoIzquierda() {
        NoDibuja estado       = new NoDibuja();
        Izquierda izquierdaNoDibuja       = new Izquierda(estado);

        return new BloqueMovimiento(izquierdaNoDibuja);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoDerecha() {

        NoDibuja estado       = new NoDibuja();
        Derecha derechaNoDibuja   = new Derecha(estado);

        return new BloqueMovimiento(derechaNoDibuja);
    }
}
