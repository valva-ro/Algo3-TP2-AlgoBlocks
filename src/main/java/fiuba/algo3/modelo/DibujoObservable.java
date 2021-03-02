package fiuba.algo3.modelo;

public interface DibujoObservable{
    void agregarObservador(ObservadorDibujo obs);

    void notificarObservadores(Boolean bool, Posicion posicionInicial, Posicion posicionFinal);
}
