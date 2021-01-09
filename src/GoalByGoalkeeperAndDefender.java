import java.io.IOException;

public class GoalByGoalkeeperAndDefender implements Events
{

	@Override
	public void ApplyEvents(String playername, String position,String gameweek) throws IOException 
	{
		int point = 6;
		data.Update(playername, point, position, gameweek);
		
	}

}
