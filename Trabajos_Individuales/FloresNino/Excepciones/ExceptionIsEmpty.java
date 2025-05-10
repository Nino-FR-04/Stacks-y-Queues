package Trabajos_Individuales.FloresNino.Excepciones;

/**
 * Excepción que se lanza cuando se intenta acceder o remover 
 * un elemento de una estructura de datos vacía.
 */
public class ExceptionIsEmpty extends RuntimeException {

    //Mostrar Mensaje
    public ExceptionIsEmpty(String mnsj) {
        super(mnsj);
    }

    //Sin mensaje
    public ExceptionIsEmpty() {
        super();
    }
}
