import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

class MapsPractice{
	public static void main(String args[]){
		
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();
		TreeMap<Integer, Integer> map3 = new TreeMap<Integer, Integer>();

		map2.put(1,1);
		map2.put(4,16);
		map2.put(3,9);
		map2.put(2,4);
		
		map3.put(1,1);
		map3.put(4,16);
		map3.put(3,9);
		map3.put(2,4);

		System.out.println("Linked Hash Map: ");
		Set set2 = map2.entrySet();
		Iterator it = set2.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println("Key: "+entry.getKey()+" Val: "+entry.getValue());
		}
		
		System.out.println("\nTree Map");
		Set set3 = map3.entrySet();
		it = set3.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println("Key: "+entry.getKey()+" Val: "+entry.getValue());
		}

	}
}