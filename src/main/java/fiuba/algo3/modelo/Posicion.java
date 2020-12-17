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
}
