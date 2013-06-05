
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EnigmaFile {
	
	/**
	 * Read from a file.
	 * @return the first line of the file
	 * @throws IOException file not found exception
	 */
	public String readFromFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("docs/input_file.txt"));
		String line = in.readLine();
		in.close();
		return line;
	}
	
	/**
	 * Write to a file.
	 * @param str the string to write
	 * @throws IOException file not found exception
	 */
	public void writeToFile(String str) throws IOException {
		BufferedWriter in = new BufferedWriter(new FileWriter("docs/output_file.txt"));
		in.write(str);
		in.close();
	}
	
	/**
	 * Format the given line to be accepted by the Enigma Machine.
	 * @param line The string to be formated
	 * @return the formatted string
	 */
	public String formatText(String line) {
		line = line.replaceAll("\\s+","").replaceAll("\\p{Punct}|\\d","").toUpperCase();
		return line;
	}
	
	/**
	 * Start the encryption/decryption process.
	 * @param testHarness the Enigma Machine that will be encoding the letters
	 */
	public void encryptOrDecrypt(TestHarness testHarness) {
		
		String line = null;
		
		try {
			
			line = readFromFile();
			line = formatText(line);
			
			StringBuffer str = new StringBuffer();
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
			    str.append(testHarness.encodeLetter(c));
			}
			
			writeToFile(str.toString());
		
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
			System.out.println("Could not find the file.");
		} catch (NullPointerException e) {
			System.err.println("Caught NullPointerException: " + e.getMessage());
			System.out.println("There was no string to read from the file.");
		}
		
	}

}
