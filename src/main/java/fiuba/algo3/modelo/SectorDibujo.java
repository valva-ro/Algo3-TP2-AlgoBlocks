package fiuba.algo3.modelo;

public class SectorDibujo {

    private Personaje personaje;

    public SectorDibujo() {
        this.personaje = new Personaje();
    }

    public void levantarLapiz() {
        this.personaje.levantarLapiz();
    }

    public void bajarLapiz() {
        this.personaje.bajarLapiz();
    }
}
