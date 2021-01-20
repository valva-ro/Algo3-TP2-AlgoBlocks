package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.bloques.NoDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Izquierda;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FabricaAbstractaTest {

    @Test
    public void test01FabricaNoDibujaCreaBloqueMovimientoDerecha(){

        NoDibuja estado       = new NoDibuja();
        Derecha derechaNoDibuja   = new Derecha(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(derechaNoDibuja);

        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(fabricaNoDibuja.crearBloqueMovimientoDerecha().getClass(),bloqueMovimiento.getClass());

       // assertEquals(fabricaNoDibuja.crearBloqueMovimientoDerecha().obtenerMovimiento().getClass(),bloqueMovimiento.obtenerMovimiento().getClass());

    }

    @Test
    public void test02FabricaNoDibujaCreaBloqueMovimientoIzquierda(){

        NoDibuja estado       = new NoDibuja();
        Izquierda izquierdaNoDibuja       = new Izquierda(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(izquierdaNoDibuja);

        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(fabricaNoDibuja.crearBloqueMovimientoIzquierda().getClass(),bloqueMovimiento.getClass());

    }

    @Test
    public void test03FabricaNoDibujaCreaBloqueMovimientoArriba(){

        NoDibuja estado = new NoDibuja();
        Arriba arribaNoDibuja = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaNoDibuja);


        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(fabricaNoDibuja.crearBloqueMovimientoArriba().getClass(),bloqueMovimiento.getClass());

    }

    @Test
    public void test04FabricaNoDibujaCreaBloqueMovimientoAbajo(){

        NoDibuja estado = new NoDibuja();
        Abajo abajoNoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoNoDibuja);

        FabricaConcretaBloqueQueNoDibuja fabricaNoDibuja = new FabricaConcretaBloqueQueNoDibuja();

        assertEquals(fabricaNoDibuja.crearBloqueMovimientoIzquierda().getClass(),bloqueMovimiento.getClass());

    }

    @Test
    public void test05FabricaDibujaCreaBloqueMovimientoDerecha(){

        Dibuja estado       = new Dibuja();
        Derecha derechaDibuja   = new Derecha(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(derechaDibuja);

        FabricaConcretaBloqueQueDibuja fabricaDibuja = new FabricaConcretaBloqueQueDibuja();

        assertEquals(fabricaDibuja.crearBloqueMovimientoDerecha().getClass(),bloqueMovimiento.getClass());

        // assertEquals(fabricaNoDibuja.crearBloqueMovimientoDerecha().obtenerMovimiento().getClass(),bloqueMovimiento.obtenerMovimiento().getClass());

    }

    @Test
    public void test06FabricaNoDibujaCreaBloqueMovimientoIzquierda(){

        Dibuja estado       = new Dibuja();
        Izquierda izquierdaDibuja       = new Izquierda(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(izquierdaDibuja);

        FabricaConcretaBloqueQueDibuja fabricaDibuja = new FabricaConcretaBloqueQueDibuja();

        assertEquals(fabricaDibuja.crearBloqueMovimientoIzquierda().getClass(),bloqueMovimiento.getClass());


    }

    @Test
    public void test07FabricaNoDibujaCreaBloqueMovimientoArriba(){

        Dibuja estado = new Dibuja();
        Arriba arribaDibuja = new Arriba(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(arribaDibuja);

        FabricaConcretaBloqueQueDibuja fabricaDibuja = new FabricaConcretaBloqueQueDibuja();

        assertEquals(fabricaDibuja.crearBloqueMovimientoArriba().getClass(),bloqueMovimiento.getClass());


    }

    @Test
    public void test08FabricaNoDibujaCreaBloqueMovimientoAbajo(){

        Dibuja estado = new Dibuja();
        Abajo abajoDibuja = new Abajo(estado);
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(abajoDibuja);

        FabricaConcretaBloqueQueDibuja fabricaDibuja = new FabricaConcretaBloqueQueDibuja();

        assertEquals(fabricaDibuja.crearBloqueMovimientoAbajo().getClass(),bloqueMovimiento.getClass());


    }
}
