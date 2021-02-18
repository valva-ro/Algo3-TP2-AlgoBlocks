package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direcciones.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SectorDibujoTests {
    @Test
    public void test01SectorDibujoInicialmenteTieneSoloUnBucleEnX0Y0() {
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertTrue(sectorDibujo.existePosicion(new Posicion(0, 0)));

        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                if (i != 0 && j != 0)
                    assertFalse(sectorDibujo.existePosicion(new Posicion(i, j)));
            }
        }
    }

    @Test
    public void test02SeEjecutaElSectorDibujoConUnaDireccionParaQueDibujeEntoncesQuedaGuardadaLaAristaEnElDibujo() {

        Norte norte = new Norte();
        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.dibujar(norte);

        Posicion origen = new Posicion();
        Posicion destino = norte.actualizarPosicion(origen);

        assertTrue(sectorDibujo.existeArista(origen, destino));

    }

    @Test
    public void test03SeEjecutaElSectorDibujoConDosDireccionesDistintasParaQueDibujenEntoncesQuedanLasDosAristasGuardadas() {

        Norte direccionNorte = new Norte();
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.dibujar(direccionNorte);

        Posicion posicionInicial = new Posicion();
        Posicion posicionIntermedia = direccionNorte.actualizarPosicion(posicionInicial);

        Este direccionEste = new Este();

        sectorDibujo.dibujar(direccionEste);

        Posicion posicionFinal = direccionEste.actualizarPosicion(posicionIntermedia);

        assertTrue(sectorDibujo.existeArista(posicionInicial,posicionIntermedia));
        assertTrue(sectorDibujo.existeArista(posicionIntermedia,posicionFinal));

    }

    @Test
    public void test04ElSectorDibujoGuardaLasPosicionesDeTodasLasDireccionesSiSeEjecutaParaDibujarSinImportarElOrden() {

        Norte direccionNorte = new Norte();
        Sur direccionSur = new Sur();
        Este direccionEste = new Este();
        Oeste direccionOeste = new Oeste();

        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.dibujar(direccionSur);
        sectorDibujo.dibujar(direccionEste);
        sectorDibujo.dibujar(direccionNorte);
        sectorDibujo.dibujar(direccionOeste);

        Posicion posicionInicial = new Posicion();
        Posicion primerDesplazamiento = direccionSur.actualizarPosicion(posicionInicial);
        Posicion segundoDesplazamiento = direccionEste.actualizarPosicion(primerDesplazamiento);
        Posicion tercerDesplazamiento = direccionNorte.actualizarPosicion(segundoDesplazamiento);
        Posicion cuartoDesplazamiento = direccionOeste.actualizarPosicion(tercerDesplazamiento);

        assertTrue(sectorDibujo.existeArista(posicionInicial,primerDesplazamiento));
        assertTrue(sectorDibujo.existeArista(primerDesplazamiento,segundoDesplazamiento));
        assertTrue(sectorDibujo.existeArista(segundoDesplazamiento,tercerDesplazamiento));
        assertTrue(sectorDibujo.existeArista(tercerDesplazamiento,cuartoDesplazamiento));

    }

    @Test
    public void test05SeEjecutaElSectorDibujoConUnaDireccionParaQueNoDibujeEntoncesNoGuardaLaArista(){

        Norte direccionNorte = new Norte();

        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.noDibujar(direccionNorte);

        Posicion posicionInicial = new Posicion();
        Posicion posicionFinal = direccionNorte.actualizarPosicion(posicionInicial);

        assertFalse(sectorDibujo.existeArista(posicionInicial,posicionFinal));

    }

    @Test
    public void test06SeEjecutaElSectorDibujoConTodasLasDireccionesPosiblesParaQueNoDibujeEntoncesNoGuardaNingua(){

        Norte direccionNorte = new Norte();
        Sur direccionSur = new Sur();
        Este direccionEste = new Este();
        Oeste direccionOeste = new Oeste();

        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.noDibujar(direccionSur);
        sectorDibujo.noDibujar(direccionEste);
        sectorDibujo.noDibujar(direccionNorte);
        sectorDibujo.noDibujar(direccionOeste);

        Posicion posicionInicial = new Posicion();
        Posicion primerDesplazamiento = direccionSur.actualizarPosicion(posicionInicial);
        Posicion segundoDesplazamiento = direccionEste.actualizarPosicion(primerDesplazamiento);
        Posicion tercerDesplazamiento = direccionNorte.actualizarPosicion(segundoDesplazamiento);
        Posicion cuartoDesplazamiento = direccionOeste.actualizarPosicion(tercerDesplazamiento);

        assertFalse(sectorDibujo.existeArista(posicionInicial,primerDesplazamiento));
        assertFalse(sectorDibujo.existeArista(primerDesplazamiento,segundoDesplazamiento));
        assertFalse(sectorDibujo.existeArista(segundoDesplazamiento,tercerDesplazamiento));
        assertFalse(sectorDibujo.existeArista(tercerDesplazamiento,cuartoDesplazamiento));

    }

    @Test
    public void test07SeEjecutanLasDireccionesDeFormaAlternadasEnDibujarYNoDibujarYElDibujoEsElCorrecto(){

        Norte direccionNorte = new Norte();
        Sur direccionSur = new Sur();
        Este direccionEste = new Este();
        Oeste direccionOeste = new Oeste();

        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.noDibujar(direccionSur);
        sectorDibujo.dibujar(direccionEste);
        sectorDibujo.noDibujar(direccionNorte);
        sectorDibujo.dibujar(direccionOeste);

        Posicion posicionInicial = new Posicion();
        Posicion primerDesplazamiento = direccionSur.actualizarPosicion(posicionInicial);
        Posicion segundoDesplazamiento = direccionEste.actualizarPosicion(primerDesplazamiento);
        Posicion tercerDesplazamiento = direccionNorte.actualizarPosicion(segundoDesplazamiento);
        Posicion cuartoDesplazamiento = direccionOeste.actualizarPosicion(tercerDesplazamiento);

        assertFalse(sectorDibujo.existeArista(posicionInicial,primerDesplazamiento));

        assertTrue(sectorDibujo.existeArista(primerDesplazamiento,segundoDesplazamiento));

        assertFalse(sectorDibujo.existeArista(segundoDesplazamiento,tercerDesplazamiento));

        assertTrue(sectorDibujo.existeArista(tercerDesplazamiento, cuartoDesplazamiento));
    }

    @Test
    public void test08SeEjecutaElSectorDibujoConUnaDireccionEnDibujarEntreOtrasTresQueNoDibujanYElDibujoQuedaBienGuardado(){

        Norte direccionNorte = new Norte();
        Sur direccionSur = new Sur();
        Este direccionEste = new Este();
        Oeste direccionOeste = new Oeste();

        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.noDibujar(direccionSur);
        sectorDibujo.noDibujar(direccionEste);
        sectorDibujo.dibujar(direccionNorte);
        sectorDibujo.noDibujar(direccionOeste);

        Posicion posicionInicial = new Posicion();
        Posicion primerDesplazamiento = direccionSur.actualizarPosicion(posicionInicial);
        Posicion segundoDesplazamiento = direccionEste.actualizarPosicion(primerDesplazamiento);
        Posicion tercerDesplazamiento = direccionNorte.actualizarPosicion(segundoDesplazamiento);
        Posicion cuartoDesplazamiento = direccionOeste.actualizarPosicion(tercerDesplazamiento);

        assertFalse(sectorDibujo.existeArista(posicionInicial,primerDesplazamiento));

        assertFalse(sectorDibujo.existeArista(primerDesplazamiento,segundoDesplazamiento));

        assertTrue(sectorDibujo.existeArista(segundoDesplazamiento,tercerDesplazamiento));

        assertFalse(sectorDibujo.existeArista(tercerDesplazamiento, cuartoDesplazamiento));

    }

    @Test
    public void test09SeEjecutaElSectorDibujoConUnaDireccionEnNoDibujarEntreOtrasTresQueDibujanYElDibujoQuedaBienGuardado(){

        Norte direccionNorte = new Norte();
        Sur direccionSur = new Sur();
        Este direccionEste = new Este();
        Oeste direccionOeste = new Oeste();

        SectorDibujo sectorDibujo = new SectorDibujo();

        sectorDibujo.dibujar(direccionSur);
        sectorDibujo.dibujar(direccionEste);
        sectorDibujo.noDibujar(direccionNorte);
        sectorDibujo.dibujar(direccionOeste);

        Posicion posicionInicial = new Posicion();
        Posicion primerDesplazamiento = direccionSur.actualizarPosicion(posicionInicial);
        Posicion segundoDesplazamiento = direccionEste.actualizarPosicion(primerDesplazamiento);
        Posicion tercerDesplazamiento = direccionNorte.actualizarPosicion(segundoDesplazamiento);
        Posicion cuartoDesplazamiento = direccionOeste.actualizarPosicion(tercerDesplazamiento);

        assertTrue(sectorDibujo.existeArista(posicionInicial,primerDesplazamiento));

        assertTrue(sectorDibujo.existeArista(primerDesplazamiento,segundoDesplazamiento));

        assertFalse(sectorDibujo.existeArista(segundoDesplazamiento,tercerDesplazamiento));

        assertTrue(sectorDibujo.existeArista(tercerDesplazamiento, cuartoDesplazamiento));

    }
}