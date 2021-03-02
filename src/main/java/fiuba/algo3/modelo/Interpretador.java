package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueInvertir;
import fiuba.algo3.modelo.bloques.BloqueRepetirDosVeces;
import fiuba.algo3.modelo.bloques.BloqueRepetirTresVeces;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloqueSimple;

public class Interpretador {

    public Bloques obtenerBloqueEspecialPorId(String bloqueID) {
        Bloques bloquePersonalizado;

        switch (bloqueID) {
            case "bloqueInvertir":
                bloquePersonalizado = new BloqueInvertir();
                break;
            case "bloqueRepeticionDoble":
                bloquePersonalizado = new BloqueRepetirDosVeces();
                break;
            case "bloqueRepeticionTriple":
                bloquePersonalizado = new BloqueRepetirTresVeces();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + bloqueID);
        }

        return bloquePersonalizado;
    }

    public boolean esBloqueEspecial(String bloqueId) {
        return (bloqueId.equals("bloqueInvertir") || bloqueId.equals("bloqueRepeticionDoble") || bloqueId.equals("bloqueRepeticionTriple"));
    }

    public BotonBloqueEspecial obtenerBotonEspecialPorId(String bloqueId, Algoritmo algoritmo, FabricaAbstractaDeBloques fabrica) {
        BotonBloqueEspecial botonBloqueEspecial = null;

        switch (bloqueId) {
            case "bloqueInvertir":
            case "bloqueRepeticionDoble":
            case "bloqueRepeticionTriple":
                botonBloqueEspecial = new BotonBloqueEspecial(bloqueId,algoritmo,fabrica);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + bloqueId);
        }
        botonBloqueEspecial.setModoAlgoritmo();
        return botonBloqueEspecial;
    }

    public BotonBloqueSimple agregarBloqueSiempleAlAlgoritmo(String bloqueId, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        BotonBloqueSimple botonBloqueSimple = new BotonBloqueSimple("error","error");

        switch (bloqueId){
            case "bloqueMovimientoArriba":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
                botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
                botonBloqueSimple.setDisable(true);
            case "bloqueMovimientoAbajo":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
                botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
                botonBloqueSimple.setDisable(true);
            case "bloqueMovimientoDerecha":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
                botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
                botonBloqueSimple.setDisable(true);
            case "bloqueMovimientoIzquierda":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
                botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
                botonBloqueSimple.setDisable(true);
            case "bloqueLapizDibuja":
                fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
                botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
                botonBloqueSimple.setDisable(true);
            case "bloqueLapizNoDibuja":
                fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
                botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
                botonBloqueSimple.setDisable(true);
        }
        botonBloqueSimple.getStyleClass().add("bloqueMovimiento");
        return botonBloqueSimple;
    }
}
