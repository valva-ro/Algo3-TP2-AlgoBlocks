package fiuba.algo3.modelo;

public interface Observable {
    void agregarObservador(Observador obs);

    void sacarObservador(Observador obs);

    void notificarObservadores();
}
