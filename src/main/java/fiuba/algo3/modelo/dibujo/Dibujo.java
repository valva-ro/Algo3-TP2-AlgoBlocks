package fiuba.algo3.modelo.dibujo;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direcciones.Direccion;

import java.util.ArrayList;

public class Dibujo {

    private ArrayList<Arista> aristas = new ArrayList<>();

    public Dibujo() {
        Arista primerTrazo = new Arista(new Vertice(), new Vertice());
        aristas.add(primerTrazo);
    }

    public void agregarTrazo(Direccion direccion, boolean dibuja) {
        Vertice origen = aristas.get(aristas.size() - 1).obtenerDestino();
        Vertice destino = origen.actualizar(direccion);
        Arista trazo = new Arista(origen, destino, dibuja);
        aristas.add(trazo);
    }

    public boolean existe(Posicion posicion) {
        boolean existe = false;
        for (int i = 0; i < aristas.size() && !existe; i++) {
            existe = aristas.get(i).contiene(posicion);
        }
        return existe;
    }
}
