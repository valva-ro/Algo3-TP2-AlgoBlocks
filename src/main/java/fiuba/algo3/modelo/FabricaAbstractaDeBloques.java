package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;

public interface FabricaAbstractaDeBloques {

    public BloqueMovimiento crearBloqueMovimientoArriba();

    public BloqueMovimiento crearBloqueMovimientoAbajo();

    public BloqueMovimiento crearBloqueMovimientoIzquierda();

    public BloqueMovimiento crearBloqueMovimientoDerecha();

}
