package fiuba.algo3.modelo.fabricas;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;

public interface FabricaAbstractaDeBloques {

    BloqueMovimiento crearBloqueMovimientoArriba();

    BloqueMovimiento crearBloqueMovimientoAbajo();

    BloqueMovimiento crearBloqueMovimientoIzquierda();

    BloqueMovimiento crearBloqueMovimientoDerecha();

}
