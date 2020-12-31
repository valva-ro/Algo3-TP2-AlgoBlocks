package fiuba.algo3.modelo;

public class Arriba extends Movimiento {

    //Constructor
    public Arriba(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir()
    {
        return new Abajo(estado);
    }

}
