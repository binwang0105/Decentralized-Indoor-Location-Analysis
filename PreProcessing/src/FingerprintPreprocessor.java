import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
/*
 * 
 * Author Name: Bin Wang
 * Course: E6893 Big Data Analytics
 * Columbia University
 * 
 * */
public class FingerprintPreprocessor {

	private static ArrayList<String> entries = new ArrayList<String>();
	private static FingerprintPreprocessor fp = new FingerprintPreprocessor();

	public static void main(String[] args) throws IOException{
		ReadText textReader = new ReadText();
		textReader.readFile("fingerprint.txt");
		WriteText textWriter = new WriteText();
		textWriter.writeTofile();
	}
	
	public ArrayList<String> getEntries() {
		return entries;
	}
	
	public static FingerprintPreprocessor getFp() {
		return fp;
	}
}
