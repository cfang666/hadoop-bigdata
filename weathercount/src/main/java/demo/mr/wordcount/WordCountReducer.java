package demo.mr.wordcount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import com.sun.tools.javac.util.Convert;

public class WordCountReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		Integer sum = 0;
		Integer nisum = 0;
		String s = null;
		int avgtemperture = 0;
		int niavgtemperture = 0;
		Text t = null;
		int i = 0;
		List<Integer> listDay = new ArrayList<Integer>();// 存白天温度
		List<Integer> listNight = new ArrayList<Integer>();// 存夜间温度

		for (Text value : values) {
			s = value.toString();
			String[] words = s.split("-");// 切割， words[0]为白天温度， words[1]为夜间温度
			sum += Integer.parseInt(words[0]);
			nisum += Integer.parseInt(words[1]);

			listDay.add(Integer.parseInt(words[0]));
			listNight.add(Integer.parseInt(words[1]));

			i++;
		}

		// 计算平均气温
		avgtemperture = sum / i;
		niavgtemperture = nisum / i;

		// 气温排序
		Collections.sort(listDay);
		Collections.sort(listNight);

		int MinNight = listNight.get(0);
		int MaxNight = listNight.get(listNight.size() - 1);
		int MinDay = listDay.get(0);
		int MaxDay = listDay.get(listDay.size() - 1);

		t = new Text("白天平均温度是" + avgtemperture + "℃   夜间平均温度是"
				+ niavgtemperture + "℃   白天最低温度是" + MinDay + "℃   白天最高温度是"
				+ MaxDay + "℃   夜间最低温度是" + MinNight + "℃   夜间最高温度是" + MaxNight
				+ "℃");
		context.write(key, new Text(t));
	}
}
