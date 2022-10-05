package by.epam.elern.errorandexceptions.parcer;

public class StudentGroupDataParcer {
	private static final String PARAMETER_SEPARATOR = ",";
	private static final String MAIN_SEPARATOR = ":";

	public Integer parceNumber(String input) {
		String[] groupInfo = input.split(MAIN_SEPARATOR);
		String groupNumber = groupInfo[0];

		return Integer.parseInt(groupNumber);
	}

	public String parceFacultyName(String input) {
		String[] groupInfo = input.split(MAIN_SEPARATOR);
		String[] groupParameters = groupInfo[1].split(PARAMETER_SEPARATOR);

		return groupParameters[0];
	}

	public String parceUniversityName(final String input) {
		String[] groupInfo = input.split(MAIN_SEPARATOR);
		String[] groupParameters = groupInfo[1].split(PARAMETER_SEPARATOR);

		return groupParameters[1];
	}

}
