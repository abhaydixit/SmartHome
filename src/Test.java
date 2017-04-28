import jess.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		//System.out.println(args[0]);
		
		 		try {
		 			//engine.executeCommand("(bind ?cm (new Test))");
		 			//engine.executeCommand("(call ?cm callme \"hi my friend\")");
			engine.executeCommand("(clear)");
			engine.executeCommand("(open \"rain1.txt\" file \"w\")");

			engine.executeCommand("(deftemplate house (slot rain) (slot sprinkler) (slot window))");
			
			engine.executeCommand("(printout file \"\" crlf)");

			engine.executeCommand("(defrule is-it-raining ?res <- (house (rain ?r&:(eq ?r 1))) => (bind ?cm (new Test))(call ?cm callPy "+args[0]+") )");
			//(printout t \"close the window\" crlf)
			
			//engine.executeCommand("(defrule its-not-raining ?res <- (house (rain ?r&:(< ?r 0.5))) =>  (printout t \" \n keep the window open\" crlf))");
			//float rain;
			engine.executeCommand("(reset)");
//			engine.executeCommand("(watch all)");
			String cmd="(assert (house (rain "+args[0]+")))";
			engine.executeCommand(cmd);
			engine.executeCommand("(run)");
//			arg
			

		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		 		if(Integer.parseInt(args[0])==0){
		 			//System.out.println("its unrelable");
		        	
		        	float ttt,tft,ttf,tff,tt,ft,ff,tf,t,f;
		        	//ttt
		        	Test test = new Test();
		        	Search_table st= test.new Search_table();
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
		        	//System.out.println(Math.round(probAns*100) +" %");
		        	//System.out.println(0);
		        	callPy(0);
		 			
		 		}
		 		
//		
//		Timer timer = new Timer();
//		timer.schedule(new Test(),0,1000);
		 		
				
		
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Rete engine = new Rete();
		
		try {
						//engine.executeCommand("(close mo)");
			String rain=null;
	        try {
				  rain = new String(Files.readAllBytes(Paths.get("./rain.txt")));
				  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        rain=rain.toString();
	        
	       // int rainInt;
	        
	       // int rainI = Integer.parseInt(rain);
	        //rainInt=Integer.parseInt(rain);
	       // System.out.println("The rain value is "+rain);
	        //System.out.println(rain);
	        
	        if(rain.contains("0")){
	        	//System.out.println("its unrelable");
	        	
	        	float ttt,tft,ttf,tff,tt,ft,ff,tf,t,f;
	        	//ttt
	        	Search_table st= new Search_table();
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
	        	//System.out.println(Math.round(probAns*100) +" %");
	        	engine.executeCommand("(open \"rain1.txt\" file \"w\")");
	        	
	        	int ans=(int) Math.round(probAns*100);

				engine.executeCommand("(printout file \" \n "+ans+" \" crlf)");

	        	
	        	
	        	
	        }else{
	        	
	        	//System.out.println("its relaible");
	        	String cmd="(assert (house (rain 1)))";
				engine.executeCommand(cmd);
				engine.executeCommand("(run)");
	        	
	        	
	        }
	        	
	        

			
			
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		


		
	}
	
	
	
	public class Search_table {
		String search_key,file_name,curr_string;
		String[] split_words;
		
		float result;
		
		public float search(String fileName,String searchKey){
			 this.file_name=fileName;
				this.search_key = searchKey;
				// TODO Auto-generated constructor stub
				
				File file = new File(file_name);
				FileReader fileReader;
				try {
					fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer stringBuffer = new StringBuffer();
					String line,curr_key="";
					int split_length;
					
					while ((line=bufferedReader.readLine())!=null) {
						stringBuffer.append(line);
						curr_string=stringBuffer.toString();
						//System.out.println("current line is "+curr_string);
						split_words=curr_string.split(",");
						split_length=split_words.length;
						for(int i=0;i<split_words.length;i++)
						{
							if(i<split_words.length-1)
								curr_key+=split_words[i];
						}
						//System.out.println("cur key "+curr_key);
						//System.out.println(curr_key);
						if(curr_key.equals(search_key)){
							//System.out.println("match"+split_words[split_words.length-1]);
							
							result = Float.parseFloat(split_words[split_words.length-1]);
							//System.out.println(split_words[split_words.length-1]);
							break;
							
							
							//System.out.println(result);
						}
						curr_key="";
							//System.out.println(split_words[i]);
						//stringBuffer.append("\n");
						stringBuffer=new StringBuffer();
					}
					fileReader.close();
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			return result;
			}
		
		
		
		
		}

	
	public static void callPy(int value){
		String s = null;
		
		
		
		  
		  int hString=value;
		

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
