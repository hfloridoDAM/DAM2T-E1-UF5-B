package exceptions;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {
	private int code; 
	
    // Exception codes
    public static final int NO_P = 0;
    public static final int WRONG_NUM_PARAMS = 1;
    public static final int WRONG_INPUT = 2;
    public static final int P_OK = 3;

    // Exception messages
    private final List<String> messages = Arrays.asList(
            "< No hay suficientes passageros >",
            "< Parametros insuficientes >",
    		"< Error en la linea >",
            "< Parada correcta >");

    public MyException(int code) {
        this.code = code;
    }
    
     @Override
    public String getMessage() {
        return messages.get(this.code);
    }
     
     public int getMessageCode() {
     	return this.code;
     }
}
