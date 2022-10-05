package by.epam.elern.errorandexceptions.validator;

public class DataValidator {
	public boolean markIsValid(Integer mark) {
		return mark >= 0 && mark <= 10;
	}

	public boolean studentHasNoCourse(String marksData) {
		return marksData == null || marksData.isBlank();
	}
}
