import java.util.ArrayList;

/*	Current and future context of the potential fulfiller matches the requester’s desired context  (minimum effort and cost of fulfillment)
		Scenario:
		Adrain and Afsaneh work in the same lab on second floor. 
		Afsaneh is passing by the printer on the hallway (current context) on her way to the lab (future context). 
		She gets a notification on her phone to get Adrian’s prints from the printer and deliver to Adrian in the lab.

		Current context of the potential fulfiller matches the requester’s desired context - 
		future context is in close proximation (the cost and effort of fulfillment depends on proximation)
		Scenario:
		Afsaneh is passing by the printer on the hallway (current context) on her way to the lab (future context). 
		She gets a notification on her phone to get Queenies’s prints from the printer and deliver to her office on the 4th floor.

		Current context of the potential fulfiller is in close proximation of the requester’s desired context - 
		future context matches the request (the cost and effort of fulfillment depends on proximation)
		Scenario:
		Adrian is getting coffee in the kitchen (current context). 
		He gets a notification on his phone to get Afsaneh’s print on his way and deliver to her in the lab (future context).

		Current and future context of the potential fulfiller is in close proximation of the requester’s desired context
		(the cost and effort of fulfillment depends on proximation)
		Scenario:
		Adrian is getting coffee in the kitchen (current context) and will go to the lab afterwards (future context). 
		He gets a notification on his phone to get Queenie’s print and deliver to her office on the 4th floor on his way to the lab (future context).

		Future context needs to be predicted based on the routines. Both detection of current context and prediction of future context are necessary for opportunistic matching. 
		Example:Person A wants coffee. His colleague B is notified about A’s request, because B usually gets coffee at this time 
		
		test: create a database with synthetic user data. test the matching algorithms in different scenarios
		profile and preferences table
		current context, future context
		list of matches
		ranking of matches 
		recommendation
		
		get the current context in an array
		put the future context in an array
		develop proximity measure
		develop ranking measure
		proximity to current, desired, future context
		rank context

		*/

public class ContextMatcher {
	private static ContextDetector fulfillerCurrentContext;
	private static ContextDetector fulfillerFutureContext;

	public static void main(String [ ] args)
	{
		String deviceID= "";
		// typeOfContext: 0 = static (no context, use profile info only), 1 = current context, 2 = future context 
		ContextDetector requesterCurrentContext= new ContextDetector(deviceID, 1); //first detect current context of the requester
		ContextDetector requesterFutureContext= new ContextDetector(deviceID, 2); // then detect the future context of the requester
		MatchMaker findFulfillerCandidateSet = new MatchMaker(requesterCurrentContext, requesterFutureContext); // find candidates to fulfill the task
		ArrayList<String> fulfillerCandidateSet = findFulfillerCandidateSet.matchedFulfillerSet;
		if (!fulfillerCandidateSet.isEmpty())
		{
			for (String fulfillerID: fulfillerCandidateSet)
			{
				fulfillerCurrentContext = new ContextDetector(fulfillerID, 1);
				fulfillerFutureContext = new ContextDetector(fulfillerID, 2);
			}
			
			MatchRanker ranker = new MatchRanker(fulfillerCandidateSet); //rank matches
			MatchRecommender recommender = new MatchRecommender(ranker.rankedCandidateSet);
			//TODO
			System.out.println(recommender.recommendedFulfillerSet);
		}	
		
	}
	
	public static void getProfile(String profile)
	{
		
	}
	
	public static void getPreferences(String preferences)
	{
		
	}
	
	public static void inferProfile(String userID)
	{
		
	}
	
	public static void estimateFutureContext(String userID, String currentContext)
	{
		
	}
	
	
	public static void getContext(int typeOfContext, String context)
	{
		if (typeOfContext == 0) profileMatch();
		if (typeOfContext == 1) currentContextMatch();
		if (typeOfContext == 2) futureContextMatch();
	}
	
	
	public static void futureContextMatch() 
	{
		String userID = null;
		String currentContext = null;
		estimateFutureContext(userID, currentContext);
	}

	public static void currentContextMatch() 
	{
		
	}

	public static void profileMatch() 
	{
		
	}

	/*
	 * typeOfContext: 0 = static (no context), 1 = current context, 2 = future context 
	 * context: current or future context 
	 */
	public static void proximityToContext(int typeOfContext, String context, ArrayList contextToMatch)
	{
		
	}
		
	public static void rankContext(ArrayList context )
	{
		
	}
	
	public static void listOfMatches()
	{
		
	}
	
	public static void RecommendMatches()
	{
		
	}
	
	

}
