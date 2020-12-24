package fiuba.algo3.modelo;

import java.util.ArrayList;

public class BloquePersonalizado extends Bloques {

    public BloquePersonalizado() {
        this.bloques = new ArrayList<>();
    }

    public void ejecutar(SectorDibujo sectorDibujo) {

        if (bloques.size() < 1) {
            throw new BloquePersonalizadoNoPuedeEjecutarseSinBloquesError();
        }

        for (Bloque bloque : bloques) {
            bloque.ejecutar(sectorDibujo);
        }
    }
}
