
import java.util.ArrayList;
import java.util.Iterator;

public class Plugboard {
	
	private static ArrayList<Plug> plugList;
	
	public Plugboard() {
		plugList = new ArrayList<Plug>();
	}
	
	/**
	 * Add a new plug to the plugboard.
	 * This method also checks if there is a clash with another plug.
	 * @param end1 - one end of the plug
	 * @param end2 - the other the end of the plug
	 * @return true if the plug was successfully inserted into the plugboard
	 */
	public boolean addPlug(char end1, char end2) {
		
		Plug newPlug = new Plug(end1, end2);
		boolean plugInserted = false;
		
		if (plugList.isEmpty()) {
			
			plugList.add(newPlug);
			plugInserted = true;
			
		} else {
			
			Iterator<Plug> itr = plugList.iterator();
			while (itr.hasNext() && !itr.next().clashesWith(newPlug)) {
					plugInserted = true;
			}
			
			if (plugInserted) {
				plugList.add(newPlug);
			}
			
		}
		
		return plugInserted;
	}
	
	/**
	 * If there is a plug in the plugboard corresponding to that letter,
	 * the method returns the letter at the other end of the plug.
	 * Otherwise, the same letter is returned.
	 * @param letterIn - the letter to convert if there is a plug
	 * @return the character at the end of plug if a plug is inserted
	 */
	public char test(char letterIn) {
		
		Iterator<Plug> itr = plugList.iterator();
		if (!plugList.isEmpty()) {
			while (itr.hasNext()) {
				letterIn = itr.next().test(letterIn);
			}
		}
		
		return letterIn;
	}
	
	/**
	 * Gets the number of plugs inserted into the plugboard.
	 * @return the number of plugs
	 */
	public int getNumPlugs() {
		return plugList.size();
	}
	
	/**
	 * Clears the plugboard of any plugs.
	 */
	public void clear() {
		plugList.clear();
	}
	
}
