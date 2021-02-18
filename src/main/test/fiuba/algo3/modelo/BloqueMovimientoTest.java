package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;

import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.bloques.NoDibuja;
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
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(1, 0);

        bloqueEste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, destino));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test02EjecutarUnBloqueMovimientoHaciaElOeste() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(-1, 0);

        bloqueOeste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, destino));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test03EjecutarUnBloqueMovimientoHaciaElNorte() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        bloqueNorte.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existeArista(destino, origen));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test04EjecutarUnBloqueMovimientoHaciaElSur() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, -1);

        bloqueSur.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existeArista(destino, origen));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test05EjecutarCincoBloquesMovimientoHaciaElEste() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(1, 0);
        Posicion puntoIntermedio2 = new Posicion(2, 0);
        Posicion puntoIntermedio3 = new Posicion(3, 0);
        Posicion puntoIntermedio4 = new Posicion(4, 0);
        Posicion destino = new Posicion(5, 0);

        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertTrue(sectorDibujo.existePosicion(origen));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio1));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio2));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio3));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio4));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test06EjecutarCincoBloquesMovimientoHaciaElEsteNoExisteAristaEntreOrigenYDestino() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(5, 0);

        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));

        assertTrue(sectorDibujo.existePosicion(origen));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test07EjecutarCincoBloqueMovimientoHaciaElOeste() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(-1, 0);
        Posicion puntoIntermedio2 = new Posicion(-2, 0);
        Posicion puntoIntermedio3 = new Posicion(-3, 0);
        Posicion puntoIntermedio4 = new Posicion(-4, 0);
        Posicion destino = new Posicion(-5, 0);

        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertTrue(sectorDibujo.existePosicion(origen));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio1));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio2));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio3));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio4));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test08EjecutarCincoBloqueMovimientoHaciaElNorte() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(0, 1);
        Posicion puntoIntermedio2 = new Posicion(0, 2);
        Posicion puntoIntermedio3 = new Posicion(0, 3);
        Posicion puntoIntermedio4 = new Posicion(0, 4);
        Posicion destino = new Posicion(0, 5);

        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertTrue(sectorDibujo.existePosicion(origen));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio1));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio2));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio3));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio4));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test09EjecutarCincoBloqueMovimientoHaciaElSur() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(0, -1);
        Posicion puntoIntermedio2 = new Posicion(0, -2);
        Posicion puntoIntermedio3 = new Posicion(0, -3);
        Posicion puntoIntermedio4 = new Posicion(0, -4);
        Posicion destino = new Posicion(0, -5);

        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertTrue(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertTrue(sectorDibujo.existePosicion(origen));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio1));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio2));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio3));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedio4));
        assertTrue(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test10EjecutarCincoBloquesDeMovimientoHaciaCadaDireccion() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();

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
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 4)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 5)));

        // 5 veces hacia el este
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 5)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 5)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(3, 5)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(4, 5)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(5, 5)));

        // 5 veces hacia el sur
        assertTrue(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(5, 3)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(5, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(5, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(5, 0)));

        // 5 veces hacia el oeste
        assertTrue(sectorDibujo.existePosicion(new Posicion(4, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(3, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 0)));
    }

    @Test
    public void test11EjecutarUnBloqueDeMovimientoHaciaElNorteInvertido() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueNorte.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, -1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 1)));
    }

    @Test
    public void test12EjecutarUnBloqueDeMovimientoHaciaElSurInvertido() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueSur.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, -1)));
    }

    @Test
    public void test13EjecutarUnBloqueDeMovimientoHaciaElEsteInvertido() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueEste.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(-1, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test14EjecutarUnBloqueDeMovimientoHaciaElOesteInvertido() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueOeste.ejecutarInvertido(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(-1, 0)));
    }


    @Test
    public void test15EjecutarUnBloqueMovimientoQueNoDibujaHaciaElEste() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(1, 0);

        bloqueEste.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test16EjecutarUnBloqueMovimientoQueNoDibujaHaciaElOeste() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(-1, 0);

        bloqueOeste.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test17EjecutarUnBloqueMovimientoQueNoDibujaHaciaElNorte() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        bloqueNorte.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existeArista(destino, origen));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test18EjecutarUnBloqueMovimientoQueNoDibujaHaciaElSur() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, -1);

        bloqueSur.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existeArista(destino, origen));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test19EjecutarCincoBloquesMovimientoQueNoDibujaHaciaElEste() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(1, 0);
        Posicion puntoIntermedio2 = new Posicion(2, 0);
        Posicion puntoIntermedio3 = new Posicion(3, 0);
        Posicion puntoIntermedio4 = new Posicion(4, 0);
        Posicion destino = new Posicion(5, 0);

        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertFalse(sectorDibujo.existePosicion(puntoIntermedio1));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio2));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio3));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio4));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test20EjecutarCincoBloquesMovimientoQueNoDibujaHaciaElEsteNoExisteAristaEntreOrigenYDestino() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(5, 0);

        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);
        bloqueEste.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test21EjecutarCincoBloqueMovimientoQueNoDibujaHaciaElOeste() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(-1, 0);
        Posicion puntoIntermedio2 = new Posicion(-2, 0);
        Posicion puntoIntermedio3 = new Posicion(-3, 0);
        Posicion puntoIntermedio4 = new Posicion(-4, 0);
        Posicion destino = new Posicion(-5, 0);

        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);
        bloqueOeste.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertFalse(sectorDibujo.existePosicion(puntoIntermedio1));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio2));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio3));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio4));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test22EjecutarCincoBloqueMovimientoQueNoDibujaHaciaElNorte() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(0, 1);
        Posicion puntoIntermedio2 = new Posicion(0, 2);
        Posicion puntoIntermedio3 = new Posicion(0, 3);
        Posicion puntoIntermedio4 = new Posicion(0, 4);
        Posicion destino = new Posicion(0, 5);

        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);
        bloqueNorte.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertFalse(sectorDibujo.existePosicion(puntoIntermedio1));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio2));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio3));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio4));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test23EjecutarCincoBloqueMovimientoQueNoDibujaHaciaElSur() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedio1 = new Posicion(0, -1);
        Posicion puntoIntermedio2 = new Posicion(0, -2);
        Posicion puntoIntermedio3 = new Posicion(0, -3);
        Posicion puntoIntermedio4 = new Posicion(0, -4);
        Posicion destino = new Posicion(0, -5);

        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);
        bloqueSur.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existeArista(origen, puntoIntermedio1));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio1, puntoIntermedio2));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio2, puntoIntermedio3));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio3, puntoIntermedio4));
        assertFalse(sectorDibujo.existeArista(puntoIntermedio4, destino));

        assertFalse(sectorDibujo.existePosicion(puntoIntermedio1));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio2));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio3));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedio4));
        assertFalse(sectorDibujo.existePosicion(destino));
    }

    @Test
    public void test24EjecutarCincoBloquesDeMovimientoHaciaCadaDireccion() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new NoDibuja());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new NoDibuja());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new NoDibuja());
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();

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
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 5)));

        // 5 veces hacia el este
        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 5)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 5)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 5)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 5)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 5)));

        // 5 veces hacia el sur
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 4)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 3)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 2)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(5, 0)));

        // 5 veces hacia el oeste
        assertFalse(sectorDibujo.existePosicion(new Posicion(4, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(3, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(2, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test25EjecutarUnBloqueDeMovimientoHaciaElNorteInvertido() {
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueNorte.ejecutarInvertido(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(0, -1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 1)));
    }

    @Test
    public void test26EjecutarUnBloqueDeMovimientoHaciaElSurInvertido() {
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueSur.ejecutarInvertido(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(0, -1)));
    }

    @Test
    public void test27EjecutarUnBloqueDeMovimientoHaciaElEsteInvertido() {
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueEste.ejecutarInvertido(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(-1, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test28EjecutarUnBloqueDeMovimientoHaciaElOesteInvertido() {
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new NoDibuja());
        SectorDibujo sectorDibujo = new SectorDibujo();
        bloqueOeste.ejecutarInvertido(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
        assertFalse(sectorDibujo.existePosicion(new Posicion(-1, 0)));
    }
}