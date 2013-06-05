
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	
	private ArrayList<Plug> plugs;
	
	public CLI() {
		plugs = new ArrayList<Plug>();
	}
	
	/**
	 * Format the given line to be accepted by the Enigma Machine.
	 * @param line The string to be formated
	 * @return the formatted string
	 */
	public String formatText(String line) {
		return line.replaceAll("\\s+","").replaceAll("\\p{Punct}|\\d","").toUpperCase();
	}
	
	/**
	 *Read input from the console
	 * @return the string typed in
	 * @throws IOException
	 */
	public Scanner getInput() throws IOException {
		return new Scanner(System.in);
	}
	
	/**
	 * Get the rotor type from the given option
	 * @param num The option number chosen by the user
	 * @return the rotor type
	 */
	public String getRotor(int num) {
		
		String option = null;
		switch (num) {
			case 1: option = "I";
			break;
			case 2: option = "II";
			break;
			case 3: option = "III";
			break;
			case 4: option = "IV";
			break;
			case 5: option = "V";
			break;
		}
		
		return option;
	}
	
	/**
	 * Start the custom Enigma Machine.
	 * @throws IOException throws a file not found exception
	 * @throws StringIndexOutOfBoundsException throws a non-valid input string
	 */
	public void start() {
		
		try {
		
			System.out.println("Welcome, here you can create a custom Enigma Machine.\n");
			
			System.out.println("Choose a reflector by entering a number.");
			System.out.println("1 : Reflector I");
			System.out.println("2 : Reflector II");
			String reflector = getRotor(getInput().nextInt());
			
			System.out.println("Which set of the following will you be using?");
			System.out.println("1 : Basic rotors");
			System.out.println("2 : Turnover rotors");
			int rotorType = getInput().nextInt();
			
			String[] slots = new String[3];
			for (int i = 0; i <= 2; i++) {
				System.out.println("For slot " + i + ", choose a rotor by entering a number.");
				if (rotorType == 1) {
					System.out.println("1 : Basic Rotor I");
					System.out.println("2 : Basic Rotor II");
					System.out.println("3 : Basic Rotor III");
					System.out.println("4 : Basic Rotor IV");
					System.out.println("5 : Basic Rotor V");
				} else if (rotorType == 2) {
					System.out.println("1 : Turnover Rotor I");
					System.out.println("2 : Turnover Rotor II");
					System.out.println("3 : Turnover Rotor III");
					System.out.println("4 : Turnover Rotor IV");
					System.out.println("5 : Turnover Rotor V");
				}
				slots[i] = getRotor(getInput().nextInt());
			}
			
			int[] positions = new int[3];
			for (int i = 0; i <= 2; i++) {
				System.out.println("What position do you want to set the rotor in slot " + i + "?");
				positions[i] = getInput().nextInt();
			}
			
			boolean addingPlugs = true;
			do {
				System.out.println("Would you like to add a plug?");
				System.out.println("1 : Yes");
				System.out.println("2 : No");
				int option = getInput().nextInt();
				
				if (option == 1) {
					System.out.println("What will the first end character of the plug be?");
					char end1 = formatText(getInput().next()).charAt(0);
					System.out.println("What will the second end character of the plug be?");
					char end2 = formatText(getInput().next()).charAt(0);
					plugs.add(new Plug(end1, end2));
				} else if (option == 2) {
					addingPlugs = false;
				}
			} while (addingPlugs == true);
			
			TestHarness test = new TestHarness();
			test.customTest(reflector, rotorType, slots[0], slots[1], slots[2],
					positions[0], positions[1], positions[2], plugs);
			
			System.out.println("Now feel free to code letters by typing them in.\n" +
					"This machine will only take the first letter you type in.");
			
			do {
				char c = formatText(getInput().next()).charAt(0);
				System.out.println(" -> " + test.encodeLetter(c));
			} while (true);
			
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
			System.out.println("Could not read the input.");
		} catch (InputMismatchException e) {
			System.err.println("Caught InputMismatchException: " + e.getMessage());
			System.out.println("Wrong input.");
		} catch (StringIndexOutOfBoundsException e) {
			System.err.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
			System.out.println("Sorry, you entered the wrong input. Input must be a letter.");
		}
		
	}
	
}
