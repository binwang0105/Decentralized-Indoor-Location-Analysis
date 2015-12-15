import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
/*
 * 
 * Author Name: Bin Wang
 * Course: E6893 Big Data Analytics
 * Columbia University
 * 
 * */
public class WriteText {
	
	private static final boolean DEBUG = false;
	
	public void writeTofile(){
		
		FileWriter fileWriter = null;
		String objectAddressEntries = null;
		FingerprintPreprocessor fingerprintProcessor = FingerprintPreprocessor.getFp();
		Iterator<String> iter = fingerprintProcessor.getEntries().iterator();
		
		try {
			fileWriter = new FileWriter("InputForMap.txt", true);
			while(iter.hasNext()){
				//write line by line
				objectAddressEntries = (String)iter.next();
				fileWriter.write(objectAddressEntries);
				fileWriter.write('\n');
				if(DEBUG)
					System.out.println(iter.next());
			}
			} catch (IOException e) {	
				e.printStackTrace();
				System.out.println("Exception happened in writing into the file!");
				System.exit(-1);
		}
	}
}
