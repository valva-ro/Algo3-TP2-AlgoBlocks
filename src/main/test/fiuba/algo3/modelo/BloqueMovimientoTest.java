package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;

import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Sur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueMovimientoTest {
    @Test
    public void test01EjecutarUnBloqueMovimientoHaciaElEste() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueEste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(1, 0)));
    }

    @Test
    public void test02EjecutarUnBloqueMovimientoHaciaElOeste() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueOeste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(-1, 0)));
    }

    @Test
    public void test03EjecutarUnBloqueMovimientoHaciaElNorte() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueNorte.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
    }

    @Test
    public void test04EjecutarUnBloqueMovimientoHaciaElSur() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueSur.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, -1)));
    }

    @Test
    public void test05EjecutarCincoBloquesMovimientoHaciaElEste() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(2, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(3, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(4, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(5, 0)));
    }

    @Test
    public void test06EjecutarCincoBloqueMovimientoHaciaElOeste() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(-1, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(-2, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(-3, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(-4, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(-5, 0)));
    }

    @Test
    public void test07EjecutarCincoBloqueMovimientoHaciaElNorte() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 4)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 5)));
    }

    @Test
    public void test08EjecutarCincoBloqueMovimientoHaciaElSur() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, -1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, -2)));
        assertTrue(sectorDibujo.existe(new Posicion(0, -3)));
        assertTrue(sectorDibujo.existe(new Posicion(0, -4)));
        assertTrue(sectorDibujo.existe(new Posicion(0, -5)));
    }

    @Test
    public void test09EjecutarCincoBloquesDeMovimientoHaciaCadaDireccion() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();

        for (int i = 0; i < 5; i++) {
            bloqueNorte.ejecutar(sectorDibujo);
        }
        for (int i = 0; i < 5; i++) {
            bloqueEste.ejecutar(sectorDibujo);
        }
        for (int i = 0; i < 5; i++) {
            bloqueSur.ejecutar(sectorDibujo);
        }
        for (int i = 0; i < 5; i++) {
            bloqueOeste.ejecutar(sectorDibujo);
        }

        // 5 veces hacia el norte
        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 4)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 5)));

        // 5 veces hacia el este
        assertTrue(sectorDibujo.existe(new Posicion(1, 5)));
        assertTrue(sectorDibujo.existe(new Posicion(2, 5)));
        assertTrue(sectorDibujo.existe(new Posicion(3, 5)));
        assertTrue(sectorDibujo.existe(new Posicion(4, 5)));
        assertTrue(sectorDibujo.existe(new Posicion(5, 5)));

        // 5 veces hacia el sur
        assertTrue(sectorDibujo.existe(new Posicion(5, 4)));
        assertTrue(sectorDibujo.existe(new Posicion(5, 3)));
        assertTrue(sectorDibujo.existe(new Posicion(5, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(5, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(5, 0)));

        // 5 veces hacia el oeste
        assertTrue(sectorDibujo.existe(new Posicion(4, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(3, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(2, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 0)));
    }

    @Test
    public void test10EjecutarUnBloqueDeMovimientoHaciaElNorteInvertido() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueNorte.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, -1)));
        assertFalse(sectorDibujo.existe(new Posicion(0, 1)));
    }

    @Test
    public void test11EjecutarUnBloqueDeMovimientoHaciaElSurInvertido() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueSur.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertFalse(sectorDibujo.existe(new Posicion(0, -1)));
    }

    @Test
    public void test12EjecutarUnBloqueDeMovimientoHaciaElEsteInvertido() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueEste.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(-1, 0)));
        assertFalse(sectorDibujo.existe(new Posicion(1, 0)));
    }

    @Test
    public void test13EjecutarUnBloqueDeMovimientoHaciaElOesteInvertido() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.invertirDibuja();
        bloqueOeste.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(1, 0)));
        assertFalse(sectorDibujo.existe(new Posicion(-1, 0)));
    }
}