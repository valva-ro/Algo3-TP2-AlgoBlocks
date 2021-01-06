package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class BloqueRepetirDosVeces extends DecoratorBloquePersonalizadoBase{

    public BloqueRepetirDosVeces(Bloques bloque) {
        super(bloque);
        }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo){
        for(int i=0; i< 2; i = i + 1){
            super.ejecutar(sectorDibujo);
        }
    }
}
