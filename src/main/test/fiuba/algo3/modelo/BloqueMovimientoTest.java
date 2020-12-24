package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BloqueMovimientoTest {

    @Test
    public void test01BloqueMovimientoTieneMovimientoDerechaNoDibuja(){
        NoDibuja estado = new NoDibuja();
        Derecha derechaNoDibuja = new Derecha(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(derechaNoDibuja);

        assertEquals(derechaNoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test02BloqueMovimientoTieneMovimientoDerechaDibuja(){
        Dibuja estado = new Dibuja();
        Derecha derechaDibuja = new Derecha(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(derechaDibuja);

        assertEquals(derechaDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test03BloqueMovimientoTieneMovimientoIzquierdaNoDibuja(){
        NoDibuja estado = new NoDibuja();
        Izquierda izquierdaNoDibuja = new Izquierda(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(izquierdaNoDibuja);

        assertEquals(izquierdaNoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test04BloqueMovimientoTieneMovimientoIzquierdaDibuja(){
        Dibuja estado = new Dibuja();
        Izquierda izquierdaDibuja = new Izquierda(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(izquierdaDibuja);

        assertEquals(izquierdaDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test05BloqueMovimientoTieneMovimientoIzquierdaNoDibuja(){
        NoDibuja estado = new NoDibuja();
        Arriba arribaNoDibuja = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaNoDibuja);

        assertEquals(arribaNoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test06BloqueMovimientoTieneMovimientoArribaDibuja(){
        Dibuja estado = new Dibuja();
        Arriba arribaDibuja = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaDibuja);

        assertEquals(arribaDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test06BloqueMovimientoTieneMovimientoIzquierdaNoDibuja(){
        NoDibuja estado = new NoDibuja();
        Abajo abajoNoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoNoDibuja);

        assertEquals(abajoNoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test07BloqueMovimientoTieneMovimientoArribaDibuja(){
        Dibuja estado = new Dibuja();
        Abajo abajoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoDibuja);

        assertEquals(abajoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

}
