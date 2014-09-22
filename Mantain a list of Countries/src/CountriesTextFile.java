import java.util.*;
import java.io.*;
import java.nio.file.*;

public class CountriesTextFile {
	private ArrayList<String> countries = null;
	private Path countriesPath = null;
	private File countriesFile = null;

	public CountriesTextFile() {
		countriesPath = Paths.get("countries.txt");
		countriesFile = countriesPath.toFile();
		countries = this.getCountries();

	}

	public ArrayList<String> getCountries() {
		// if the customers file has already been read, don't read it again
		if (countries != null)
			return countries;

		countries = new ArrayList<>();

		if (Files.exists(countriesPath)) // prevent the FileNotFoundException
		{
			try (BufferedReader in = new BufferedReader(new FileReader(
					countriesFile))) {
				// read all products stored in the file
				// into the array list
				String line = in.readLine();
				while (line != null) {

					String countryName = line;
					countries.add(countryName);

					line = in.readLine();
				}
			} catch (IOException e) {
				System.out.println(e);
				return null;
			}
		}

		return countries;
	}

	public boolean addCountry(String c) {
		countries.add(c);
		return this.saveCountry();
	}

	public boolean deleteCountry(String c) {
		countries.remove(c);
		return this.saveCountry();
	}

	private boolean saveCountry() {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(countriesFile)))) {

			for (String count : countries) {

				out.println(count);

			}
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}

		return true;
	}
}