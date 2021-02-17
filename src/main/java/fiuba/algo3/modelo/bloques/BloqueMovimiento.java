package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.direcciones.Direccion;
import fiuba.algo3.modelo.direcciones.Norte;

public class BloqueMovimiento implements Bloque {

    private Direccion direccion;

    public BloqueMovimiento(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        sectorDibujo.dibujar(this.direccion);
    }

    public void invertirDireccion() {
        this.direccion = direccion.invertir();
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo) {
        this.invertirDireccion();
        this.ejecutar(sectorDibujo);
    }
}
