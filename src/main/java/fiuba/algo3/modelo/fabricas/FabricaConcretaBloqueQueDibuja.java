package fiuba.algo3.modelo.fabricas;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.movimientos.Izquierda;

public class FabricaConcretaBloqueQueDibuja implements FabricaAbstractaDeBloques {

    @Override
    public BloqueMovimiento crearBloqueMovimientoArriba() {
        Dibuja estado = new Dibuja();
        Arriba arribaDibuja = new Arriba(estado);

        return new BloqueMovimiento(arribaDibuja);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoAbajo() {
        Dibuja estado = new Dibuja();
        Abajo abajoDibuja = new Abajo(estado);

        return new BloqueMovimiento(abajoDibuja);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoIzquierda() {
        Dibuja estado       = new Dibuja();
        Izquierda izquierdaDibuja       = new Izquierda(estado);

        return new BloqueMovimiento(izquierdaDibuja);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoDerecha() {

        Dibuja estado       = new Dibuja();
        Derecha derechaDibuja   = new Derecha(estado);

        return new BloqueMovimiento(derechaDibuja);
    }
}
