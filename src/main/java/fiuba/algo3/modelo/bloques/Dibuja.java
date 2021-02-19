package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.direcciones.Direccion;

public class Dibuja implements Estado {
    public void ejecutar(SectorDibujo sectorDibujo, Direccion direccion) {
        sectorDibujo.dibujar(direccion);
    }
}