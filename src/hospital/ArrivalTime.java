package hospital;

public class ArrivalTime implements Comparable<ArrivalTime> {
	/*************************************************************
	 * data fields: hour, minutes
	 *************************************************************/
	private int hour;
	private int minutes;
	
	/*************************************************************
	 * full constructor: ArrivalTime(int, int)
	 * @param hour 		arrival hour
	 * @param minutes 	arrival minutes
	 * @throws IllegalArgumentException
	 *************************************************************/
	public ArrivalTime(int hour, int minutes) {
		if(hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException("Must use valid military time");
		}
		this.hour = hour;
		this.minutes = minutes;
	}
	
	/*************************************************************
	 * compares the current arrival time to another arrival time
	 * @param other 	arrival time being compared with
	 * @return -1 if current time is earlier than other time, 
	 * 1 if current time is later than other time, and 0 if 
	 * current time and other time are equal
	 *************************************************************/
	public int compareTo(ArrivalTime other) {
		if(hour != other.hour) {
			return hour - other.hour;
		} else if (minutes != other.minutes) {
			return minutes - other.minutes;
		}
		return 0;
	}
	
	/*************************************************************
	 * checks if contents of the current object is equal to the 
	 * contents of another object
	 * @param other 	Object being checked with
	 * @return true if objects' contents are equal
	 *************************************************************/
	public boolean equals(Object other) {
		if(other instanceof ArrivalTime) {
			ArrivalTime newTime = (ArrivalTime)other;
			return hour == newTime.hour && minutes == newTime.minutes;
		}
		return false;
	}
	
	/*************************************************************
	 * retrieves the information in the hour data field
	 * @return hour
	 *************************************************************/
	public int getHour() {
		return hour;
	}
	
	/*************************************************************
	 * retrieves the information in the minutes data field
	 * @return minutes
	 *************************************************************/
	public int getMinutes() {
		return minutes;
	}
	
	/*************************************************************
	 * puts arrival time in comma separated format (15,45)
	 * @return arrival time in comma separated format
	 *************************************************************/
	public String toFile() {
		return "" + hour + "," + minutes;
	}
	
	/*************************************************************
	 * puts arrival time in standard format (15:45)
	 * @return arrival time in standard format
	 *************************************************************/
	public String toString() {
		return "" + hour + ":" + minutes;
	}
}
