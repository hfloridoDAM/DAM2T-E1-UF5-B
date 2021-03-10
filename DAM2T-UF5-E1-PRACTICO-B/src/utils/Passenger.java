package utils;

import exceptions.MyException;

public enum Passenger {
	TURIST("T"), STUDENT("S"), WORKER("W");
	
	private String av;
	
	private Passenger(String av) {
		this.av = av;
	}
	
	public String getAv() {
		return this.av;
	}
	
	public static Passenger setPassenger(String p) throws MyException {
		switch (p.toUpperCase()) {
			case "T":
				return TURIST;
			case "W":
				return WORKER;
			case "S":
				return STUDENT;
			default: 
				throw new MyException (MyException.WRONG_INPUT);
		}
	}

}
