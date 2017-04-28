import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.PUBLIC_MEMBER;

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
	
	
	
	public static void main(String args[]) {
		
		new Search_table().search("./sprinkler_table.txt","tt");
		
	}
	}
	


