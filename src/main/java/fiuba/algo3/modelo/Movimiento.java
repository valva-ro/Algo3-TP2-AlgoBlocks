package fiuba.algo3.modelo;

public abstract class Movimiento {
    protected Estado estado;

    public boolean estaDibujado(){
        return estado.estaDibujado();
    }


    public abstract Movimiento invertir();
}
