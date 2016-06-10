package root_task_2_2.dao.exceptions;

/**
 * Common class which describing exceptions, that bubble during reading file
 */
public class FileDaoException extends Exception {

    public FileDaoException() {
    }

    public FileDaoException(String message) {
        super(message);
    }

    public FileDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
