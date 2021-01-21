package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

import java.util.ArrayList;

abstract class Bloques implements Bloque {

    protected ArrayList<Bloque> bloques;

    public Bloques() {
        this.bloques = new ArrayList<>();
    }

    public void agregar(Bloque bloque) {
        bloques.add(bloque);
    }

    public void ejecutar(SectorDibujo sectorDibujo){
        for(Bloque bloque: bloques){
            bloque.ejecutar(sectorDibujo);
        }
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo){
        for(Bloque bloque: bloques){
            bloque.ejecutarInvertido(sectorDibujo);
        }
    }
}