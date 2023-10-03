package co.za.ubuntu.ubuntubackend.domain.exception;

/**
 * Custom exception class to indicate that a requested resource or entity was not found.
 *
 * This exception is typically used when attempting to retrieve or operate on a resource
 * that does not exist in the system.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructs a new NotFoundException with no detail message.
     */
    public NotFoundException() {
        super();
    }

    /**
     * Constructs a new NotFoundException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new NotFoundException with the specified detail message and cause.
     *
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception, which may be another exception that
     *                triggered this one. Can be null if the cause is unknown or
     *                nonexistent.
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new NotFoundException with the specified cause.
     *
     * @param cause The cause of the exception, which may be another exception that
     *              triggered this one. Can be null if the cause is unknown or
     *              nonexistent.
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
