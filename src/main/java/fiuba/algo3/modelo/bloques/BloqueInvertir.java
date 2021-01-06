package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class BloqueInvertir extends DecoratorBloquePersonalizadoBase {

    public BloqueInvertir(Bloques bloque) {
        super(bloque);
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        //TODO: Hay un problema de diseño
        /*
        for(Bloque bloque: bloques){
            //bloque.invertir();
        }*/
        super.ejecutar(sectorDibujo);
    }
}
