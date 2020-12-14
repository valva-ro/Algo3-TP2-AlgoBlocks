package fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoritmo {

    private ArrayList<Bloque> bloques = new ArrayList<>();

    public ArrayList<Bloque> obtenerBloques() {
        return bloques;
    }

    public void agregar(Bloque bloque) {
        bloques.add(bloque);
    }

    public void ejecutar(SectorDibujo sectorDibujo) {
        for (Bloque bloque : bloques) {
            bloque.ejecutar(sectorDibujo);
        }
    }
}