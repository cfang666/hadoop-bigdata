package demo.mr.wordcount;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//例:146 厦门 2018-03-01 多云 多云 24℃ 14℃ 东风 4-5级 东北风 <3级 01 01 
		String line = value.toString();
		String[] words = line.split(" ");
		String id = words[0];
		String cityname = words[1];
		String datetime = StringUtils.substringBeforeLast(words[2], "-");
		String dayTemperture = words[5];
		String nightTemperture = words[6];
		String dayTemp = StringUtils.substringBefore(dayTemperture, "℃");
		String nightTemp = StringUtils.substringBefore(nightTemperture, "℃");
		context.write(new Text(cityname + "--" + datetime), new Text(dayTemp + "-" + nightTemp));
	}
}
