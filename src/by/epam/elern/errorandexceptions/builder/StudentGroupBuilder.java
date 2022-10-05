package by.epam.elern.errorandexceptions.builder;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import by.epam.elern.errorandexceptions.entity.Student;
import by.epam.elern.errorandexceptions.entity.StudentGroup;
import by.epam.elern.errorandexceptions.exception.GroupHasNoStudentsException;
import by.epam.elern.errorandexceptions.parcer.StudentGroupDataParcer;
import by.epam.elern.errorandexceptions.reader.DataReader;

public class StudentGroupBuilder {

	public List<StudentGroup> createStudentGroupList(List<Student> students, String sourceName)
			throws GroupHasNoStudentsException, IOException {

		if (students == null || students.isEmpty()) {
			throw new GroupHasNoStudentsException("Отсутствие студентов в группе");
		}

		DataReader reader = new DataReader();
		StudentGroupDataParcer parcer = new StudentGroupDataParcer();
		List<String> studentGroupData = reader.readListFromFile(sourceName);

		List<StudentGroup> studentGroupList = new LinkedList<>();
		for (String studentData : studentGroupData) {
			Integer groupNumber = parcer.parceNumber(studentData);
			String facultyName = parcer.parceFacultyName(studentData);
			String universityName = parcer.parceUniversityName(studentData);
			List<Student> studentList = new LinkedList<>();

			for (Student student : students) {
				if (groupNumber == student.getGroupNumber()) {
					studentList.add(student);
				}
			}
			studentGroupList.add(new StudentGroup(groupNumber, studentList, universityName, facultyName));
		}
		return studentGroupList;
	}

}
