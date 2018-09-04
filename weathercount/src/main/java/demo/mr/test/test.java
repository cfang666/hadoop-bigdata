package demo.mr.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listDay = new ArrayList<String>();
		List<Integer> listNight = new ArrayList<Integer>();

		listDay.add("2");
		listDay.add("56");
		listDay.add("46");
		listDay.add("878");
		listDay.add("3");

		listNight.add(45);
		listNight.add(56);
		listNight.add(4466);
		listNight.add(7);
		listNight.add(9);

		Collections.sort(listNight);
		Collections.sort(listNight);
		Collections.sort(listDay);
		
		/*Collections.sort(listDay, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null){
                    return -1;
                }
                if(o1.compareTo(o2) > 0){
                    return 1;
                }
                if(o1.compareTo(o2) < 0){
                    return -1;
                }
                if(o1.compareTo(o2) == 0){
                    return 0;
                }
                return 0;
            }
        });
		
		Collections.sort(listNight, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null){
                    return -1;
                }
                if(o1.compareTo(o2) > 0){
                    return 1;
                }
                if(o1.compareTo(o2) < 0){
                    return -1;
                }
                if(o1.compareTo(o2) == 0){
                    return 0;
                }
                return 0;
            }
        });*/

		int MinNight = listNight.get(0);
		int MaxNight = listNight.get(listNight.size()-1);
		for(int s : listNight){
			System.out.println(s);
		}
		for(String s : listDay){
			System.out.println(s);
		}
		String MinDay = listDay.get(0);
		String MaxDay = listDay.get(listDay.size()-1);
		System.out.println(MinNight+" "+MaxNight);
	}

}
