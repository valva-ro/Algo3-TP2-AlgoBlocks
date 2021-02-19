package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.Bloque;

import java.util.ArrayList;

public class Algoritmo {

    private ArrayList<Bloque> bloques = new ArrayList<>();

    public void agregar(Bloque bloque) {
        bloques.add(bloque);
    }

    public void sacar(Bloque bloque) {
        bloques.remove(bloque);
    }

    public void ejecutar(SectorDibujo sectorDibujo) {
        if (bloques.size() == 0) {
            throw new AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError();
        }
        for (Bloque bloque : bloques) {
            bloque.ejecutar(sectorDibujo);
        }
    }
}