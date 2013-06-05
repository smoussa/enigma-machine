
import java.util.ArrayList;
import java.util.Iterator;

public class TestHarness extends EnigmaMachine {
	
	private EnigmaFile enigmaFile;
	
	/**
	 * Start test one.
	 */
	public void test1() {
		
		addReflector(new Reflector("I"));
		addRotor(new BasicRotor("I"), 0);
		addRotor(new BasicRotor("II"), 1);
		addRotor(new BasicRotor("III"), 2);
		setPosition(0, 6);
		setPosition(1, 12);
		setPosition(2, 5);
		addPlug('A','M');
		addPlug('G','L');
		addPlug('E','T');
		
		System.out.print(encodeLetter('G'));
		System.out.print(encodeLetter('F'));
		System.out.print(encodeLetter('W'));
		System.out.print(encodeLetter('I'));
		System.out.print(encodeLetter('Q'));
		System.out.print(encodeLetter('H'));
		
	}
	
	/**
	 * Start test two.
	 */
	public void test2() {
		
		addReflector(new Reflector("II"));
		addRotor(new BasicRotor("IV"), 0);
		addRotor(new BasicRotor("V"), 1);
		addRotor(new BasicRotor("II"), 2);
		setPosition(0, 23);
		setPosition(1, 4);
		setPosition(2, 9);
		addPlug('B','C');
		addPlug('R','I');
		addPlug('S','M');
		addPlug('A','F');
		
		System.out.print(encodeLetter('G'));
		System.out.print(encodeLetter('A'));
		System.out.print(encodeLetter('C'));
		System.out.print(encodeLetter('I'));
		System.out.print(encodeLetter('G'));
		
	}
	
	/**
	 * Start test three.
	 */
	public void test3() {
		
		TurnoverRotor tr2 = new TurnoverRotor("III", null);
		TurnoverRotor tr1 = new TurnoverRotor("II", tr2);
		TurnoverRotor tr0 = new TurnoverRotor("I", tr1);
		
		addReflector(new Reflector("I"));
		addRotor(tr0, 0);
		addRotor(tr1, 1);
		addRotor(tr2, 2);
		setPosition(0, 23);
		setPosition(1, 11);
		setPosition(2, 7);
		addPlug('Q','F');
		
		enigmaFile = new EnigmaFile();
		enigmaFile.encryptOrDecrypt(this);
		
	}
	
	/**
	 * Start the test given by the Dean of the faculty.
	 */
	public void deanTest() {
		
		addReflector(new Reflector("I"));
		addRotor(new BasicRotor("I"), 0);
		addRotor(new BasicRotor("V"), 1);
		addRotor(new BasicRotor("III"), 2);
		setPosition(0, 25);
		setPosition(1, 10);
		setPosition(2, 11);
		addPlug('W','E');
		addPlug('N','D');
		addPlug('Y','H');
		addPlug('A','L');
		
		enigmaFile = new EnigmaFile();
		enigmaFile.encryptOrDecrypt(this);
		
	}
	
	/**
	 * Start the custom Enigma Machine test using the command line interface.
	 * @param reflector The reflector type.
	 * @param rotorType The type of set of rotors to be used. These are either turnover rotors or basic rotors.
	 * @param rotorSlot0 The rotor to be placed in slot0.
	 * @param rotorSlot1 The rotor to be placed in slot1.
	 * @param rotorSlot2 The rotor to be placed in slot2.
	 * @param pos0 The set position of the rotor in slot0.
	 * @param pos1 The set position of the rotor in slot1.
	 * @param pos2 The set position of the rotor in slot2.
	 * @param plugs The array list of plugs to be added.
	 */
	public void customTest(String reflector, int rotorType, String rotorSlot0,
			String rotorSlot1, String rotorSlot2, int pos0, int pos1, int pos2,
			ArrayList<Plug> plugs) {
		
		addReflector(new Reflector(reflector));
		
		if (rotorType == 1) {
			addRotor(new BasicRotor(rotorSlot0), 0);
			addRotor(new BasicRotor(rotorSlot1), 1);
			addRotor(new BasicRotor(rotorSlot2), 2);
		} else if (rotorType == 2) {
			TurnoverRotor tr2 = new TurnoverRotor(rotorSlot2, null);
			TurnoverRotor tr1 = new TurnoverRotor(rotorSlot1, tr2);
			TurnoverRotor tr0 = new TurnoverRotor(rotorSlot0, tr1);
			addRotor(tr0, 0);
			addRotor(tr1, 1);
			addRotor(tr2, 2);
		}
		
		setPosition(0, pos0);
		setPosition(1, pos1);
		setPosition(2, pos2);
		
		Iterator<Plug> itr = plugs.iterator();
		while (itr.hasNext()) {
			Plug p = itr.next();
			addPlug(p.getEnd1(), p.getEnd2());
		}
		
	}
	
	/**
	 * Start challenge one.
	 * @param i the missing end of the first plug.
	 * @param t the missing end of the second plug.
	 */
	public void challenge1(int i, int t) {
		
		addReflector(new Reflector("I"));
		addRotor(new BasicRotor("IV"), 0);
		addRotor(new BasicRotor("III"), 1);
		addRotor(new BasicRotor("II"), 2);
		setPosition(0, 8);
		setPosition(1, 4);
		setPosition(2, 21);
		addPlug('D',(char)(i + 65));
		addPlug('S',(char)(t + 65));
		
		enigmaFile = new EnigmaFile();
		enigmaFile.encryptOrDecrypt(this);
		
	}
	
	/**
	 * Start challenge two.
	 * @param i The missing position of the first rotor.
	 * @param j The missing position of the second rotor.
	 * @param k The missing position of the third rotor.
	 */
	public void challenge2(int i, int j, int k) {
		
		addReflector(new Reflector("I"));
		addRotor(new BasicRotor("V"), 0);
		addRotor(new BasicRotor("III"), 1);
		addRotor(new BasicRotor("II"), 2);
		setPosition(0, i);
		setPosition(1, j);
		setPosition(2, k);
		addPlug('H','L');
		addPlug('G','P');
		
		System.out.println("slot0 - " + i);
		System.out.println("slot1 - " + j);
		System.out.println("slot2 - " + k);
		
		enigmaFile = new EnigmaFile();
		enigmaFile.encryptOrDecrypt(this);
		
	}
	
}
