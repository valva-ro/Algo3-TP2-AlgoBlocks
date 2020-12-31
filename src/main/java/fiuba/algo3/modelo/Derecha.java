package fiuba.algo3.modelo;

public class Derecha extends Movimiento {

    //Constructor
    public Derecha(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir()
    {
        return new Izquierda(estado);
    }
}
