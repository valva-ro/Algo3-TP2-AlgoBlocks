package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Recorrido;
import fiuba.algo3.modelo.direcciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecorridoTest {
    @Test
    public void test01PrimerTramoDelRecorridoComienzaEnElCero(){
        Recorrido recorrido = new Recorrido();
        Posicion origen = new Posicion();
        Posicion destino = new Posicion();

        assertTrue(recorrido.existeArista(origen,destino));
    }

    @Test
    public void test02AlAgregarDireccionHacialNorteElFinalEstaEnEsaDireccion(){
        Recorrido recorrido = new Recorrido();
        Norte direccionNorte = new Norte();
        Posicion origen = new Posicion();
        Posicion destinoNorte = new Posicion(0,1);

        recorrido.agregarArista(direccionNorte,origen);

        assertTrue(recorrido.existeArista(origen, destinoNorte));
    }

    @Test
    public void test03AlAgregarDireccionHaciaElSurElFinalEstaEnEsaDireccion(){
        Recorrido recorrido = new Recorrido();
        Sur direccionSur = new Sur();
        Posicion origen = new Posicion();
        Posicion destinoSur = new Posicion(0,-1);

        recorrido.agregarArista(direccionSur,origen);

        assertTrue(recorrido.existeArista(origen, destinoSur));
    }

    @Test
    public void test04AlAgregarDireccionHaciaElEsteElFinalEstaEnEsaDireccion(){
        Recorrido recorrido = new Recorrido();
        Este direccionEste = new Este();
        Posicion origen = new Posicion();
        Posicion destinoEste = new Posicion(1,0);

        recorrido.agregarArista(direccionEste,origen);

        assertTrue(recorrido.existeArista(origen, destinoEste));
    }

    @Test
    public void test05AlAgregarDireccionHaciaElOesteElFinalEstaEnEsaDireccion(){
        Recorrido recorrido = new Recorrido();
        Oeste direccionOeste = new Oeste();
        Posicion origen = new Posicion();
        Posicion destinoOeste = new Posicion(-1,0);

        recorrido.agregarArista(direccionOeste,origen);

        assertTrue(recorrido.existeArista(origen, destinoOeste));
    }

    @Test
    public void test06AlAgregar5DireccionesHaciaElNorteElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Norte direccionNorte = new Norte();
        Posicion origen = new Posicion();
        Posicion destinoNorte = new Posicion(0,5);

        for (int i = 0; i < 5; i++) {
            recorrido.agregarArista(direccionNorte,origen);
            origen = direccionNorte.actualizarPosicion(origen);
        }

        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoNorte));
    }

    @Test
    public void test07AlAgregar5DireccionesHaciaElSurElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Sur direccionSur = new Sur();
        Posicion origen = new Posicion();
        Posicion destinoSur = new Posicion(0,-5);

        for (int i = 0; i < 5; i++) {
            recorrido.agregarArista(direccionSur,origen);
            origen = direccionSur.actualizarPosicion(origen);
        }

        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoSur));
    }

    @Test
    public void test08AlAgregar5DireccionesHaciaElEsteElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Este direccionEste = new Este();
        Posicion origen = new Posicion();
        Posicion destinoEste = new Posicion(5,0);

        for (int i = 0; i < 5; i++) {
            recorrido.agregarArista(direccionEste,origen);
            origen = direccionEste.actualizarPosicion(origen);
        }

        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoEste));
    }

    @Test
    public void test09AlAgregar5DireccionesHaciaElOesteElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Oeste direccionOeste = new Oeste();
        Posicion origen = new Posicion();
        Posicion destinoOeste = new Posicion(-5,0);

        for (int i = 0; i < 5; i++) {
            recorrido.agregarArista(direccionOeste,origen);
            origen = direccionOeste.actualizarPosicion(origen);
        }

        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoOeste));
    }

    @Test
    public void test10AlAgregar4DireccionesDistintasElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Posicion origen = new Posicion();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        Posicion destinoFinal = new Posicion(0,0);

        direcciones.add(new Norte());
        direcciones.add(new Sur());
        direcciones.add(new Este());
        direcciones.add(new Oeste());

        for (int i = 0; i < 4; i++) {
            recorrido.agregarArista(direcciones.get(i),origen);
            origen = direcciones.get(i).actualizarPosicion(origen);
        }


        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoFinal));
    }

    @Test
    public void test11AlAgregar12DireccionesDistintasElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Posicion origen = new Posicion();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        Posicion destinoFinal = new Posicion(2,2);

        direcciones.add(new Norte());
        direcciones.add(new Norte());
        direcciones.add(new Norte());
        direcciones.add(new Norte());
        direcciones.add(new Sur());
        direcciones.add(new Sur());
        direcciones.add(new Este());
        direcciones.add(new Este());
        direcciones.add(new Este());
        direcciones.add(new Este());
        direcciones.add(new Oeste());
        direcciones.add(new Oeste());

        for (int i = 0; i < 12; i++) {
            recorrido.agregarArista(direcciones.get(i),origen);
            origen = direcciones.get(i).actualizarPosicion(origen);
        }


        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoFinal));
    }

    @Test
    public void test12AlAgregar13DireccionesDistintasElVerticeFinalContieneElDestino(){
        Recorrido recorrido = new Recorrido();
        Posicion origen = new Posicion();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        Posicion destinoFinal = new Posicion(5,6);

        for (int i = 0; i < 6; i++) {
            direcciones.add(new Norte());
            direcciones.add(new Este());
        }
        direcciones.add(new Oeste());

        for (int i = 0; i < 13; i++) {
            recorrido.agregarArista(direcciones.get(i),origen);
            origen = direcciones.get(i).actualizarPosicion(origen);
        }


        assertTrue(recorrido.obtenerUltimoVertice().esIgual(destinoFinal));
    }

}
