
public class TurnoverRotor extends BasicRotor {
	
	private int turnoverPosition;
	private BasicRotor nextRotor;
	
	public TurnoverRotor(String type, BasicRotor nextRotor) {
		super(type);
		setTurnoverPosition(type);
		this.nextRotor = nextRotor;
	}
	
	/**
	 * Sets the turnover position of the given rotor type.
	 * @param type - the type of rotor
	 */
	public void setTurnoverPosition(String type) {
		
		if (type.equals("I")) {
			turnoverPosition = 24;
		} else if (type.equals("II")) {
			turnoverPosition = 12;
		} else if (type.equals("III")) {
			turnoverPosition = 3;
		} else if (type.equals("IV")) {
			turnoverPosition = 17;
		} else if (type.equals("V")) {
			turnoverPosition = 7;
		}
		
	}
	
	/**
	 * Gets the turnover position of the rotor.
	 * @return the turnover position
	 */
	public int getTurnoverPosition() {
		return turnoverPosition;
	}
	
	@Override
	public void rotate() {
		
		if (getPosition() != 25) {
			setPosition(getPosition() + 1);
			if (getPosition() == getTurnoverPosition()) {
				nextRotor.rotate();
			}
		} else {
			setPosition(0);
		}
		
	}

}
