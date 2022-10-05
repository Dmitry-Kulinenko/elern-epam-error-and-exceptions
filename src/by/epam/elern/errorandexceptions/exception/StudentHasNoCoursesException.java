package by.epam.elern.errorandexceptions.exception;

public class StudentHasNoCoursesException extends Exception {

	private static final long serialVersionUID = -5379621743976124777L;

	public StudentHasNoCoursesException() {
	}

	public StudentHasNoCoursesException(String message) {
		super(message);
	}

	public StudentHasNoCoursesException(Throwable cause) {
		super(cause);
	}

	public StudentHasNoCoursesException(String message, Throwable cause) {
		super(message, cause);
	}

}
