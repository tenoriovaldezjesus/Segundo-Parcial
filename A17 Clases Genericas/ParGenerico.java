public class ParGenerico<K, V> {
    private K clave;
    private V valor;

    public ParGenerico(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void mostrarPar() {
        System.out.println("Clave: " + clave + " | Valor: " + valor);
    }

    public static void main(String[] args) {
        // Par de Integer y String (Matrícula -> Alumno)
        ParGenerico<Integer, String> alumno = new ParGenerico<>(2525043, "Jesus Arnulfo Tenorio Valdez");
        alumno.mostrarPar();

        // Par de String y Double (Materia -> Promedio)
        ParGenerico<String, Double> calificacion = new ParGenerico<>("Paradigmas", 9.0);
        calificacion.mostrarPar();
    }
}
