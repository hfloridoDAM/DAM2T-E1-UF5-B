package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import exceptions.MyException;
import model.Stop;
import utils.Passenger;

public class Manager {
	private ArrayList<Passenger> passengers;
	private TreeSet<Stop> stops;
	private String typoParada;
	
	public Manager () {
		this.passengers = new ArrayList<>();
		this.stops = new TreeSet<>();
	}

	public void start() {
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader("inputFiles\\lectura.txt"));
			boolean fin = false;
			while((line = br.readLine()) != null && !fin) {
				try {
					fin = menuOptions(line.split(" "));
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean menuOptions(String[] commands) throws MyException {
		if (commands[0].equalsIgnoreCase("PASSENGER")) {
			passengers.add(Passenger.setPassenger(commands[1]));
		} else if (commands[0].equalsIgnoreCase("END")) {
			printAll();
			return true;
		} else {
			if (commands.length != 3) throw new MyException(MyException.WRONG_NUM_PARAMS);
			checkPassengers(commands[1], Integer.valueOf(commands[2]));
			stops.add(new Stop(Integer.valueOf(commands[0]), Passenger.setPassenger(commands[1])));
			throw new MyException(MyException.P_OK);
		}
		return false;
	}
	
	private void checkPassengers(String tipo, Integer cantidad) throws MyException {
		int count = 0;
		for (Passenger p : passengers) {
			if (p.getAv().equalsIgnoreCase(tipo)) {
				count++;
			}
		}
		if (count < cantidad) throw new MyException(MyException.NO_P);
	}

	private void printAll() {
		for (Passenger p : passengers) {
			System.out.print(p.getAv() + " ");
		}
		System.out.println();
		for (Stop p : stops) {
			System.out.print(p.toString() + " ");
		}
	}

}
