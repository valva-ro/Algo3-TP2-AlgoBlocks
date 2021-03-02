package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueInvertir;
import fiuba.algo3.modelo.bloques.BloqueRepetirDosVeces;
import fiuba.algo3.modelo.bloques.BloqueRepetirTresVeces;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
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
            case "bloquePersonalizado":
                // TODO

            default:
                throw new IllegalStateException("Unexpected value: " + bloqueID);
        }

        return bloquePersonalizado;
    }

    public boolean esBloqueEspecial(String bloqueId) {
        return (bloqueId.equals("bloqueInvertir") || bloqueId.equals("bloqueRepeticionDoble") || bloqueId.equals("bloqueRepeticionTriple") || bloqueId.equals("bloquePersonalizado"));
    }

    public BotonBloqueEspecial obtenerBotonEspecialPorId(String bloqueId, Algoritmo algoritmo, FabricaAbstractaDeBloques fabrica) {

        BotonBloqueEspecial botonBloqueEspecial;

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

    public BotonBloqueSimple agregarBloqueSiempleAlBloqueEspecial(String bloqueId, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {

        BotonBloqueSimple botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
        botonBloqueSimple.setDisable(true);
        botonBloqueSimple.getStyleClass().add("bloqueMovimiento");

        switch (bloqueId){
            case "bloqueMovimientoArriba":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
                break;
            case "bloqueMovimientoAbajo":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
                break;
            case "bloqueMovimientoDerecha":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
                break;
            case "bloqueMovimientoIzquierda":
                algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
                break;
            case "bloqueLapizDibuja":
                fabricaDeBloques.cambiarDeFabrica();
                break;
            case "bloqueLapizNoDibuja":
                fabricaDeBloques.cambiarDeFabrica();
                break;
        }
        return botonBloqueSimple;
    }

    public BotonBloqueSimple agregarBloqueSiempleAlBloqueEspecial(String bloqueId, Bloques bloqueEspecial, FabricaAbstractaDeBloques fabricaDeBloques) {

        BotonBloqueSimple botonBloqueSimple = new BotonBloqueSimple(bloqueId,"");
        botonBloqueSimple.setDisable(true);
        botonBloqueSimple.getStyleClass().add("bloqueMovimiento");

        switch (bloqueId){
            case "bloqueMovimientoArriba":
                bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
                break;
            case "bloqueMovimientoAbajo":
                bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
                break;
            case "bloqueMovimientoDerecha":
                bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
                break;
            case "bloqueMovimientoIzquierda":
                bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
                break;
            case "bloqueLapizDibuja":
                fabricaDeBloques.cambiarDeFabrica();
                break;
            case "bloqueLapizNoDibuja":
                fabricaDeBloques.cambiarDeFabrica();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + bloqueId);
        }
        return botonBloqueSimple;
    }
}
