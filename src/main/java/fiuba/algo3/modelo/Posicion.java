package fiuba.algo3.modelo;

public class Posicion {

    private int x, y;

    public Posicion() {
        this.x = 0;
        this.y = 0;
    }

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posicion actualizarCoordenadas(int x, int y) {
        return new Posicion(this.x + x, this.y + y);
    }

    public boolean esIgual(Posicion posicion) {
        return (this.x == posicion.x && this.y == posicion.y);
    }

    public int obtenerX() {
        return x;
    }

    public int obtenerY() {
        return y;
    }
}