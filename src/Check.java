import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class Check extends TimerTask{
	int version;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String rain;
		
		try {
			rain = new String(Files.readAllBytes(Paths.get("./rain.txt")));
			
			  System.out.println("The rain value is "+rain);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String args[]) {
		Timer timer = new Timer();
		timer.schedule(new Check(),0,1000);
		
		
	}

}
