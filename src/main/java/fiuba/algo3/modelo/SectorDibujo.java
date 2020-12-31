package fiuba.algo3.modelo;

import fiuba.algo3.modelo.movimientos.Movimiento;

import java.util.ArrayList;

public class SectorDibujo {

    private ArrayList<Movimiento> bloquesDibujados = new ArrayList<>();

    public ArrayList<Movimiento> obtenerMovimientos() {
        return this.bloquesDibujados;
    }

    public void dibujar (Movimiento unMovimiento) {
        bloquesDibujados.add(unMovimiento);
    }
}
