package fiuba.algo3.modelo;

public class Posicion {
    private int coordenadaX;
    private int coordenadaY;

    public Posicion(int x , int y){
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public int obtenerCoordenadaY(){
        return  this.coordenadaY;
    }

    public int obtenerCoordenadaX(){
        return this.coordenadaX;
    }

    public boolean esIgual(Posicion posicion) {
        boolean esIgualX = (this.coordenadaX == posicion.obtenerCoordenadaX());
        boolean esIgualY = (this.coordenadaY == posicion.obtenerCoordenadaY());

        return (esIgualX && esIgualY);
    }

    public void actualizar(Posicion posicion){
        this.coordenadaX  += posicion.obtenerCoordenadaX();
        this.coordenadaY  += posicion.obtenerCoordenadaY();
    }

    public boolean estaEnDiagonal(Posicion posicion) {
        boolean estaEnDiagonalPositivo = ((Math.abs(this.coordenadaX) + 1) == Math.abs(posicion.obtenerCoordenadaX()) &&
                                         (Math.abs(this.coordenadaY) + 1) == Math.abs(posicion.obtenerCoordenadaY()));

        boolean estaEnDiagonalNegativo = ((Math.abs(this.coordenadaX) - 1) == Math.abs(posicion.obtenerCoordenadaX()) &&
                                         (Math.abs(this.coordenadaY) - 1) == Math.abs(posicion.obtenerCoordenadaY()));

        return (estaEnDiagonalPositivo || estaEnDiagonalNegativo);
    }
}
