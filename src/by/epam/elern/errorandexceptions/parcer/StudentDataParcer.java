package by.epam.elern.errorandexceptions.parcer;

import java.util.HashMap;
import java.util.Map;

import by.epam.elern.errorandexceptions.entity.Course;
import by.epam.elern.errorandexceptions.exception.MarkOutOfRangeException;
import by.epam.elern.errorandexceptions.exception.StudentHasNoCoursesException;
import by.epam.elern.errorandexceptions.validator.DataValidator;

public class StudentDataParcer {
	private static final String SEPARATOR = ";";
	private static final String PAIR_SEPARATOR = ",";
	private static final String KEY_VALUE_SEPARATOR = ":";
	DataValidator validator = new DataValidator();

	public String parceName(String input) {
		String[] studentDataArray = input.split(SEPARATOR);
		return studentDataArray[0];
	}

	public Integer parceGroupNumber(String input) {
		String[] studentDataArray = input.split(SEPARATOR);
		return Integer.parseInt(studentDataArray[2]);
	}

	public String parceFacultyName(String input) {
		String[] studentDataArray = input.split(SEPARATOR);
		return studentDataArray[3];
	}

	public String parceUniversityName(String input) {
		String[] studentDataArray = input.split(SEPARATOR);
		return studentDataArray[4];
	}

	public Map<Course, Integer> parceMarks(String input) throws StudentHasNoCoursesException, MarkOutOfRangeException {
		DataValidator validator = new DataValidator();
		String[] studentDataArray = input.split(SEPARATOR);
		String marksData = studentDataArray[1];
		if (validator.studentHasNoCourse(marksData)) {
			throw new StudentHasNoCoursesException();
		}

		Map<Course, Integer> marks = new HashMap<>();

		String[] pairs = marksData.split(PAIR_SEPARATOR);
		for (String pair : pairs) {
			String[] courseMark = pair.split(KEY_VALUE_SEPARATOR);
			Course course = Course.valueOf(courseMark[0]);

			Integer mark = Integer.parseInt(courseMark[1]);
			if (!validator.markIsValid(mark)) {
				throw new MarkOutOfRangeException();
			}
			marks.put(course, mark);
		}
		return marks;
	}

}
