package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class DecoratorBloquePersonalizadoBase extends Bloques {

    private Bloques bloquesAEnvolver;

    public DecoratorBloquePersonalizadoBase(Bloques bloquesAEnvolver) {
        this.bloquesAEnvolver = bloquesAEnvolver;
    }

    public void ejecutar(SectorDibujo sectorDibujo) {
        bloquesAEnvolver.ejecutar(sectorDibujo);
        super.ejecutar(sectorDibujo);
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo){
        bloquesAEnvolver.ejecutarInvertido(sectorDibujo);
        super.ejecutarInvertido(sectorDibujo);
    }
}