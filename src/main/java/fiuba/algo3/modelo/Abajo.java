package fiuba.algo3.modelo;

public class Abajo extends Movimiento {
    //Constructor
    public Abajo(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir()
    {
        return new Arriba(estado);
    }
}
