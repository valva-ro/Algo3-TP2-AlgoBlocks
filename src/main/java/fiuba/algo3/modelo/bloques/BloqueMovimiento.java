package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.movimientos.Movimiento;

public class BloqueMovimiento implements Bloque {

    private Movimiento movimiento;

    public BloqueMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        sectorDibujo.dibujar(this.movimiento);
    }

    public Movimiento obtenerMovimiento() {
        return movimiento;
    }

    public void invertirMovimiento() {
        this.movimiento = movimiento.invertir();
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo) {
        this.invertirMovimiento();
        this.ejecutar(sectorDibujo);
    }
}
