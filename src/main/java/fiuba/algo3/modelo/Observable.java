package fiuba.algo3.modelo;

public interface Observable {
    public void addObserver(Observador obs);

    public void removeObserver(Observador obs);

    public void notifyObservers();
}
