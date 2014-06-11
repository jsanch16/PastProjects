// DO NOT ADD NEW METHODS OR DATA FIELDS!

package PJ3;

class Car {
	private int id;
	private int duration;
	private int arrive;

	Car() {
		// add statements
		id = 0;
		duration = 0;
		arrive = 0;
	}

	Car(int carid, int serviceDuration, int arrivalTime) {
		// add statements
		id = carid;
		duration = serviceDuration;
		arrive = arrivalTime;
	}

	int getDuration() {
		// add statements
		return duration;
	}

	int getArrive() {
		// add statements
		return arrive;
	}

	int getID() {
		return id;
	}

	public String toString() {
		return "" + id + ":" + duration + ":" + arrive;

	}

	public static void main(String[] args) {
		// quick check!
		Car mycar = new Car(20, 30, 40);
		System.out.println("Car Info:" + mycar);

	}
}
