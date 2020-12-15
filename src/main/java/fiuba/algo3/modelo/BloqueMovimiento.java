package fiuba.algo3.modelo;

public class BloqueMovimiento implements Bloque {

    private Posicion posicion;

    public BloqueMovimiento(Posicion posicion){
        this.posicion = posicion;
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        sectorDibujo.mover(this.posicion);
    }
}
