package fiuba.algo3.modelo;

public class Personaje {

    private Lapiz lapiz;
    private Posicion posicion;

    public Personaje() {
        this.lapiz    = new LapizLevantado();
        this.posicion = new Posicion(0,0);
    }

    public Lapiz obtenerLapiz() {
        return lapiz;
    }

    public void bajarLapiz() {
        this.lapiz = new LapizBajado();
    }

    public void levantarLapiz() {
        this.lapiz = new LapizLevantado();
    }

    public boolean estaEn(Posicion posicion) {
        return this.posicion.esIgual(posicion);
    }

    public void moverHacia(Posicion posicion){
        if (this.estaEn(posicion)) {
            throw new PersonajeYaSeEncuentraEnEsaPosicionError();
        }
        else if (this.posicion.estaEnDiagonal(posicion)) {
            throw new PersonajeNoSePuedeMoverEnDiagonalError();
        }
        this.posicion.actualizar(posicion);
    }
}
