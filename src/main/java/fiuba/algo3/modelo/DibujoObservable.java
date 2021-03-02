package fiuba.algo3.modelo;

public interface DibujoObservable{
    void agregarObservador(ObservadorDibujo obs);

    void notificarObservador(Boolean bool, Posicion posicionInicial, Posicion posicionFinal);
}
