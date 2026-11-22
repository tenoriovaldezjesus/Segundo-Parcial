public class CalculadoraNumerica<T extends Number> {
    private T numero1;
    private T numero2;

    public CalculadoraNumerica(T numero1, T numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public double sumar() {
        return numero1.doubleValue() + numero2.doubleValue();
    }

    public double multiplicar() {
        return numero1.doubleValue() * numero2.doubleValue();
    }

    public static void main(String[] args) {
        CalculadoraNumerica<Integer> calcEnteros = new CalculadoraNumerica<>(10, 5);
        System.out.println("Suma enteros: " + calcEnteros.sumar());

        CalculadoraNumerica<Double> calcDecimales = new CalculadoraNumerica<>(4.5, 2.0);
        System.out.println("Multiplicación decimales: " + calcDecimales.multiplicar());
        
        // CalculadoraNumerica<String> error; -> Esto marcaría error de compilación porque String no es Number
    }
}
