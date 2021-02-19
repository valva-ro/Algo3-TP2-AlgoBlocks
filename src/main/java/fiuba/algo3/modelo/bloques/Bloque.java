package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public interface Bloque {

    void ejecutar(SectorDibujo sectorDibujo);

    void ejecutarInvertido(SectorDibujo sectorDibujo);
}