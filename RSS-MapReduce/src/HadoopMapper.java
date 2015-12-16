import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapreduce.Mapper;
/*
 * Author Name: Bin Wang
 * Course: E6893 Big Data Analytics
 * Columbia University
 * 
 * */
public class HadoopMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private Text word = new Text();
	private IntWritable val = null;
	
	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
	String line = value.toString();
	StringTokenizer tokenizer = new StringTokenizer(line, " ");
	
	while (tokenizer.hasMoreTokens()) {
		word.set(tokenizer.nextToken());
		val = new IntWritable(Integer.parseInt(tokenizer.nextToken()));
		context.write(word, val);
		}
	
	}
}