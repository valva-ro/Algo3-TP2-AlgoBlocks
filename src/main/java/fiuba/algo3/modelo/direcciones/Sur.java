package fiuba.algo3.modelo.direcciones;

public class Sur extends Direccion {

    public Sur() {
        this.x = 0;
        this.y = -1;
    }

    @Override
    public Direccion invertir() {
        return new Norte();
    }
}