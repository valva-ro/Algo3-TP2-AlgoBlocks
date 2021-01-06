package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class BloqueRepetirTresVeces extends DecoratorBloquePersonalizadoBase {

    public BloqueRepetirTresVeces(Bloques bloque) {
        super(bloque);
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo){
        for(int i=0; i< 3; i = i + 1){
            super.ejecutar(sectorDibujo);
        }
    }
}
