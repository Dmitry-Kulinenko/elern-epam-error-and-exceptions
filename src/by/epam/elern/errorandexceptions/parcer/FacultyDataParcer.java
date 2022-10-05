package by.epam.elern.errorandexceptions.parcer;

public class FacultyDataParcer {
	private static final String MAIN_SEPARATOR = ":";

	public String parceFacultyName(String input) {
		String[] facultyData = input.split(MAIN_SEPARATOR);
		return facultyData[0];
	}

	public String parceFacultysUniversityName(String input) {
		String[] facultyData = input.split(MAIN_SEPARATOR);
		return facultyData[1];

	}
}
