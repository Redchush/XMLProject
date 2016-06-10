package root_task_2_2.service.parser.exception;

/**
 * Created by Student on 02-Jun-16.
 */
public class ParserException extends Exception {
    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
