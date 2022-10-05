package by.epam.elern.errorandexceptions.exception;

public class MarkOutOfRangeException extends Exception {

	private static final long serialVersionUID = -2104068038362673238L;

	public MarkOutOfRangeException() {
	}

	public MarkOutOfRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarkOutOfRangeException(Throwable cause) {
		super(cause);
	}

	public MarkOutOfRangeException(String message) {
		super(message);
	}
}
