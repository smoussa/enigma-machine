import java.io.IOException;


public class EnigmaMachine {
	
	private Plugboard plugboard;
	private BasicRotor[] rotorArray;
	private Reflector reflector;
	
	public EnigmaMachine() {
		plugboard = new Plugboard();
		rotorArray = new BasicRotor[3];
	}
	
	/**
	 * Add a new plug.
	 * @param end1 the first end of the plug
	 * @param end2 the other end of the plug
	 */
	public void addPlug(char end1, char end2) {
		if (!plugboard.addPlug(end1, end2)) {
			System.out.println("Sorry could not add plug. It clashes with another.");
		}
	}
	
	/**
	 * Clear the plugboard.
	 */
	public void clearPlugboard() {
		plugboard.clear();
	}
	
	/**
	 * Add a rotor.
	 * @param basicRotor the rotor to add
	 * @param slot the slot number the rotor will be placed in
	 */
	public void addRotor(BasicRotor basicRotor, int slot) {
		if (rotorArray[0] != basicRotor || rotorArray[1] != basicRotor || rotorArray[2] != basicRotor) {
			rotorArray[slot] = basicRotor;
		} else {
			System.out.println("Cannot add two rotors of the same type.");
		}
	}
	
	/**
	 * Get the rotor
	 * @param slot the rotor in that slot
	 * @return the rotor
	 */
	public BasicRotor getRotor(int slot) {
		return rotorArray[slot];
	}
	
	/**
	 * Add a reflector.
	 * @param reflector the reflector to add
	 */
	public void addReflector(Reflector reflector) {
		this.reflector = reflector;
	}
	
	/**
	 * Get reflector.
	 * @return the reflector
	 */
	public Reflector getReflector() {
		return reflector;
	}
	
	/**
	 * Set the position of the rotor.
	 * @param slot the slot number of the rotor
	 * @param position the position to set
	 */
	public void setPosition(int slot, int position) {
		rotorArray[slot].setPosition(position);
	}
	
	/**
	 * Encode the letter using the Enigma Machine.
	 * @param letter the letter to encode
	 * @return the coded letter
	 */
	public char encodeLetter(char letter) {
		
		int n = ((int) plugboard.test(letter)) - 65;
		
		n = getRotor(0).substitute(n);
		n = getRotor(1).substitute(n);
		n = getRotor(2).substitute(n);
		n = reflector.substitute(n);
		n = getRotor(2).substituteBack(n);
		n = getRotor(1).substituteBack(n);
		n = getRotor(0).substituteBack(n);
		getRotor(0).rotate();
		
		return plugboard.test((char) (n + 65));
	}
	
	/**
	 * Start the different tests by uncommenting the test methods.
	 * @throws StringIndexOutOfBoundsException
	 * @throws IOException
	 */
	public void start() {
		
		TestHarness test = new TestHarness(); 
		//CLI cli = new CLI(); // Command Line Interface
		
		test.test1();
		//test.test2();
		//test.test3();
		//cli.start();
		//startChallenge1();
		//startChallenge2();
		
	}
	
	/**
	 * Starts challenge number one. This needs its own method to create new TestHarness instances.
	 */
	public void startChallenge1() {
		
		TestHarness test = new TestHarness();
		
		int charNum1 = ((int) 'D') - 65;
		int charNum2 = ((int) 'S') - 65;
		for (int i = 0; i <= 25; i++) {
			for (int t = 0; t <= 25; t++) {
				if (t != i || charNum1 != i || charNum1 != t ||
						charNum2 != i || charNum2 != t) {
					test = new TestHarness();
					test.challenge1(i, t);
				}
			}
		}
		
	}
	
	/**
	 * Starts challenge number two. This needs its own method to create new TestHarness instances.
	 */
	public void startChallenge2() {
		
		TestHarness test = new TestHarness();
		
		for (int i = 0; i <= 25; i++) {
			for (int j = 0; j <= 25; j++) {
				for (int k = 0; k <= 25; k++) {
					test = new TestHarness();
					test.challenge2(i, j, k);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		EnigmaMachine em = new EnigmaMachine();
		em.start();
		
	}

}
