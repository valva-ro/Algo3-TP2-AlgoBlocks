package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.movimientos.Dibuja;
import fiuba.algo3.modelo.movimientos.NoDibuja;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Izquierda;
import fiuba.algo3.modelo.movimientos.Derecha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueMovimientoTest {
    // TODO: Alejo corregir los get.Class() por el esIgual()
    @Test
    public void test01BloqueMovimientoTieneMovimientoDerechaNoDibuja(){
        NoDibuja estado = new NoDibuja();
        Derecha derechaNoDibuja  = new Derecha(estado);
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
        Izquierda izquierdaNoDibuja       = new Izquierda(estado);
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
        Arriba arribaDibuja   = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaDibuja);

        assertEquals(arribaDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test07BloqueMovimientoTieneMovimientoIzquierdaNoDibuja(){
        NoDibuja estado = new NoDibuja();
        Abajo abajoNoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoNoDibuja);

        assertEquals(abajoNoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test08BloqueMovimientoTieneMovimientoArribaDibuja(){
        Dibuja estado = new Dibuja();
        Abajo abajoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoDibuja);

        assertEquals(abajoDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test09BloqueMovimientoTieneMovimientoDerechaDibujandoYSeInvierteAIzquierda(){
        Dibuja estado = new Dibuja();
        Derecha derechaDibuja = new Derecha(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(derechaDibuja);

        bloqueMovimiento.invertirMovimiento();
        assertNotEquals(derechaDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test10BloqueMovimientoTieneMovimientoIzquierdaDibujandoYSeInvierteADerecha(){
        Dibuja estado = new Dibuja();
        Izquierda izquierdaDibuja = new Izquierda(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(izquierdaDibuja);

        bloqueMovimiento.invertirMovimiento();
        assertNotEquals(izquierdaDibuja,bloqueMovimiento.obtenerMovimiento());
    }

    @Test
    public void test11BloqueMovimientoTieneMovimientoAbajoDibujandoYSeInvierteArriba(){
        Dibuja estado = new Dibuja();
        Abajo abajoDibuja = new Abajo(estado);
        Arriba arribaDibuja = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoDibuja);

        bloqueMovimiento.invertirMovimiento();
        assertEquals(arribaDibuja.getClass(),bloqueMovimiento.obtenerMovimiento().getClass());
    }

    @Test
    public void test12BloqueMovimientoTieneMovimientoArribaDibujandoYSeInvierteAbajo(){
        Dibuja estado = new Dibuja();
        Arriba arribaDibuja = new Arriba(estado);
        Abajo abajoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaDibuja);

        bloqueMovimiento.invertirMovimiento();
        assertEquals(abajoDibuja.getClass(),bloqueMovimiento.obtenerMovimiento().getClass());
    }

    @Test
    public void test13SectorDibujoContieneArribaTrasEjecutarseBloqueMovimiento(){
        Dibuja estado = new Dibuja();
        Arriba arribaDibuja   = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaDibuja);
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloqueMovimiento.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerMovimientos().contains(arribaDibuja));
    }

    @Test
    public void test14SectorDibujoContieneAbajoTrasEjecutarseBloqueMovimiento(){
        Dibuja estado = new Dibuja();
        Abajo abajoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoDibuja);
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloqueMovimiento.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerMovimientos().contains(abajoDibuja));
    }

    @Test
    public void test15SectorDibujoContieneDerechaTrasEjecutarseBloqueMovimiento(){
        Dibuja estado = new Dibuja();
        Derecha derechaDibuja = new Derecha(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(derechaDibuja);
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloqueMovimiento.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerMovimientos().contains(derechaDibuja));
    }

    @Test
    public void test16SectorDibujoContieneIzquierdaTrasEjecutarseBloqueMovimiento(){
        Dibuja estado = new Dibuja();
        Izquierda izquierdaDibuja = new Izquierda(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(izquierdaDibuja);
        SectorDibujo sectorDibujo = new SectorDibujo();

        bloqueMovimiento.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.obtenerMovimientos().contains(izquierdaDibuja));
    }
}
