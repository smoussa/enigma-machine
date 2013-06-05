
public class Plug {
	
	private char end1;
	private char end2;
	
	public Plug(char end1, char end2) {
		this.end1 = end1;
		this.end2 = end2;
	}
	
	/**
	 * Gets the first end of the plug.
	 * @return the character at the end of the plug
	 */
	public char getEnd1() {
		return end1;
	}
	
	/**
	 * Gets the second end of the plug.
	 * @return the character at the end of the plug
	 */
	public char getEnd2() {
		return end2;
	}
	
	/**
	 * If there is a plug corresponding to that letter,
	 * the method returns the letter at the other end of the plug.
	 * Otherwise, the same letter is returned.
	 * @param letterIn - the letter to convert if there is a plug
	 * @return the character at the end of plug if a plug is inserted
	 */
	public char test(char letterIn) {
		
		if (letterIn == end1) {
			letterIn = end2;
		} else if (letterIn == end2) {
			letterIn = end1;
		}
		
		return letterIn;
	}
	
	/**
	 * Checks whether two plugs clash.
	 * @param plugin - the plug to compare to
	 * @return true if there is a clash
	 */
	public boolean clashesWith(Plug plugin) {
		
		boolean clashes = false;
		
		if (plugin.getEnd1() == end1 || plugin.getEnd1() == end2
				|| plugin.getEnd2() == end1 || plugin.getEnd2() == end2) {
			clashes = true;
		}
		
		return clashes;
	}

}
