package ejercicio4;

public class Test {
    public static void main(String[] args) {
        System.out.println(Aplicacion.symbolBalancing("()()()[()]()")); // true
        System.out.println(Aplicacion.symbolBalancing("((()))[]")); // true
        System.out.println(Aplicacion.symbolBalancing("([])[](")); // false
        System.out.println(Aplicacion.symbolBalancing("([{)]}")); // false
        System.out.println(Aplicacion.symbolBalancing("[")); // false
        System.out.println(Aplicacion.symbolBalancing("[][][]{{{}}}")); // true
    }
}