package fiuba.algo3.modelo;

public class Izquierda implements Movimiento {
    private Estado estado;

    //Constructor
    public Izquierda(Estado estado) {
        this.estado = estado;
    }

    //Metodos
    @Override
    public boolean estaDibujado(){
        return estado.estaDibujado();
    }
}
