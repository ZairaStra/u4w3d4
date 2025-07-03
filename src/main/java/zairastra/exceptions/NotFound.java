package zairastra.exceptions;

public class NotFound extends RuntimeException {
    public NotFound(long id) {
        super("L'evento con codice identificativo " + id + "non è presente in agenda");
    }
}
