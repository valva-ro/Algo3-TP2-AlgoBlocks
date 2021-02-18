package fiuba.algo3.modelo.direcciones;

public class Norte extends Direccion {

    public Norte() {
        this.x = 0;
        this.y = 1;
    }

    @Override
    public Direccion invertir() {
        return new Sur();
    }
}
