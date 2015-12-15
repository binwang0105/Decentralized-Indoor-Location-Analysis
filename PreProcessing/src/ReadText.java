import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadText {

	public final void readFile(String filePath) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));  
		FingerprintPreprocessor fingerprintProcessor = FingerprintPreprocessor.getFp();
		String line = br.readLine();
		String primeLine = null;
		while(line != null){
			line = normalized(line);
			fingerprintProcessor.getEntries().add(line);
			line = br.readLine();
		}
	}

	private String normalized(String line) {
		String substring = line;
		String ret = null;
		substring = substring.replace(" ", ",");
		substring = substring.substring(substring.indexOf(",")+1);
		ret = replaceThird(substring);
		return ret;
		}
	
	public String replaceThird(String substring){
		String ret = substring;
		
        int index = substring.indexOf(',');
		String part1 = substring.substring(0, index+1);
        
		String temp_ = substring.substring(index+1,substring.length());
        int index_ = temp_.indexOf(',');
        String part2 = temp_.substring(0, index_+1);
        
        String temp__ = temp_.substring(index_+1,temp_.length());
        int index__ = temp__.indexOf(',');
        String part3 = temp__.substring(0, index__);
        
        String temp___ = temp__.substring(index__+1);
        String header = ret.substring(0, index__+5);

        return part1 + part2 + part3 + " " + temp___;
    }
}
