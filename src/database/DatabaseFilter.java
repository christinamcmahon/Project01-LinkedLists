package database;

import lists.LinkedList;
import utility.List;
import utility.Query;
import utility.Queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import hospital.ArrivalTime;
import hospital.Patient;

public class DatabaseFilter {
	/*************************************************************
	 * data fields: data, queue
	 *************************************************************/
	private List<Patient> data;  //stores the data from the database file
	private Queue<Patient> queue; //priority queue for the data
	
	/*************************************************************
	 * default constructor: DatabaseFilter()
	 *************************************************************/
	public DatabaseFilter() {
		data = new LinkedList<Patient>();
		queue = new LinkedList<Patient>();
	}
	
	/*************************************************************
	 * use queue operations to add patient records from kiosk to
	 * priority queue
	 * @param patient 	Patient being added to priority queue
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void addToPriorityQueue(Patient patient) throws FileNotFoundException {
		Queue<Patient> temp = new LinkedList<Patient>();
		if(patient.getPriority() == 10) {
			queue.add(patient);
		} else {
			while(!queue.isEmpty() && queue.peek().getPriority() <= patient.getPriority()) {
				temp.add(queue.remove());
			} 
			temp.add(patient);
			while(!queue.isEmpty()) {
				temp.add(queue.remove());
			}
			while(!temp.isEmpty()) {
				queue.add(temp.remove());
			}
		}
	}
	
	/*************************************************************
	 * filters the data for patients over (or equal to) 40 and 
	 * writes it to the indicated file location
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void filterOver40(String location) throws FileNotFoundException {
		List<Patient> temp = new LinkedList<Patient>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getAge() >= 40) {
				temp.add(data.get(i));
			}
		}
		File file = new File(location);
		PrintStream writer = new PrintStream(file);
		for(int i = 0; i < temp.size(); i++) {
			writer.println(temp.get(i) + "\n");
		}
		writer.close();
	}
	
	/*************************************************************
	 * filters the data for patients under 40 and writes it to the
	 * indicated file location
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void filterUnder40(String location) throws FileNotFoundException {
		List<Patient> temp = new LinkedList<Patient>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getAge() < 40) {
				temp.add(data.get(i));
			}
		}
		File file = new File(location);
		PrintStream writer = new PrintStream(file);
		for(int i = 0; i < temp.size(); i++) {
			writer.println(temp.get(i) + "\n");
		}
		writer.close();
	}
	
	/*************************************************************
	 * takes the current linked list object and sorts it and 
	 * returns the sorted queue in order of highest priority and
	 * arrival time
	 * @return sorted queue in order of highest priority and
	 * arrival time
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public Queue<Patient> makePriorityQueue() throws FileNotFoundException {
		Query.selectionSort(data,  Patient::compareTo);
		for(int i = 0; i < data.size(); i++) {
			queue.add(data.get(i));
		}
		return queue;
	}
	
	/*************************************************************
	 * returns an object that is compatible with a Patient object
	 * @param line 	line being parsed
	 * @return an object that is compatible with a Patient object
	 * @throws IllegalArgumentException if number is out of bounds
	 *************************************************************/
	public Patient parse(String line) throws IllegalArgumentException {
		String[] info = line.split(", ");
		String name = info[0];
		int age = Integer.parseInt(info[1]);
		String id = info[2];
		String[] times = info[3].split(":");
		int hour = Integer.parseInt(times[0]);
		int minutes = Integer.parseInt(times[1]);
		ArrivalTime time = new ArrivalTime(hour, minutes);
		int priority = Integer.parseInt(info[4]);
		return new Patient(name, age, id,time, priority);
	}
	
	/*************************************************************
	 * reads the contents of a comma separated database file
	 * @param location 	file location to be read
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void read(String location) throws FileNotFoundException {
		File file = new File(location);
		Scanner input = new Scanner(file);
		Patient patient;
		while(input.hasNextLine()) {
			patient = parse(input.nextLine());
			if(!data.contains(patient)) {
				data.add(patient);
			}
		}
		input.close();
	}
	
	/*************************************************************
	 * searches for a patient and prints their information 
	 * @param patient 	patient being searched for
	 *************************************************************/
	public void search(Patient patient) {
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).equals(patient)) {
				System.out.print(data.get(i));
			}
		}
	}
	
	/*************************************************************
	 * filters the data for patients in order by age 
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void showAge(String location) throws FileNotFoundException {
		Query.selectionSort(data, Patient::compareByAge);
		write(location);
	}
	
	/*************************************************************
	 * filters the data for patients in alphabetical order by last
	 * name then first name and writes it to the indicated file 
	 * location
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void showAlphabeticalOrder(String location) throws FileNotFoundException {
		Query.selectionSort(data,  Patient::compareByName);
		write(location);
	}
	
	/*************************************************************
	 * writes the current priority queue to a file
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void showPriorityQueue(String location) throws FileNotFoundException {
		Queue<Patient> temp = queue;
		File file = new File(location);
		PrintStream writer = new PrintStream(file);
		while(!temp.isEmpty()) {
			writer.println(temp.remove());
		}
		writer.close();
	}
	
	/*************************************************************
	 * writes the contents of a database element to a file
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void write(String location) throws FileNotFoundException {
		File file = new File(location);
		PrintStream writer = new PrintStream(file);
		for(int i = 0; i < data.size(); i++) {
			writer.println(data.get(i));
		}
		writer.close();
	}
	
	/*************************************************************
	 * writes the contents of a database element to a file, in a
	 * comma separated format
	 * @param location 	file location to be written to
	 * @throws FileNotFoundException if file is not found
	 *************************************************************/
	public void writeCS(String location) throws FileNotFoundException {
		File file = new File(location);
		PrintStream writer = new PrintStream(file);
		for(int i = 0; i < data.size(); i++) {
			writer.println(data.get(i).toFile() + "\n");
		}
		writer.close();
	}
}
