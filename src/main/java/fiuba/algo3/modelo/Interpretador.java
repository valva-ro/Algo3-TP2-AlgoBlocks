package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.BloqueInvertir;
import fiuba.algo3.modelo.bloques.BloqueRepetirDosVeces;
import fiuba.algo3.modelo.bloques.BloqueRepetirTresVeces;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;

public class Interpretador {

    private FabricaDeBloques fabrica;

    public Interpretador() {
        this.fabrica = new FabricaDeBloques();
    }

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

    public BotonBloqueEspecial obtenerBotonEspecialPorId(String bloqueId, Algoritmo algoritmo, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {

        BotonBloqueEspecial botonBloqueEspecial;

        switch (bloqueId) {
            case "bloqueInvertir":
            case "bloqueRepeticionDoble":
            case "bloqueRepeticionTriple":
                botonBloqueEspecial = new BotonBloqueEspecial(bloqueId, algoritmo, this, sectorBloquesDisponiblesVista);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + bloqueId);
        }
        botonBloqueEspecial.setModoAlgoritmo();
        return botonBloqueEspecial;
    }

    public BotonBloqueSimple agregarBloqueSimpleAlAlgoritmo(String bloqueId, Algoritmo algoritmo) {

        BotonBloqueSimple botonBloqueSimple = new BotonBloqueSimple(bloqueId, "");
        botonBloqueSimple.setDisable(true);
        botonBloqueSimple.getStyleClass().add("bloqueMovimiento");

        switch (bloqueId) {
            case "bloqueMovimientoArriba":
                algoritmo.agregar(this.fabrica.crearBloqueMovimientoArriba());
                break;
            case "bloqueMovimientoAbajo":
                algoritmo.agregar(this.fabrica.crearBloqueMovimientoAbajo());
                break;
            case "bloqueMovimientoDerecha":
                algoritmo.agregar(this.fabrica.crearBloqueMovimientoDerecha());
                break;
            case "bloqueMovimientoIzquierda":
                algoritmo.agregar(this.fabrica.crearBloqueMovimientoIzquierda());
                break;
            case "bloqueLapizDibuja":
                this.fabrica.fabricaDibuja();
                break;
            case "bloqueLapizNoDibuja":
                this.fabrica.fabricaNoDibuja();
                break;
        }
        return botonBloqueSimple;
    }

    public BotonBloqueSimple agregarBloqueSiempleAlBloqueEspecial(String bloqueId, Bloques bloqueEspecial) {

        BotonBloqueSimple botonBloqueSimple = new BotonBloqueSimple(bloqueId, "");
        botonBloqueSimple.setDisable(true);
        botonBloqueSimple.getStyleClass().add("bloqueMovimiento");

        switch (bloqueId) {
            case "bloqueMovimientoArriba":
                bloqueEspecial.agregar(this.fabrica.crearBloqueMovimientoArriba());
                break;
            case "bloqueMovimientoAbajo":
                bloqueEspecial.agregar(this.fabrica.crearBloqueMovimientoAbajo());
                break;
            case "bloqueMovimientoDerecha":
                bloqueEspecial.agregar(this.fabrica.crearBloqueMovimientoDerecha());
                break;
            case "bloqueMovimientoIzquierda":
                bloqueEspecial.agregar(this.fabrica.crearBloqueMovimientoIzquierda());
                break;
            case "bloqueLapizDibuja":
                this.fabrica.fabricaDibuja();
                break;
            case "bloqueLapizNoDibuja":
                this.fabrica.fabricaNoDibuja();
                break;
        }
        return botonBloqueSimple;
    }
}
