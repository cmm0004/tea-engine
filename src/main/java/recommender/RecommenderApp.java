package recommender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.math3.ml.distance.EuclideanDistance;

public class RecommenderApp {
	
	public static void main(String[] args) {
		recommendTea(new Tea(2.1,4,"Ray"));
		
		
	}
	
	public static void recommendTea(final Tea idealTea) {
		List<Tea> teas = new ArrayList<Tea>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/teas.csv"));
			String line;
			while ((line = br.readLine())!=null){
				
				String[] splitted = line.split(",");
				teas.add(new Tea(Double.parseDouble(splitted[0]), Double.parseDouble(splitted[1]), splitted[2]));
				
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(teas, new Comparator<Tea>() {
			public int compare(Tea o1, Tea o2) {
				Double dist1 = getTeaDistance(idealTea, o1);
				double dist2 = getTeaDistance(idealTea, o2);
				return dist1.compareTo(dist2);
			}
			
		});
//		for (Tea tea: teas){
//			System.out.println(tea);
//		}
		for (int i = 0; i <3; i++)
		{
			System.out.println(teas.get(i));
		}
	}
	
	private static double getTeaDistance(Tea tea, Tea otherTea)
	{
		
		return new EuclideanDistance().compute(tea.teaDouble(),otherTea.teaDouble());
		
	}

}
