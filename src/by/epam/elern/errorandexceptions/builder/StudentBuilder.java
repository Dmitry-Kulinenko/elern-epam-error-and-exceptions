package by.epam.elern.errorandexceptions.builder;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import by.epam.elern.errorandexceptions.entity.Course;
import by.epam.elern.errorandexceptions.entity.Student;
import by.epam.elern.errorandexceptions.exception.MarkOutOfRangeException;
import by.epam.elern.errorandexceptions.exception.StudentHasNoCoursesException;
import by.epam.elern.errorandexceptions.parcer.StudentDataParcer;
import by.epam.elern.errorandexceptions.reader.DataReader;

public class StudentBuilder {
	// Обработка исключений происходит в этом классе потому, что если выбросить
	// исключение в main, studentBuilder не создаст список студентов. То есть из-за
	// одной строки с невалидными данными не будет работать остальное приложение.
	public List<Student> createStudentList(String sourceName) throws IOException {
		DataReader reader = new DataReader();
		List<String> studentsData = reader.readListFromFile(sourceName);

		List<Student> studentList = new LinkedList<>();

		for (String student : studentsData) {
			try {
				studentList.add(createStudent(student));
			} catch (StudentHasNoCoursesException e) {
				System.err.println("Отсутсвие предметов у студента (должен быть хотя бы один)");
				e.printStackTrace();
			} catch (MarkOutOfRangeException e) {
				System.err.println("Оценка ниже 0 или выше 10");
				e.printStackTrace();
			}
		}
		return studentList;
	}

	private Student createStudent(String studentData) throws StudentHasNoCoursesException, MarkOutOfRangeException {
		StudentDataParcer parcer = new StudentDataParcer();

		String studentName = parcer.parceName(studentData);
		Map<Course, Integer> marks = parcer.parceMarks(studentData);
		Integer groupNumber = parcer.parceGroupNumber(studentData);
		String facultyName = parcer.parceFacultyName(studentData);
		String universityName = parcer.parceUniversityName(studentData);

		return new Student(studentName, universityName, facultyName, groupNumber, marks);

	}

}
