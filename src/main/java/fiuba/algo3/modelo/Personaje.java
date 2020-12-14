package fiuba.algo3.modelo;

public class Personaje {

    private Lapiz lapiz;

    public Personaje() {
        this.lapiz = new LapizLevantado();
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
}
