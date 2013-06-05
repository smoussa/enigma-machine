
public class BasicRotor extends Rotor {
	
	private int[] map;
	private int[] inverseMap;
	
	public BasicRotor(String type) {
		map = new int[26];
		inverseMap = new int[26];
		initialise(type);
	}

	@Override
	public void initialise(String type) {
		
		if (type.equals("I")) {
			map[0] = 4;
			map[1] = 10;
			map[2] = 12;
			map[3] = 5;
			map[4] = 11;
			map[5] = 6;
			map[6] = 3;
			map[7] = 16;
			map[8] = 21;
			map[9] = 25;
			map[10] = 13;
			map[11] = 19;
			map[12] = 14;
			map[13] = 22;
			map[14] = 24;
			map[15] = 7;
			map[16] = 23;
			map[17] = 20;
			map[18] = 18;
			map[19] = 15;
			map[20] = 0;
			map[21] = 8;
			map[22] = 1;
			map[23] = 17;
			map[24] = 2;
			map[25] = 9;
		} else if (type.equals("II")) {
			map[0] = 0;
			map[1] = 9;
			map[2] = 3;
			map[3] = 10;
			map[4] = 18;
			map[5] = 8;
			map[6] = 17;
			map[7] = 20;
			map[8] = 23;
			map[9] = 1;
			map[10] = 11;
			map[11] = 7;
			map[12] = 22;
			map[13] = 19;
			map[14] = 12;
			map[15] = 2;
			map[16] = 16;
			map[17] = 6;
			map[18] = 25;
			map[19] = 13;
			map[20] = 15;
			map[21] = 24;
			map[22] = 5;
			map[23] = 21;
			map[24] = 14;
			map[25] = 4;
		} else if (type.equals("III")) {
			map[0] = 1;
			map[1] = 3;
			map[2] = 5;
			map[3] = 7;
			map[4] = 9;
			map[5] = 11;
			map[6] = 2;
			map[7] = 15;
			map[8] = 17;
			map[9] = 19;
			map[10] = 23;
			map[11] = 21;
			map[12] = 25;
			map[13] = 13;
			map[14] = 24;
			map[15] = 4;
			map[16] = 8;
			map[17] = 22;
			map[18] = 6;
			map[19] = 0;
			map[20] = 10;
			map[21] = 12;
			map[22] = 20;
			map[23] = 18;
			map[24] = 16;
			map[25] = 14;
		} else if (type.equals("IV")) {
			map[0] = 4;
			map[1] = 18;
			map[2] = 14;
			map[3] = 21;
			map[4] = 15;
			map[5] = 25;
			map[6] = 9;
			map[7] = 0;
			map[8] = 24;
			map[9] = 16;
			map[10] = 20;
			map[11] = 8;
			map[12] = 17;
			map[13] = 7;
			map[14] = 23;
			map[15] = 11;
			map[16] = 13;
			map[17] = 5;
			map[18] = 19;
			map[19] = 6;
			map[20] = 10;
			map[21] = 3;
			map[22] = 2;
			map[23] = 12;
			map[24] = 22;
			map[25] = 1;
		} else if (type.equals("V")) {
			map[0] = 21;
			map[1] = 25;
			map[2] = 1;
			map[3] = 17;
			map[4] = 6;
			map[5] = 8;
			map[6] = 19;
			map[7] = 24;
			map[8] = 20;
			map[9] = 15;
			map[10] = 18;
			map[11] = 3;
			map[12] = 13;
			map[13] = 7;
			map[14] = 11;
			map[15] = 23;
			map[16] = 0;
			map[17] = 22;
			map[18] = 12;
			map[19] = 9;
			map[20] = 16;
			map[21] = 14;
			map[22] = 5;
			map[23] = 4;
			map[24] = 2;
			map[25] = 10;
		}
		
		for (int i = 0; i != 26; i++) {
			inverseMap[map[i]] = i;
		}
		
	}

	@Override
	public int substitute(int n) {
		
		int index = n - getPosition();
		if (index < 0) {
			index += 26;
		}
		
		int number = map[index] + getPosition();
		
		if (number > 25) {
			number -= 26;
		}
		
		return number;
	}
	
	/**
	 * Substitutes an encoded letter to its true equivalent.
	 * @param n - the integer representation of the letter
	 * @return the true equivalent
	 */
	public int substituteBack(int n) {
		
		int index = n - getPosition();
		if (index < 0) {
			index += 26;
		}
		
		int number = inverseMap[index] + getPosition();
		
		if (number > 25) {
			number -= 26;
		}
		
		return number;
	}
	
	/**
	 * Rotates the rotor position by one.
	 */
	public void rotate() {
		
		if (getPosition() != 25) {
			setPosition(getPosition() + 1);
		} else {
			setPosition(0);
		}
		
	}

}
