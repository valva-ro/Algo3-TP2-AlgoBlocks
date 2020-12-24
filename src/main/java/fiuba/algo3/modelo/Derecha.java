package fiuba.algo3.modelo;

public class Derecha implements Movimiento{
    private Estado estado;

    //Constructor
    public Derecha(Estado estado) {
        this.estado = estado;
    }

    //Metodos
    @Override
    public boolean estaDibujado(){
        return estado.estaDibujado();
    }
}
