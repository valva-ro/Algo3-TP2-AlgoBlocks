package fiuba.algo3.modelo;

import fiuba.algo3.modelo.movimientos.Movimiento;

import java.util.ArrayList;

public class SectorDibujo {

    private ArrayList<Movimiento> bloquesDibujados = new ArrayList<>();

    public ArrayList<Movimiento> obtenerMovimientos() {
        return this.bloquesDibujados;
    }

    public boolean dibujoEsIgual(ArrayList<Movimiento> movimientos) {
        Movimiento movimiento;
        boolean esIgual = true;
        int i = 0;

        if (bloquesDibujados.size() != movimientos.size()) {
            esIgual = false;
        }

        while (i < bloquesDibujados.size() && esIgual) {
            movimiento = bloquesDibujados.get(i);
            if (!movimiento.esIgualA(movimientos.get(i))) {
                esIgual = false;
            }
            i++;
        }
        return esIgual;
    }

    public void dibujar (Movimiento unMovimiento) {
        bloquesDibujados.add(unMovimiento);
    }
}
