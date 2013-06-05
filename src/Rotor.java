
public abstract class Rotor {
	
	private int position;
	
	/**
	 * Set the position of the rotor.
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Get the current position of the rotor.
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * Initialises the mapping for the rotor based on its type.
	 * @param type - the type of rotor
	 */
	public abstract void initialise(String type);
	
	/**
	 * Substitutes a letter to the encoded equivalent.
	 * @param n - the integer representation of the letter
	 * @return the coded equivalent
	 */
	public abstract int substitute(int n);
	
}
