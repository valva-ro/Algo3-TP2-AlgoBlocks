package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.Bloque;
import fiuba.algo3.modelo.bloques.BloquePersonalizadoNoPuedeEjecutarseSinBloquesError;

import java.util.ArrayList;

public class Algoritmo implements Observable {

    private ArrayList<Bloque> bloques = new ArrayList<>();
    private ArrayList<Observador> observadores = new ArrayList<>();

    public void agregar(Bloque bloque) {
        bloques.add(bloque);
        this.notificarObservadores();
    }

    public void sacar(Bloque bloque) {
        bloques.remove(bloque);
        this.notificarObservadores();
    }

    public void ejecutar(SectorDibujo sectorDibujo) throws BloquePersonalizadoNoPuedeEjecutarseSinBloquesError, AlgoritmoNoTieneBloquesError {
        if (bloques.size() == 0) {
            throw new AlgoritmoNoTieneBloquesError();
        }
        for (Bloque bloque : bloques) {
            bloque.ejecutar(sectorDibujo);
        }
        this.notificarObservadores();
    }

    public Bloque[] obtenerBloques() throws AlgoritmoNoTieneBloquesError {
        if (bloques.isEmpty())
            throw new AlgoritmoNoTieneBloquesError();
        return bloques.toArray(new Bloque[0]);
    }

    public void vaciar() {
        this.bloques = new ArrayList<>();
        this.notificarObservadores();
    }

    public boolean estaVacio() {
        return this.bloques.isEmpty();
    }

    @Override
    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    @Override
    public void sacarObservador(Observador obs) {
        observadores.remove(obs);
    }

    @Override
    public void notificarObservadores() {
        for (Observador obs : observadores) obs.actualizar();
    }
}