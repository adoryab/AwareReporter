import java.util.ArrayList;
import java.util.Calendar;


public class MatchMaker {
	public ArrayList<String> matchedFulfillerSet = new ArrayList<String>();
	private static String currentLocation, futureLocation;
	private static Calendar currentTime;
	private static Calendar futureTime;
	private static String currentActivity;
	private static String futureActivity;
	private ArrayList<String> currentContextMatches;
	private ArrayList<String> futureContextMatches;
	
	public MatchMaker(ContextDetector requesterCurrentContext, ContextDetector requesterFutureContext) {
		this.setCurrentLocation(requesterCurrentContext.getLocation());
		this.setFutureLocation(requesterFutureContext.getLocation());
		this.setCurrentTime(requesterCurrentContext.getUtcDateAndTime());
		this.setFutureTime(requesterFutureContext.getUtcDateAndTime());
		this.setCurrentActivity(requesterCurrentContext.getActivity());
		this.setFutureActivity(requesterFutureContext.getActivity());
	
		// find fulfiller candidates for current context
		setCurrentContextMatches(findFulfillerCandidatesWithSignificant(1, getCurrentLocation(), getCurrentTime(), getCurrentActivity()));
		// find fulfiller candidates for future context
		setFutureContextMatches(findFulfillerCandidatesWithSignificant(2, getFutureLocation(), getFutureTime(), getFutureActivity()));
		// TODO: find common candidates in both sets and add to matchedFulfillerSet
		
		
	}
	 
	public static ArrayList<String> findFulfillerCandidatesWithSignificant(int typeOfContext, String location, Calendar time, String activity)
	{
		ArrayList<String> contextMatches = new ArrayList<String>();
		
		// Find population's significant locations closest to the requested location 
		ArrayList<String> targetSignificantLocations = findPopulationSignificantLocationsCloseTo(location);
		 
		// Find users with significant locations in targetSignificantLocations and time
		// TODO: change the targetUsers list to appropriate type
		ArrayList<String> targetUsers = getUsersWithSignificantLocationsCloseTo(targetSignificantLocations, time);
		
		// Rank users based on proximity to location and time
		sortBasedOnProximityTo(targetUsers, location, time);
		
		// TODO: Get each user's activity at that particular time slot
		
		// TODO: Build the candidate set ranked based of proximity in location, time and activity
		 
		return contextMatches; 
	}


	private static void sortBasedOnProximityTo(ArrayList<String> targetUsers, String location, Calendar time) {
		// TODO Auto-generated method stub
		
	}

	private static ArrayList<String> getUsersWithSignificantLocationsCloseTo(ArrayList<String> targetSignificantLocations, Calendar time) {
		// TODO Make a list of users with significant locations in targetSignificantLocations and time
		return null;
	}

	private static ArrayList<String> findPopulationSignificantLocationsCloseTo(String location) {
		// populationSignificantLocations includes ID, lat and lon of each location
		ArrayList<String> populationSignificantLocations = new ArrayList<String>(); 
		
		for (String psl : populationSignificantLocations){
			
		}
		
		
		
		// TODO: Search the table with population significant locations. Use hierarchical filtering to limit the search space (e.g.city, neighborhod)
		
		// TODO: Calculate the haversine distance between each significant location and the current location. 
		
		// TODO: Filter locations with distance more than a threshold (e.g. 5 miles)
		
		// TODO: Sort the significant location list based on the distance
		
		
		
		return populationSignificantLocations;
		
	}
	
	public static double haversine(double lat1, double lon1, double lat2, double lon2)
	{
    	double R = 6372.8; // In kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
	}
	
	public static String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		MatchMaker.currentLocation = currentLocation;
	}

	public static String getFutureLocation() {
		return futureLocation;
	}

	public void setFutureLocation(String futureLocation) {
		MatchMaker.futureLocation = futureLocation;
	}

	public static Calendar getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Calendar currentTime) {
		MatchMaker.currentTime = currentTime;
	}

	public static Calendar getFutureTime() {
		return futureTime;
	}

	public void setFutureTime(Calendar futureTime) {
		MatchMaker.futureTime = futureTime;
	}

	public static String getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(String currentActivity) {
		MatchMaker.currentActivity = currentActivity;
	}

	public static String getFutureActivity() {
		return futureActivity;
	}

	public void setFutureActivity(String futureActivity) {
		MatchMaker.futureActivity = futureActivity;
	}

	public ArrayList<String> getCurrentContextMatches() {
		return currentContextMatches;
	}

	public void setCurrentContextMatches(ArrayList<String> currentContextMatches) {
		this.currentContextMatches = currentContextMatches;
	}
	
	public ArrayList<String> getFutureContextMatches() {
		return futureContextMatches;
	}

	public void setFutureContextMatches(ArrayList<String> futureContextMatches) {
		this.futureContextMatches = futureContextMatches;
	}
	
}
