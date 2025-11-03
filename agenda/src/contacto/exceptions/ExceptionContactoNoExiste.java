package contacto.exceptions;

public class ExceptionContactoNoExiste extends RuntimeException {
    public ExceptionContactoNoExiste(String message) {
        super("El contacto no existe");

    }
}