import jess.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;

public class Test extends TimerTask{
	

	static Rete engine = new Rete();
	
	
	public static void main(String args[]) {
		
		//System.out.println(Test.class.getClass().getCanonicalName());
		///home/abhishek/softwares/Jess71p2/bin/jess
		
		try {
			engine.executeCommand("(clear)");
			engine.executeCommand("(open \"rain1.txt\" file \"w\")");

			engine.executeCommand("(deftemplate house (slot rain) (slot sprinkler) (slot window))");
			

			engine.executeCommand("(defrule is-it-raining ?res <- (house (rain ?r&:(== ?r 1))) =>  (printout t \" \n close the window\" crlf))");
			
			//engine.executeCommand("(defrule its-not-raining ?res <- (house (rain ?r&:(< ?r 0.5))) =>  (printout t \" \n keep the window open\" crlf))");
			//float rain;
			engine.executeCommand("(reset)");

		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//engine.executeCommand("(watch all)");
		
		Timer timer = new Timer();
		timer.schedule(new Test(),0,1000);
				
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Rete engine = new Rete();
		
		try {
						//engine.executeCommand("(close mo)");
			String rain="0";
	        try {
				  rain = new String(Files.readAllBytes(Paths.get("./rain.txt")));
				  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        
	       // int rainI = Integer.parseInt(rain);
	        rain=rain.toString();
	       // System.out.println("The rain value is "+rain);
	        //System.out.println();
	        if(rain.compareTo("0")==1){
	        	//System.out.println("its unrelable");
	        	
	        	float ttt,tft,ttf,tff,tt,ft,ff,tf,t,f;
	        	//ttt=
	        	search_table st= new search_table();
	        	//System.out.println(st.search("./grasswet_table.txt","ftt"));
	        	
	        	ttt = st.search("./grasswet_table.txt","ttt");
	        	tft = st.search("./grasswet_table.txt","tft");
	        	ttf = st.search("./grasswet_table.txt","ttf");
	        	tff = st.search("./grasswet_table.txt","tff");
	        	tt  = st.search("./sprinkler_table.txt","tt");
	        	ft  = st.search("./sprinkler_table.txt","ft");
	        	tf  = st.search("./sprinkler_table.txt","tf");
	        	ff  = st.search("./sprinkler_table.txt","ff");
	        	t   = st.search("./rain_table.txt","t");
	        	f   = st.search("./rain_table.txt","f");
	        	
	        	//System.out.println(ttt+" "+tt+" "+t);
	        	//System.out.println(tft+" "+ft+" "+t);
	        	//System.out.println(tff+" "+ff+" "+f);
	        	
	        	ttt=ttt*tt*t;
	        	tft=tft*ft*t;
	        	ttf=ttf*tf*f;
	        	tff=tff*ff*f;
	        	//System.out.println(ttt+" "+tft+" "+ttf+" "+tff);
	        		
	        	double probAns=(ttt+tft)/(ttt+ttf+tft+tff);
	        	System.out.println(Math.round(probAns*100) +" %");
	        	
	        	
	        }else{
	        	
	        	//System.out.println("its relaible");
	        	String cmd="(assert (house (rain "+rain+")))";
				engine.executeCommand(cmd);
				engine.executeCommand("(run)");
	        	
	        	
	        }
	        	
	        

			
			
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		


		
	}

}
