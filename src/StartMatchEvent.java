import java.io.IOException;

public class StartMatchEvent implements Events {

	@Override
	public void ApplyEvents(String newplayername, String position,String gameweek) throws IOException 
	{
		int point = 1 ; 
		data.Update(newplayername, point, position, gameweek);
	}

}
