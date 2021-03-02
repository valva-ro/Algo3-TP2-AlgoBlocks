package fiuba.algo3.modelo;

import fiuba.algo3.modelo.dibujo.Recorrido;
import fiuba.algo3.modelo.direcciones.Direccion;

public class SectorDibujo implements DibujoObservable{

    private Recorrido recorrido = new Recorrido();
    private Posicion posicionFinal = new Posicion();
    private ObservadorDibujo observador;

    public void dibujar(Direccion direccion) {
        Posicion unaPosicion = this.recorrido.agregarArista(direccion, posicionFinal);
        observador.actualizar(true,posicionFinal,unaPosicion);
        posicionFinal = unaPosicion;

    }

    public void noDibujar(Direccion direccion) {
        Posicion unaPosicion = direccion.actualizarPosicion(posicionFinal);
        observador.actualizar(false, posicionFinal, unaPosicion);
        posicionFinal = unaPosicion;
    }

    public boolean existePosicion(Posicion posicion) {
        return this.recorrido.existeVertice(posicion);
    }

    public boolean existeArista(Posicion origen, Posicion destino) {
        return this.recorrido.existeArista(origen, destino);
    }

    @Override
    public void notificarObservador(Boolean bool, Posicion posicionInicial, Posicion posicionFinal) {
        observador.actualizar(bool, posicionInicial, posicionInicial);
    }

    @Override
    public void agregarObservador(ObservadorDibujo obs) {
        this.observador = obs;
    }
}