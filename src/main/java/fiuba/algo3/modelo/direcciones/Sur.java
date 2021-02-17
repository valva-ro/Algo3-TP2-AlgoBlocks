package fiuba.algo3.modelo.direcciones;
import fiuba.algo3.modelo.Posicion;

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
