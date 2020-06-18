package esercizio4;
import java.util.ArrayList;
import java.util.List;

public class MinoriDi {
	public static <T extends Number> ArrayList<T> minoriDi(List<T> l, T value) {
		ArrayList<T> minDi = new ArrayList<T>();
		Double val = Double.valueOf(value.toString());
		
		for (T t:l) {
			Double v = Double.valueOf(t.toString());
			if ( v < val) {
				minDi.add(t);
			}
		}
		return minDi;
	}
}
