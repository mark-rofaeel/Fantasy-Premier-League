import java.io.IOException;

public class GoalAssistEvent implements Events
{

	@Override
	public void ApplyEvents(String playername, String position,String gameweek) throws IOException 
	{
		int point = 3 ;
		data.Update(playername, point, position, gameweek);
	}

}
