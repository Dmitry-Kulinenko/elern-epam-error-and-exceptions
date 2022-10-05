package by.epam.elern.errorandexceptions.exception;

public class UniversityHasNoFacultiesException extends Exception {

	private static final long serialVersionUID = -8425758388269582727L;

	public UniversityHasNoFacultiesException() {
	}

	public UniversityHasNoFacultiesException(String message) {
		super(message);
	}

	public UniversityHasNoFacultiesException(Throwable cause) {
		super(cause);
	}

	public UniversityHasNoFacultiesException(String message, Throwable cause) {
		super(message, cause);
	}

}
