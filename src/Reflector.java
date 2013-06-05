
public class Reflector extends Rotor {
	
	private int[] map;
	
	public Reflector(String type) {
		map = new int[26];
		initialise(type);
	}

	@Override
	public void initialise(String type) {
		
		if (type.equals("I")) {
			map[0] = 24;
			map[1] = 17;
			map[2] = 20;
			map[3] = 7;
			map[4] = 16;
			map[5] = 18;
			map[6] = 11;
			map[7] = 3;
			map[8] = 15;
			map[9] = 23;
			map[10] = 13;
			map[11] = 6;
			map[12] = 14;
			map[13] = 10;
			map[14] = 12;
			map[15] = 8;
			map[16] = 4;
			map[17] = 1;
			map[18] = 5;
			map[19] = 25;
			map[20] = 2;
			map[21] = 22;
			map[22] = 21;
			map[23] = 9;
			map[24] = 0;
			map[25] = 19;
		} else if (type.equals("II")) {
			map[0] = 5;
			map[1] = 21;
			map[2] = 15;
			map[3] = 9;
			map[4] = 8;
			map[5] = 0;
			map[6] = 14;
			map[7] = 24;
			map[8] = 4;
			map[9] = 3;
			map[10] = 17;
			map[11] = 25;
			map[12] = 23;
			map[13] = 22;
			map[14] = 6;
			map[15] = 2;
			map[16] = 19;
			map[17] = 10;
			map[18] = 20;
			map[19] = 16;
			map[20] = 18;
			map[21] = 1;
			map[22] = 13;
			map[23] = 12;
			map[24] = 7;
			map[25] = 11;
		}
		
	}

	@Override
	public int substitute(int n) {
		return map[n];
	}

}
