package hospital;

public class Patient implements Comparable<Patient> {
	
	/*************************************************************
	 * data fields: names, age, id, time, priority
	 *************************************************************/
	private String name;
	private int age;
	private String id;
	private ArrivalTime time;
	private int priority; // on scale from 1 to 10, 1 being most urgent
	
	/*************************************************************
	 * full constructor: Patient(String, int, String, ArrivalTime, 
	 * int)
	 * @param name 		patient name
	 * @param age		patient age
	 * @param id		patient id
	 * @param time		patient arrival time
	 * @param priority 	patient level of priority
	 * @throws IllegalArgumentException if age is negative or 
	 * extremely high
	 * @throws IllegalArgumentException if priority level is not
	 * from 1 to 10
	 *************************************************************/
	public Patient(String name, int age, String id, ArrivalTime time, int priority) {
		if(age < 0 || age > 125) { 
			throw new IllegalArgumentException("Invalid age: " + age);
		}
		if(priority < 1 || priority > 10) {
			throw new IllegalArgumentException("Priority must be from 1-10: " + priority);
		}
		this.name = name;
		this.age = age;
		this.id = id;
		this.time = time;
		this.priority = priority;
	}
	
	/*************************************************************
	 * copy constructor: Patient(Patient)
	 * @param other 	Patient being copied
	 *************************************************************/
	public Patient(Patient other) {
		this(other.name, other.age, other.id, other.time, other.priority);
	}
	
	/*************************************************************
	 * compare the ages of two Patients
	 * @param p1 		Patient 1 being compared
	 * @param p2 		Patient 2 being compared
	 * @return a positive integer if p1 is older, a negative number
	 * if p2 is older, or 0 if the ages are equal
	 *************************************************************/
	public static int compareByAge(Patient p1, Patient p2) {
		if(p1.age != p2.age) {
			return p1.age - p2.age;
		} else if(p1.getLastName().compareTo(p2.getLastName()) != 0) {
			return p1.getLastName().compareTo(p2.getLastName());
		} else if(p1.getFirstName().compareTo(p2.getFirstName()) != 0) {
			return p1.getFirstName().compareTo(p2.getFirstName());
		} else if(p1.priority != p2.priority) {
			return p1.priority - p2.priority;
		} 
		return p1.time.compareTo(p2.time);
	}
	
	/*************************************************************
	 * compare the last names of two Patients in alphabetical order,
	 * if they are the same then compare by first name
	 * @param p1 		Patient 1 being compared
	 * @param p2 		Patient 2 being compared
	 * @return a negative number if p1's name comes first alphabetically, 
	 * a positive number if p2's name comes first alphabetically, 
	 * and 0 if p1 and p2 have the same name
	 *************************************************************/
	public static int compareByName(Patient p1, Patient p2) {
		if(p1.getLastName().compareTo(p2.getLastName()) != 0) {
			return p1.getLastName().compareTo(p2.getLastName());
		} else if(p1.getFirstName().compareTo(p2.getFirstName()) != 0) {
			return p1.getFirstName().compareTo(p2.getFirstName());
		} else if(p1.priority != p2.priority) {
			return p1.priority - p2.priority;
		} 
		return p1.time.compareTo(p2.time);
	}
	
	/*************************************************************
	 * compare the admitting priority of the current Patient to 
	 * another Patient
	 * @param other 	Patient being compared
	 * @return a negative number if current patient has lesser priority,
	 * a positive number if current patient has higher priority, 
	 * and 0 if both patients have the same priority level
	 *************************************************************/
	public int compareTo(Patient other) {
		if(this.priority != other.priority) {
			return this.priority - other.priority;
		}
		return this.time.compareTo(other.time);
	}
	
	/*************************************************************
	 * returns true if the contents of the current object is 
	 * equal to the contents of another object
	 * @param other 	Object being compared
	 * @return true if the contents of the current object is 
	 * equal to the contents of another object
	 *************************************************************/
	public boolean equals(Object other) {
		if(other instanceof Patient) {
			Patient newPatient = (Patient)other;
			return name.equals(newPatient.name) && age == newPatient.age && id.equals(newPatient.id)
					&& time.equals(newPatient.time) && priority == newPatient.priority;
		}
		return false;
	}
	
	/*************************************************************
	 * retrieve information in the age field
	 * @return age
	 *************************************************************/
	public int getAge() {
		return age;
	}
	
	/*************************************************************
	 * retrieve information in the time field
	 * @return arrival time
	 *************************************************************/
	public ArrivalTime getArrivalTime() {
		return time;
	}
	
	/*************************************************************
	 * return the first name of a Patient
	 * @return first name
	 *************************************************************/
	public String getFirstName() {
		String[] info = name.split(" ");
		String firstName = info[0];
		return firstName;
	}
	
	/*************************************************************
	 * retrieve information in the id field
	 * @return id
	 *************************************************************/
	public String getID() {
		return id;
	}
	
	/*************************************************************
	 * return the last name of a Patient
	 * @return last name
	 *************************************************************/
	public String getLastName() {
		String[] info = name.split(" ");
		String lastName = info[1];
		return lastName;
	}
	
	/*************************************************************
	 * retrieve information in the name field
	 * @return name
	 *************************************************************/
	public String getName() {
		return name;
	}
	
	/*************************************************************
	 * retrieve information in the priority field
	 * @return priority
	 *************************************************************/
	public int getPriority() {
		return priority;
	}
	
	/*************************************************************
	 * return the Patient record in comma separated format
	 * @return Patient record in comma separated format
	 *************************************************************/
	public String toFile() {
		return "" + name + ", " + age + ", " + id + ", " + time + ", " + priority;
	}
	
	/*************************************************************
	 * return the Patient record in an attractive format
	 * @return Patient record in an attractive format
	 *************************************************************/
	public String toString() {
		return 	  "Name:\t\t" + name + "\n"
				+ "Age:\t\t" + age + "\n"
				+ "ID:\t\t" + id + "\n"
				+ "Arrival Time:\t" + time.toString() + "\n"
				+ "Priority:\t" + priority + "\n";
	}
}
