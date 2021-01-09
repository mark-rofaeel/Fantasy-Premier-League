import java.io.IOException;

public class GoalByMid implements Events
{
	 //6 assist 3 goal defender,goalkeepers ely f team el tany
	@Override
	public void ApplyEvents(String playername, String position,String gameweek) throws IOException 
	{
		int point = 5 ; 
		data.Update(playername, point, position, gameweek);
		
		
	}

}
