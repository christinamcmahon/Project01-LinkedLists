package database;

import java.io.File;
import java.io.FileNotFoundException;
import database.DatabaseFilter;
import hospital.ArrivalTime;
import hospital.Patient;

public class DatabaseClient {
	public static void main(String[] args) throws FileNotFoundException {
		String input = 	   	File.separator + "Users" +
						   	File.separator + "christinamcmahon" +
						   	File.separator + "eclipse-workspace" +
						   	File.separator + "Patients.txt";
		
		String write =    	File.separator + "Users" +
				   		   	File.separator + "christinamcmahon" +
				   		   	File.separator + "eclipse-workspace" +
				   		   	File.separator + "Write.txt";
		
		String writeCS =    File.separator + "Users" +
	   		   				File.separator + "christinamcmahon" +
	   		   				File.separator + "eclipse-workspace" +
	   		   				File.separator + "WriteCS.txt";
		
		String priority = 	File.separator + "Users" +
							File.separator + "christinamcmahon" +
							File.separator + "eclipse-workspace" +
							File.separator + "Priority.txt";
		
		String over40 =    	File.separator + "Users" +
		   		   		   	File.separator + "christinamcmahon" +
		   		   		   	File.separator + "eclipse-workspace" +
		   		   		   	File.separator + "Over40.txt";
		
		String under40 = 	File.separator + "Users" +
		   		   			File.separator + "christinamcmahon" +
		   		   			File.separator + "eclipse-workspace" +
		   		   			File.separator + "Under40.txt";
		
		String age = 		File.separator + "Users" +
		   					File.separator + "christinamcmahon" +
		   					File.separator + "eclipse-workspace" +
		   					File.separator + "Age.txt";
		
		String alphabet = 	File.separator + "Users" +
							File.separator + "christinamcmahon" +
							File.separator + "eclipse-workspace" +
							File.separator + "Alphabet.txt";
		
		// test read, write and writeCS
		DatabaseFilter db = new DatabaseFilter();
		db.read(input);
		db.write(write);
		db.writeCS(writeCS);
		
		// test priority queue
		db.makePriorityQueue();
		db.addToPriorityQueue(new Patient("Carter West", 53, "E-6504", new ArrivalTime(8,24), 8));
		db.addToPriorityQueue(new Patient("Jensen Lin", 31, "E-2144", new ArrivalTime(9,21), 8));
		db.addToPriorityQueue(new Patient("Aethelfeld Eastwick", 24, "E-1944", new ArrivalTime(9,26), 9));
		db.addToPriorityQueue(new Patient("Henry Lee", 58, "E-9014", new ArrivalTime(10,16), 9));
		db.addToPriorityQueue(new Patient("Michael Park", 46, "E-8833", new ArrivalTime(10,38), 8));
		db.showPriorityQueue(priority);
		
		// test search
		db.search(new Patient("Finnegan Bean", 24, "E-7148", new ArrivalTime(8, 21), 5));
		
		// test filterOver40
		db.filterOver40(over40);
		
		// test filterUnder40
		db.filterUnder40(under40);
		
		// test order by age
		db.showAge(age);
		
		db.showAlphabeticalOrder(alphabet);
	}
}

