import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CallPy {
	
	
	public static void  main() {
		 String s = null;
		  
		  String hString="hello";
		

	        Runtime r = Runtime.getRuntime();
	        try{
	            Process p = r.exec("python /home/abhishek/java_workspace/JESS/test.py "+hString);

	            BufferedReader stdInput = new BufferedReader(new
	                InputStreamReader(p.getInputStream()));

	            BufferedReader stdError = new BufferedReader(new
	                InputStreamReader(p.getErrorStream()));

	            while ((s = stdInput.readLine()) != null){
	                System.out.println(s);
	            }

	            while ((s = stdError.readLine()) != null){
	                System.out.println(s);
	            }

	            System.exit(0);
	        }
	        catch(IOException ioe){
	            ioe.printStackTrace();
	            System.exit(-1);
	        }

		
	}

}
