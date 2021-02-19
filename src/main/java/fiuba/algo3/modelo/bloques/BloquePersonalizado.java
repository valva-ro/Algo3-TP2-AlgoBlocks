package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

import java.util.ArrayList;

public class BloquePersonalizado implements Bloques {

    private ArrayList<Bloque> bloques;

    public BloquePersonalizado() {
        this.bloques = new ArrayList<>();
    }

    public void agregar(Bloque unBloque) {
        bloques.add(unBloque);
    }

    public void sacar(Bloque unBloque) {
        bloques.remove(unBloque);
    }

    public void ejecutar(SectorDibujo sectorDibujo) {

        this.contieneBloques();
        for (Bloque bloque : bloques) {
            bloque.ejecutar(sectorDibujo);
        }
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo) {

        this.contieneBloques();
        for (Bloque bloque : bloques) {
            bloque.ejecutarInvertido(sectorDibujo);
        }
    }

    private void contieneBloques() {
        if (bloques.size() < 1) {
            throw new BloquePersonalizadoNoPuedeEjecutarseSinBloquesError();
        }
    }
}