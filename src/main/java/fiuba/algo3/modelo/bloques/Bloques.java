package fiuba.algo3.modelo.bloques;

import java.util.ArrayList;

abstract class Bloques implements Bloque {

    protected ArrayList<Bloque> bloques;

    public void agregar(Bloque bloque) {
        bloques.add(bloque);
    }
}
