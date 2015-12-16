import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/*
 * Author Name: Bin Wang
 * Course: E6893 Big Data Analytics
 * Columbia University
 * 
 * */
public class HadoopReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		int sum = 0;
		int avg = 0;
		int i = 0;
		
		for (IntWritable value : values) {
			sum += value.get();
			i++;
		}
		
		avg = sum/i;
		
		context.write(key, new IntWritable(avg));
	}
}