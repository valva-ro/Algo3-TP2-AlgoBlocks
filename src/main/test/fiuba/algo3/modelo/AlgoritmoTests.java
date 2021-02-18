package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Sur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTests {

    @Test
    public void test01NoSePuedeEjecutarUnAlgoritmoQueNoTieneBloques() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));
    }

    @Test
    public void test02SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElNorteYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new NoDibuja());

        algoritmo.agregar(bloqueNorte);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(0, 1)));
    }

    @Test
    public void test03SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        algoritmo.agregar(bloqueNorte);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
    }

    @Test
    public void test04SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElSurYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Sur(), new NoDibuja());

        algoritmo.agregar(bloqueNorte);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(0, -1)));
    }

    @Test
    public void test05SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElSurYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        algoritmo.agregar(bloqueSur);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, -1)));
    }

    @Test
    public void test06SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElEsteYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Norte(), new Dibuja());

        algoritmo.agregar(bloqueSur);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test07SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElEsteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        algoritmo.agregar(bloqueEste);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0)));
    }

    @Test
    public void test06SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElOesteYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new NoDibuja());

        algoritmo.agregar(bloqueOeste);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existePosicion(new Posicion(-1, 0)));
    }

    @Test
    public void test09SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElOesteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        algoritmo.agregar(bloqueOeste);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(-1, 0)));
    }

    @Test
    public void test10SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaCadaDireccionYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());
        algoritmo.agregar(bloqueNorte);
        algoritmo.agregar(bloqueEste);
        algoritmo.agregar(bloqueSur);
        algoritmo.agregar(bloqueOeste);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1))); // Norte
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 1))); // Este
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 0))); // Sur
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 0))); // Oeste
    }

    @Test
    public void test11SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionDobleQueTieneDosBloquesHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirDosVeces bloqueRepeticionDoble = new BloqueRepetirDosVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        bloqueRepeticionDoble.agregar(bloqueNorte);
        bloqueRepeticionDoble.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionDoble);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 4)));
    }

    @Test
    public void test12SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionDobleQueTieneDosBloquesHaciaElNorteDosHaciaElEsteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirDosVeces bloqueRepeticionDoble = new BloqueRepetirDosVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());

        bloqueRepeticionDoble.agregar(bloqueNorte);
        bloqueRepeticionDoble.agregar(bloqueNorte);
        bloqueRepeticionDoble.agregar(bloqueEste);
        bloqueRepeticionDoble.agregar(bloqueEste);
        algoritmo.agregar(bloqueRepeticionDoble);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(1, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 3)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(2, 4)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(3, 4)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(4, 4)));
    }

    @Test
    public void test13SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionTripkeQueTieneUnBloqueHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirTresVeces bloqueRepeticionTriple = new BloqueRepetirTresVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        bloqueRepeticionTriple.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionTriple);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 3)));
    }

    @Test
    public void test14SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionTripkeQueTieneDosBloquesHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirTresVeces bloqueRepeticionTriple = new BloqueRepetirTresVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        bloqueRepeticionTriple.agregar(bloqueNorte);
        bloqueRepeticionTriple.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionTriple);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 4)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 5)));
        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 6)));
    }

    @Test
    public void test15AlAgregarYSacarUnBloqueHaciaElNorteAntesDeEjecutaNoSeDibujaNada(){

        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        algoritmo.agregar(bloqueNorte);
        algoritmo.sacar(bloqueNorte);

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existeArista(origen, destino));
        assertFalse(sectorDibujo.existePosicion(destino));
        assertTrue(sectorDibujo.existePosicion(origen));
    }

    @Test
    public void test16AlAgregarDosBloquesHaciaElNorteYSacarUnoSoloAntesDeEjecutaSeDibujaUnaSolaArista(){

        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion primerDestino = new Posicion(0, 1);
        Posicion segundoDestino = new Posicion(0, 2);
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        algoritmo.agregar(bloqueNorte);
        algoritmo.agregar(bloqueNorte);
        algoritmo.sacar(bloqueNorte);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, primerDestino));
        assertTrue(sectorDibujo.existePosicion(primerDestino));
        assertTrue(sectorDibujo.existePosicion(origen));

        assertFalse(sectorDibujo.existeArista(origen, segundoDestino));
        assertFalse(sectorDibujo.existeArista(primerDestino, segundoDestino));
        assertFalse(sectorDibujo.existePosicion(segundoDestino));
    }

    @Test
    public void test17AlAgregarDosBloquesHaciaElNorteYSacarUnoSoloAntesDeEjecutaSeDibujaUnaSolaArista(){

        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Posicion origen = new Posicion(0, 0);
        Posicion primerDestino = new Posicion(0, 1);
        Posicion segundoDestino = new Posicion(0, 2);
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());

        algoritmo.agregar(bloqueNorte);
        algoritmo.agregar(bloqueNorte);
        algoritmo.sacar(bloqueNorte);
        algoritmo.sacar(bloqueNorte);

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existeArista(origen, primerDestino));
        assertFalse(sectorDibujo.existeArista(primerDestino, segundoDestino));
        assertFalse(sectorDibujo.existeArista(origen, segundoDestino));

        assertTrue(sectorDibujo.existePosicion(origen));
        assertFalse(sectorDibujo.existePosicion(primerDestino));
        assertFalse(sectorDibujo.existePosicion(segundoDestino));
    }

    @Test
    public void test18AlAgregarYSacarVariosBloquesMenosUnoAntesDeEjecutaNoSeDibujaNada(){

        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();

        Posicion origen = new Posicion(0, 0);
        Posicion puntoIntermedioOrigenNorte = new Posicion(0, 1);
        Posicion puntoIntermedioNorteEste = new Posicion(1, 1);
        Posicion puntoIntermedioEsteSur = new Posicion(1, 0);
        Posicion destinoSurOeste = new Posicion(0, 0);

        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur(), new Dibuja());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este(), new Dibuja());
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste(), new Dibuja());

        algoritmo.agregar(bloqueNorte);
        algoritmo.agregar(bloqueEste);
        algoritmo.agregar(bloqueSur);
        algoritmo.agregar(bloqueOeste);

        algoritmo.sacar(bloqueSur);
        algoritmo.sacar(bloqueEste);
        algoritmo.sacar(bloqueOeste);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existeArista(origen, puntoIntermedioOrigenNorte));
        assertTrue(sectorDibujo.existePosicion(puntoIntermedioOrigenNorte));
        assertTrue(sectorDibujo.existePosicion(origen));

        assertFalse(sectorDibujo.existeArista(puntoIntermedioNorteEste, puntoIntermedioEsteSur));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedioEsteSur));

        assertFalse(sectorDibujo.existeArista(puntoIntermedioEsteSur, destinoSurOeste));
        assertFalse(sectorDibujo.existePosicion(puntoIntermedioEsteSur));
    }

    @Test
    public void test19AlAgregarUnBloqueDeRepeticionTripleConUnBloqueDeMovimientoHaciaArribaYSacarElBloqueDeRepeticionElAlgoritmoNoPuedeEjecutarse() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirTresVeces bloqueRepeticionTriple = new BloqueRepetirTresVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        Posicion origen = new Posicion(0, 0);
        Posicion primerDestino = new Posicion(0, 1);
        Posicion segundoDestino = new Posicion(0, 2);
        Posicion tercerDestino = new Posicion(0, 3);

        bloqueRepeticionTriple.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionTriple);
        algoritmo.sacar(bloqueRepeticionTriple);

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existeArista(origen, primerDestino));
        assertFalse(sectorDibujo.existeArista(primerDestino, segundoDestino));
        assertFalse(sectorDibujo.existeArista(segundoDestino, tercerDestino));
        assertFalse(sectorDibujo.existeArista(origen, tercerDestino));
    }

    @Test
    public void test20AlAgregarUnBloqueDeRepeticionDobleConUnBloqueDeMovimientoHaciaArribaYSacarElBloqueDeRepeticionElAlgoritmoNoPuedeEjecutarse() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirDosVeces bloqueRepeticionDoble = new BloqueRepetirDosVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        Posicion origen = new Posicion(0, 0);
        Posicion primerDestino = new Posicion(0, 1);
        Posicion segundoDestino = new Posicion(0, 2);

        bloqueRepeticionDoble.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionDoble);
        algoritmo.sacar(bloqueRepeticionDoble);

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existeArista(origen, primerDestino));
        assertFalse(sectorDibujo.existeArista(primerDestino, segundoDestino));
        assertFalse(sectorDibujo.existeArista(origen, segundoDestino));
    }

    @Test
    public void test21AlAgregarUnBloquePersonalizadoConUnBloqueDeMovimientoHaciaArribaYSacarElBloquePersonalizadoElAlgoritmoNoPuedeEjecutarse() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, 1);

        bloquePersonalizado.agregar(bloqueNorte);
        algoritmo.agregar(bloquePersonalizado);
        algoritmo.sacar(bloquePersonalizado);

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }

    @Test
    public void test22AlAgregarUnBloqueInvertirConUnBloqueDeMovimientoHaciaArribaYSacarElBloqueDeInvertirElAlgoritmoNoPuedeEjecutarse() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte(), new Dibuja());
        Posicion origen = new Posicion(0, 0);
        Posicion destino = new Posicion(0, -1);

        bloqueInvertir.agregar(bloqueNorte);
        algoritmo.agregar(bloqueInvertir);
        algoritmo.sacar(bloqueInvertir);

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> algoritmo.ejecutar(sectorDibujo));

        assertFalse(sectorDibujo.existeArista(origen, destino));
    }
}