package fiuba.algo3.modelo;

public class BloqueMovimiento implements Bloque {

    private Movimiento movimiento;

    public BloqueMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        //sectorDibujo.dibujar(this.movimiento);
    }

    public Movimiento obtenerMovimiento() {
        return movimiento;
    }
}
