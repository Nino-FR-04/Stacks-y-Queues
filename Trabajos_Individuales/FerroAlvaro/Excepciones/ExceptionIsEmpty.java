package actividad2;

public class ExceptionIsEmpty extends Exception {
	  public ExceptionIsEmpty(String mnsj) {
	        super(mnsj);
	    }

	    //Sin mensaje
	    public ExceptionIsEmpty() {
	        super();
	    }
	}

