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

    public void agregarArista(Direccion direccion, Recorrido recorrido) {
        int ultimaPosicion = aristas.size() - 1;
        Posicion origen = recorrido.aristas.get(ultimaPosicion).obtenerDestino();
        Posicion destino = direccion.actualizarPosicion(origen);
        Arista arista = new Arista(origen, destino);
        aristas.add(arista);
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
}
