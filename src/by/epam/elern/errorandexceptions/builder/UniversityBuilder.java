package by.epam.elern.errorandexceptions.builder;

import java.io.IOException;
import java.util.List;

import by.epam.elern.errorandexceptions.entity.Faculty;
import by.epam.elern.errorandexceptions.entity.University;
import by.epam.elern.errorandexceptions.exception.UniversityHasNoFacultiesException;
import by.epam.elern.errorandexceptions.reader.DataReader;

public class UniversityBuilder {
	public University createUniversity(List<Faculty> faculties, String sourceName)
			throws UniversityHasNoFacultiesException, IOException {

		if (faculties == null || faculties.isEmpty()) {
			throw new UniversityHasNoFacultiesException("Отсутствие факультетов в университете");
		}

		DataReader reader = new DataReader();
		String universityName = reader.readLineFromFile(sourceName);

		return new University(universityName, faculties);
	}
}
