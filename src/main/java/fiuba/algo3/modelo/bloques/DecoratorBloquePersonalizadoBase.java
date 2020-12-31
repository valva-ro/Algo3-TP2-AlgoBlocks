package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

import java.util.ArrayList;

public class DecoratorBloquePersonalizadoBase extends Bloques {

    private Bloques bloqueAEnvolver;

    public DecoratorBloquePersonalizadoBase(Bloques bloqueAEnvolver) {
        this.bloqueAEnvolver = bloqueAEnvolver;
        this.bloques = new ArrayList<>();
    }

    public void ejecutar(SectorDibujo sectorDibujo) {
        bloqueAEnvolver.ejecutar(sectorDibujo);
    }
}
