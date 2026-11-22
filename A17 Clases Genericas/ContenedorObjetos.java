public class ContenedorObjetos<T> {
    private String etiqueta;
    private T contenido;

    public ContenedorObjetos(String etiqueta, T contenido) {
        this.etiqueta = etiqueta;
        this.contenido = contenido;
    }

    public void inspeccionar() {
        System.out.println("[" + etiqueta + "] Contenido (" + contenido.getClass().getSimpleName() + "): " + contenido);
    }

    // Clase interna de ejemplo para guardar dentro del contenedor genérico
    static class Dispositivo {
        String modelo;
        String marca;

        Dispositivo(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return marca + " " + modelo;
        }
    }

    public static void main(String[] args) {
        // Contenedor guardando un objeto personalizado Dispositivo
        Dispositivo ipad = new Dispositivo("Apple", "iPad Air");
        ContenedorObjetos<Dispositivo> cajaHardware = new ContenedorObjetos<>("Caja-01", ipad);
        cajaHardware.inspeccionar();

        // El mismo contenedor guardando un String
        ContenedorObjetos<String> cajaDocumentos = new ContenedorObjetos<>("Caja-02", "Reportes Parcial 2");
        cajaDocumentos.inspeccionar();
    }
}
