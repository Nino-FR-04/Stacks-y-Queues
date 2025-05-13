package actividad1;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pilaEnteros = new StackArray<>(5);

        Stack<String> pilaCadenas = new StackArray<>(3);

        try {
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            System.out.println("Pila de enteros: " + pilaEnteros);

            System.out.println("Elemento en el tope (enteros): " + pilaEnteros.top());
            pilaEnteros.pop();
            System.out.println("Después de un pop (enteros): " + pilaEnteros);

            pilaCadenas.push("Hola");
            pilaCadenas.push("Mundo");
            System.out.println("\nPila de cadenas: " + pilaCadenas);

            System.out.println("Elemento en el tope (cadenas): " + pilaCadenas.top());
            pilaCadenas.pop();
            pilaCadenas.push("Java");
            System.out.println("Pila actual (cadenas): " + pilaCadenas);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
