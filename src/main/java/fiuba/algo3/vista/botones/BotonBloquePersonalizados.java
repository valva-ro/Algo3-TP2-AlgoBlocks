package fiuba.algo3.vista.botones;

import fiuba.algo3.modelo.bloques.BloquePersonalizado;

public class BotonBloquePersonalizados extends BotonBloqueSimple {

    private BloquePersonalizado bloquePersonalizado;

    public BotonBloquePersonalizados(String bloqueID, String texto, BloquePersonalizado bloquePersonalizado) {
        super(bloqueID, texto);
        this.bloquePersonalizado = bloquePersonalizado;
    }
}
