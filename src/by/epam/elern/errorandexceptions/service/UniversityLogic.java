package by.epam.elern.errorandexceptions.service;

import java.util.List;
import java.util.Map;

import by.epam.elern.errorandexceptions.entity.Course;
import by.epam.elern.errorandexceptions.entity.Faculty;
import by.epam.elern.errorandexceptions.entity.Student;
import by.epam.elern.errorandexceptions.entity.StudentGroup;
import by.epam.elern.errorandexceptions.entity.University;

public class UniversityLogic {
//grade point average-средний балл
	public double calculateStudentGPA(Student student) {
		double gpa = 0;
		double sum = 0;
		Map<Course, Integer> marks = student.getMarks();
		for (Map.Entry<Course, Integer> entry : marks.entrySet()) {
			sum += entry.getValue();
		}
		gpa = sum / marks.size();
		return gpa;
	}

	public double calculateGroupGPA(Course course, StudentGroup group) {
		double groupGPA = 0;
		double sum = 0;
		int studentThatHasACourse = 0;
		List<Student> students = group.getStudents();
		for (Student student : students) {
			Map<Course, Integer> marks = student.getMarks();
			for (Map.Entry<Course, Integer> entry : marks.entrySet()) {
				if (entry.getKey().equals(course)) {
					studentThatHasACourse++;
					sum += entry.getValue();
				}
			}

		}
		groupGPA = sum / studentThatHasACourse;
		return groupGPA;
	}

	public double calculateUniversityGPA(Course course, University university) {
		double universityGPA = 0;
		double universitySum = 0;
		List<Faculty> faculties = university.getFaculties();
		for (Faculty faculty : faculties) {
			double facultyGPA = 0;
			double facultySum = 0;
			List<StudentGroup> groups = faculty.getStudentGroups();
			for (StudentGroup studentGroup : groups) {
				facultySum += calculateGroupGPA(course, studentGroup);
			}
			facultyGPA = facultySum / groups.size();
			universitySum += facultyGPA;
		}
		universityGPA = universitySum / faculties.size();
		return universityGPA;
	}
}
