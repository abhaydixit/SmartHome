import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeTest {

	int findSeason(){
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Date date = new Date();
		int idate = Integer.parseInt(dateFormat.format(date).toString());
		System.out.println(idate); //2016/11/16 12:08:43
		
		return 1;
	}

	
	public static void main(String args[]) {
		
		
		new CodeTest().findSeason();
		
		
		
	}
}
