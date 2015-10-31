import java.util.ArrayList;
class Test{
	public static void main(String args[]){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		a.add(1,1);
		for(int i=0; i<a.size();i++)
			System.out.println(a.get(i));
	}
}
