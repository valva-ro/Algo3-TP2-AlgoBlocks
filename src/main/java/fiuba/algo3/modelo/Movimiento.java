package fiuba.algo3.modelo;

public abstract class Movimiento {
    protected Estado estado;
    // TODO: VER COMO GUARDAMOS LOS VALORES DE LOS MOVIMIENTOS

    public boolean estaDibujado(){
        return estado.estaDibujado();
    }

}
