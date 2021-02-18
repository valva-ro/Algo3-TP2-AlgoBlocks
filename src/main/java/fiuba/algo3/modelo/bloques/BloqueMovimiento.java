package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.direcciones.Direccion;
import fiuba.algo3.modelo.direcciones.Norte;

public class BloqueMovimiento implements Bloque {

    private Direccion direccion;
    private Estado estado;

    public BloqueMovimiento(Direccion direccion, Estado estado) {
        this.direccion = direccion;
        this.estado = estado;
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        this.estado.ejecutar(sectorDibujo, this.direccion);
    }

    public void invertirDireccion() {
        this.direccion = direccion.invertir();
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo) {
        this.invertirDireccion();
        this.estado.ejecutar(sectorDibujo, this.direccion);
    }
}
