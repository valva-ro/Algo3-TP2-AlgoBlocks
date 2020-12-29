package fiuba.algo3.modelo;

import java.util.ArrayList;

public class SectorDibujo {

    private ArrayList<MockMovimiento> bloquesDibujados = new ArrayList<>();

    public ArrayList<MockMovimiento> obtenerMovimientos() {
        return this.bloquesDibujados;
    }

    public void dibujar (MockMovimiento unMovimiento) {
        unMovimiento.ejecutar();
        bloquesDibujados.add(unMovimiento);

    }

    public void bajarLapiz() {
    }

    public void levantarLapiz() {
    }
}
