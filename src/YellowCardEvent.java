import java.io.IOException;

public class YellowCardEvent implements Events
{

	@Override
	public void ApplyEvents(String playername, String position,String gameweek) throws IOException 
	{
		int point = -1 ;
		data.Update(playername, point, position, gameweek);
		
	}

}
