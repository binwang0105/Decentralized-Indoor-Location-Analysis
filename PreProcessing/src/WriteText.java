import java.util.Iterator;

public class WriteText {
	public void writeTofile(){
		FingerprintPreprocessor fingerprintProcessor = FingerprintPreprocessor.getFp();
		Iterator<String> iter = fingerprintProcessor.getEntries().iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
