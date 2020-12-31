package fiuba.algo3.modelo;

public class Izquierda extends Movimiento {

    //Constructor
    public Izquierda(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir()
    {
        return new Derecha(estado);
    }
}
