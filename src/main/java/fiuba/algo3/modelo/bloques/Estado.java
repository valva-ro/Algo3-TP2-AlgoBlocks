package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.direcciones.Direccion;

public interface Estado {
    void ejecutar(SectorDibujo sectorDibujo, Direccion direccion);

    Estado cambiarEstado();
}
