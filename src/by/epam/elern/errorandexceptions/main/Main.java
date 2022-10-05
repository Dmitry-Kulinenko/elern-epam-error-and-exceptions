/* В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. 
 * У каждого студента есть несколько учебных предметов по которым он получает оценки.
 * Необходимо реализовать иерархию студентов, групп и факультетов.
 * 
 * Посчитать средний балл по всем предметам студента
 * Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
 * Посчитать средний балл по предмету для всего университета
 * Релизовать следующие исключения:
 * Оценка ниже 0 или выше 10
 * Отсутсвие предметов у студента (должен быть хотя бы один)
 * Отсутствие студентов в группе
 * Отсутствие групп на факультете
 * Отсутствие факультетов в университете
 * */

package by.epam.elern.errorandexceptions.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import by.epam.elern.errorandexceptions.builder.FacultyBuilder;
import by.epam.elern.errorandexceptions.builder.StudentBuilder;
import by.epam.elern.errorandexceptions.builder.StudentGroupBuilder;
import by.epam.elern.errorandexceptions.builder.UniversityBuilder;
import by.epam.elern.errorandexceptions.entity.Course;
import by.epam.elern.errorandexceptions.entity.Faculty;
import by.epam.elern.errorandexceptions.entity.Student;
import by.epam.elern.errorandexceptions.entity.StudentGroup;
import by.epam.elern.errorandexceptions.entity.University;
import by.epam.elern.errorandexceptions.exception.FacultyHasNoGroupsException;
import by.epam.elern.errorandexceptions.exception.GroupHasNoStudentsException;
import by.epam.elern.errorandexceptions.exception.UniversityHasNoFacultiesException;
import by.epam.elern.errorandexceptions.service.UniversityLogic;

public class Main {
	public static void main(String[] args) {

		StudentBuilder studentBuilder = new StudentBuilder();
		StudentGroupBuilder groupBuilder = new StudentGroupBuilder();
		FacultyBuilder facultyBuilder = new FacultyBuilder();
		UniversityBuilder universityBuilder = new UniversityBuilder();

		List<Student> students = null;
		String studentFileName = "resources\\Students.txt";
		try {
			students = studentBuilder.createStudentList(studentFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<StudentGroup> groups = null;
		String studentGroupFileName = "resources\\Groups.txt";
		try {
			groups = groupBuilder.createStudentGroupList(students, studentGroupFileName);
			groupBuilder.createStudentGroupList(null, studentGroupFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (GroupHasNoStudentsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Faculty> faculties = null;
		String facultiesFileName = "resources\\Faculties.txt";
		try {
			faculties = facultyBuilder.createFacultyList(groups, facultiesFileName);
			facultyBuilder.createFacultyList(null, facultiesFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FacultyHasNoGroupsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		University university = null;
		String universityFileName = "resources\\University.txt";
		try {
			university = universityBuilder.createUniversity(faculties, universityFileName);
			universityBuilder.createUniversity(null, universityFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UniversityHasNoFacultiesException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		UniversityLogic logic = new UniversityLogic();

		System.out.printf("%s %s: %.3f\n", "Средний балл студента ", students.get(0),
				logic.calculateStudentGPA(students.get(0)));
		System.out.printf("%s %s %s %s %.3f\n", "Средний балл группы ", groups.get(0).getNumber(), " по предмету ",
				Course.MATH, logic.calculateGroupGPA(Course.MATH, groups.get(0)));
		System.out.printf("%s %s %s %s %.3f\n", "Средний балл университета ", university.getName(), " по предмету ",
				Course.MATH, logic.calculateUniversityGPA(Course.MATH, university));

	}
}
