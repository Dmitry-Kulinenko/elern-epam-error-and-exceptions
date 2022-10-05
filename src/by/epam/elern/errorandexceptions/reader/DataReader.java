package by.epam.elern.errorandexceptions.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DataReader {

	public List<String> readListFromFile(String fileName) throws IOException {
		File file = new File(fileName);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> output = new LinkedList<>();

		String data = reader.readLine();
		do {
			output.add(data);
			data = reader.readLine();
		} while (data != null);

		return output;
	}

	public String readLineFromFile(String fileName) throws IOException {
		File file = new File(fileName);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));

		return reader.readLine();
	}
}
