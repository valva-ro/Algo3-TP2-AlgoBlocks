package fiuba.algo3.modelo.direcciones;
import fiuba.algo3.modelo.Posicion;

public class Este extends Direccion {

    public Este() {
        this.x = 1;
        this.y = 0;
    }

    @Override
    public Direccion invertir() {
        return new Oeste();
    }
}
