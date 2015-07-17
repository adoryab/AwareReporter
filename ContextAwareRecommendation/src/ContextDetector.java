import java.util.Calendar;


public class ContextDetector {
	// contextual elements we consider for now: location, time, and activity
	private String location;
	private Calendar utcDateAndTime;
	private String activity;
	
	//typeOfContext: 0 = static (no context, use profile info only), 1 = current context, 2 = future context 
	public ContextDetector(String deviceID, int typeOfContext){
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocationId(String location) {
		this.location = location;
	}
	
	public Calendar getUtcDateAndTime() {
		return utcDateAndTime;
	}

	public void setUtcDateAndTime(Calendar utcDateAndTime) {
		this.utcDateAndTime = utcDateAndTime;
	}
	
	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
