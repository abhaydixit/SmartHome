import jess.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
	

	
	
	
	public static void main(String args[]) {
		
		//System.out.println(Test.class.getClass().getCanonicalName());
		
		Rete engine = new Rete();
		try {
			engine.executeCommand("(clear)");
			engine.executeCommand("(watch all)");

			engine.executeCommand("(deftemplate house (slot rain) (slot sprinkler) (slot window))");

			engine.executeCommand("(defrule is-it-raining ?res <- (house (rain ?r&:(> ?r 0.5))) =>  (printout t \"close the window\"))");
			engine.executeCommand("(defrule its-not-raining ?res <- (house (rain ?r&:(< ?r 0.5))) =>  (printout t \"keep the window open\"))");
			//float rain;
			String rain ="0";
	        try {
				  rain = new String(Files.readAllBytes(Paths.get("./rain.txt")));
				  System.out.println("The rain value is "+rain);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        

			String cmd="(assert (house (rain "+rain+")))";
			engine.executeCommand(cmd);
			engine.executeCommand("(run)");

			
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
