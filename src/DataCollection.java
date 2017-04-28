import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataCollection {
	
	
   class Prob{
	   
	   float t,f;
	   
	   public Prob() {
		   t=0;
		   f=0;
	}
   }
	
	Prob getProbability(int ss){
		int ones=0;
		int zeros=0;
		
		
	for (int i = 0; i < ss; i++) {
		if((int)(Math.random() * 2)==1){
			
			ones++;
			
		}else{
			zeros++;
		}
		
		
	}
	
	System.out.println("Ones = " + ones);
	System.out.println("Zeros = " + zeros);
	
	Prob prob = new Prob();
	prob.t=(float)ones/ss;
	prob.f=(float)zeros/ss;
	
	prob.t=(float) (Math.round(prob.t*100.0)/100.0);
	prob.f=(float) (Math.round(prob.f*100.0)/100.0);
		
		return prob;
		
	}
	
	void populateTable(String fullFileName,String passedContent){
		
		String fileName=fullFileName;
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
			//Prob probab=getProbability(30);
			String content=passedContent;
			
			System.out.println(content);
			bufferedWriter.write(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		
		DataCollection dataCollection =new DataCollection();
			//	new DataCollection().populateRainTable("./rain_table.txt");
		Prob aProb = dataCollection.getProbability(30);
		System.out.println(aProb.t+" "+aProb.f);
		System.out.println((int)(Math.random() * 2));
	}

}
