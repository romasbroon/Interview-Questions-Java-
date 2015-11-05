import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class SetsPractice{
	public static void main(String args[]){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(4);
		set.add(1);
		set.add(10);
		set.add(7);
		set.add(-6);

		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println((Integer)it.next());
		}
	}
}