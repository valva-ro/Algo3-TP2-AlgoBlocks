package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class BloqueRepetirTresVeces extends DecoratorBloquePersonalizadoBase {

    public BloqueRepetirTresVeces(Bloques bloque) {
        super(bloque);
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo){
        for(int i = 0; i < 3; i++){
            super.ejecutar(sectorDibujo);
        }
    }

    @Override
    public void ejecutarInvertido(SectorDibujo sectorDibujo){
        for(int i = 0; i < 3; i++){
            super.ejecutarInvertido(sectorDibujo);
        }
    }
}
