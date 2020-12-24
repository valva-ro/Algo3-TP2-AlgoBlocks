package fiuba.algo3.modelo;

public class Abajo implements  Movimiento{
    private Estado estado;

    //Constructor
    public Abajo(Estado estado) {
        this.estado = estado;
    }

    //Metodos
    @Override
    public boolean estaDibujado(){
        return estado.estaDibujado();
    }
}
