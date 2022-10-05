package by.epam.elern.errorandexceptions.exception;

public class GroupHasNoStudentsException extends Exception {

	private static final long serialVersionUID = 2073767017964610953L;

	public GroupHasNoStudentsException() {
	}

	public GroupHasNoStudentsException(String message) {
		super(message);
	}

	public GroupHasNoStudentsException(Throwable cause) {
		super(cause);
	}

	public GroupHasNoStudentsException(String message, Throwable cause) {
		super(message, cause);
	}

}
