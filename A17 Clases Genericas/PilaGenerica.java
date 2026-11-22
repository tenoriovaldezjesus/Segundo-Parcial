import java.util.ArrayList;

public class PilaGenerica<T> {
    private ArrayList<T> elementos = new ArrayList<>();

    public void apilar(T item) {
        elementos.add(item);
    }

    public T desapilar() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.remove(elementos.size() - 1);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public static void main(String[] args) {
        // Pila de textos
        PilaGenerica<String> historial = new PilaGenerica<>();
        historial.apilar("google.com");
        historial.apilar("github.com");
        historial.apilar("uaemex.mx");

        System.out.println("Última página visitada: " + historial.desapilar());
        System.out.println("Página anterior: " + historial.desapilar());

        // Pila de números
        PilaGenerica<Integer> turnos = new PilaGenerica<>();
        turnos.apilar(101);
        turnos.apilar(102);
        System.out.println("Siguiente turno: " + turnos.desapilar());
    }
}
