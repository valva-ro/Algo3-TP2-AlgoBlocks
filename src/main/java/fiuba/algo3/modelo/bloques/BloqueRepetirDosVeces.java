package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class BloqueRepetirDosVeces extends DecoratorBloquePersonalizadoBase {

    public BloqueRepetirDosVeces() {
        super();
    }

    public BloqueRepetirDosVeces(Bloques bloque) {
        super(bloque);
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        for (int i = 0; i < 2; i++) {
            super.ejecutar(sectorDibujo);
        }
    }

    @Override
    public void ejecutarInvertido(SectorDibujo sectorDibujo) {
        for (int i = 0; i < 2; i++) {
            super.ejecutarInvertido(sectorDibujo);
        }
    }
}