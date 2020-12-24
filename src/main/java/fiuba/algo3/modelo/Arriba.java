package fiuba.algo3.modelo;

public class Arriba implements Movimiento {
    private Estado estado;

    //Constructor
    public Arriba(Estado estado) {
        this.estado = estado;
    }

    //Metodos
    @Override
    public boolean estaDibujado(){
        return estado.estaDibujado();
    }

}
