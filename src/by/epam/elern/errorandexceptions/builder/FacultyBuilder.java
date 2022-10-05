package by.epam.elern.errorandexceptions.builder;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import by.epam.elern.errorandexceptions.entity.Faculty;
import by.epam.elern.errorandexceptions.entity.StudentGroup;
import by.epam.elern.errorandexceptions.exception.FacultyHasNoGroupsException;
import by.epam.elern.errorandexceptions.parcer.FacultyDataParcer;
import by.epam.elern.errorandexceptions.reader.DataReader;

public class FacultyBuilder {

	public List<Faculty> createFacultyList(List<StudentGroup> studentGroups, String sourceName)
			throws FacultyHasNoGroupsException, IOException {
		if (studentGroups == null || studentGroups.isEmpty()) {
			throw new FacultyHasNoGroupsException("Отсутствие групп на факультете");
		}
		DataReader reader = new DataReader();
		FacultyDataParcer parcer = new FacultyDataParcer();
		List<String> facultyData = reader.readListFromFile(sourceName);
		List<Faculty> facultyList = new LinkedList<>();

		for (String faculty : facultyData) {
			String facultyName = parcer.parceFacultyName(faculty);
			String facultysUniversityName = parcer.parceFacultysUniversityName(faculty);
			List<StudentGroup> facultysStudentGroup = new LinkedList<>();
			for (StudentGroup group : studentGroups) {
				if (facultyName.equals(group.getFacultyName())) {
					facultysStudentGroup.add(group);
				}
			}
			facultyList.add(new Faculty(facultyName, facultysStudentGroup, facultysUniversityName));
		}
		return facultyList;
	}

}
