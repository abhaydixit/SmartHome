import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeTest {

	String findSeason(){
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Date date = new Date();
		int idate = Integer.parseInt(dateFormat.format(date).toString());
		//System.out.println(idate); //2016/11/16 12:08:43
		 
		if(idate>=2 && idate<8){
			return "summer";
		}else if(idate>=8 && idate<11){
			return "rainy";
		}else{
			return "winter";
		}
		//return idate;
	}

	
	public static void main(String args[]) {
		
		
		System.out.println(new CodeTest().findSeason());;
		
		
		
	}
}
