package by.epam.elern.errorandexceptions.exception;

public class FacultyHasNoGroupsException extends Exception {

	private static final long serialVersionUID = -2261554815976958604L;

	public FacultyHasNoGroupsException() {
	}

	public FacultyHasNoGroupsException(String message) {
		super(message);
	}

	public FacultyHasNoGroupsException(Throwable cause) {
		super(cause);
	}

	public FacultyHasNoGroupsException(String message, Throwable cause) {
		super(message, cause);
	}

}
