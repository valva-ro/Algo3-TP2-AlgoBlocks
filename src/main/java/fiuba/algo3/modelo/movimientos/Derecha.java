package fiuba.algo3.modelo.movimientos;

public class Derecha extends Movimiento {

    public Derecha(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir() {
        return new Izquierda(estado);
    }

    @Override
    public boolean esIgualA(Movimiento movimiento) {
        return (movimiento instanceof Derecha && this.estado.estaDibujado() == movimiento.estaDibujado());
    }
}
