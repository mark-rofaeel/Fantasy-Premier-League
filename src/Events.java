import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public interface Events 
{   
	Data data =new Data();
    public void ApplyEvents(String playername,String position,String gameweek ) throws IOException ;
}
