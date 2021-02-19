package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class DecoratorBloquePersonalizadoBase implements Bloques {

    private Bloques bloqueAEnvolver;

    public DecoratorBloquePersonalizadoBase() {
        this.bloqueAEnvolver = new BloquePersonalizado();
    }

    public DecoratorBloquePersonalizadoBase(Bloques bloqueAEnvolver) {
        this.bloqueAEnvolver = bloqueAEnvolver;
    }

    public void agregar(Bloque unBloque) {
        bloqueAEnvolver.agregar(unBloque);
    }

    @Override
    public void sacar(Bloque unBloque) {
        bloqueAEnvolver.sacar(unBloque);
    }

    public void ejecutar(SectorDibujo sectorDibujo) {
        bloqueAEnvolver.ejecutar(sectorDibujo);
    }

    public void ejecutarInvertido(SectorDibujo sectorDibujo) {
        bloqueAEnvolver.ejecutarInvertido(sectorDibujo);
    }
}