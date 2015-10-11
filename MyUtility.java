
import java.util.Random;

/**
 * Created by aadarsh-ubuntu on 8/10/15.
 */
public class MyUtility {
    public static void main(String args[]){
    	char s[] = {'a','b','c','d'};
    	swap(s,1,2);
    	for(char c: s)
    		System.out.print(c+" ");


    }

    public static void swap(char s[], int l, int r){
    	char temp = s[l];
    	s[l] = s[r];
    	s[r] = temp;
    }

    public static void modify(StringBuffer s){
    	s.setCharAt(0, '1');
    	System.out.println(s.toString());
    }
}
