package fiuba.algo3.modelo;

public class SectorDibujo {

    private Personaje personaje;

    public SectorDibujo() {
        this.personaje = new Personaje();
    }

    public Personaje obtenerPersonaje() {
        return personaje;
    }

    public void levantarLapiz() {
        this.personaje.levantarLapiz();
    }
}
