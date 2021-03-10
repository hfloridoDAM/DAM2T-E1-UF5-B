package model;

import java.util.ArrayList;

import exceptions.MyException;
import utils.Passenger;

public class Stop implements Comparable<Stop> {
	private Passenger passenger;
	private int id;
	
	public Stop(int id, Passenger passenger) {
		this.id = id;
		this.passenger = passenger;
	}
	
	private void checkPassengers(ArrayList<Passenger> passengers) throws MyException {
		System.out.println("");
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public int compareTo(Stop arg0) {
		return this.id - arg0.getId();
	}

	@Override
	public String toString() {
		return passenger.getAv();
	}
	
	
}
