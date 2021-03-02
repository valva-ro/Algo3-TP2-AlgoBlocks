package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.Estado;
import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.bloques.NoDibuja;
import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Sur;

public class FabricaDeBloques {

    private Estado estado = new NoDibuja();

    public BloqueMovimiento crearBloqueMovimientoArriba() {
        return new BloqueMovimiento(new Norte(), estado);
    }

    public BloqueMovimiento crearBloqueMovimientoAbajo() {
        return new BloqueMovimiento(new Sur(), estado);
    }

    public BloqueMovimiento crearBloqueMovimientoIzquierda() {
        return new BloqueMovimiento(new Oeste(), estado);
    }

    public BloqueMovimiento crearBloqueMovimientoDerecha() {
        return new BloqueMovimiento(new Este(), estado);
    }

    public void fabricaDibuja() {
        this.estado = new Dibuja();
    }

    public void fabricaNoDibuja() {
        this.estado = new NoDibuja();
    }

    public void cambiarDeFabrica(){
        this.estado = estado.cambiarEstado();
    }
}