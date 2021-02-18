package fiuba.algo3.modelo.dibujo;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direcciones.Direccion;

import java.util.ArrayList;

public class Recorrido {

    private ArrayList<Arista> aristas = new ArrayList<>();

    public Recorrido() {
        Arista primerTrazo = new Arista(new Posicion(), new Posicion());
        aristas.add(primerTrazo);
    }

    public Posicion agregarArista(Direccion direccion, Posicion posicionFinal) {
        Posicion origen = posicionFinal;
        Posicion destino = direccion.actualizarPosicion(posicionFinal);
        Arista arista = new Arista(origen, destino);
        aristas.add(arista);
        return destino;
    }

    public boolean existeVertice(Posicion posicion) {
        boolean existe = false;
        for (int i = 0; i < aristas.size() && !existe; i++) {
            existe = aristas.get(i).contiene(posicion);
        }
        return existe;
    }

    public boolean existeArista(Posicion origen, Posicion destino) {
        boolean existe = false;
        for (int i = 0; i < aristas.size() && !existe; i++) {
            existe = aristas.get(i).contiene(origen, destino);
        }
        return existe;
    }

    public Posicion obtenerUltimoVertice(){
        return this.aristas.get(aristas.size() - 1).obtenerDestino();
    }
}
