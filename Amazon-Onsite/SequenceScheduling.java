import java.util.*;
import java.io.*;


class Interval implements Comparable<Interval>{
	int lid;
	int start;
	int len;
	public int compareTo(Interval i2){
		if(this.len > i2.len)
			return 1;
		else if(this.len == i2.len)
			return 0;
		else
			return -1;
	}

	public String toString(){
		return "Interval len: "+len+" Start: "+start;
	}
}

class Content{
	int lid;
	int cid;
	int start,end;
	Content(int a, int b, int c){
		cid=a;
		start=b;
		end=c;
	}
}

class ContentScheduling{
	public boolean schedule(int intervals[], int contents[], int index){
		
		if(intervals==null)
			return false;
		printArray(intervals);
		printArray(contents);
		int n = intervals.length;	
		int m = contents.length;

		for(int i=0;i<n;i++){
			//printArray(intervals);
			System.out.println("Intervals[i] :"+intervals[i]+" content[index] :"+contents[index]);
			if(intervals[i]>=contents[index]){
				int temp=intervals[i];
				if(index == m-1){
					//printArray(intervals);
					//System.out.println("Assigning interval: "+temp+" to content: "+contents[index]);
					return true;
				}
				intervals[i] -= contents[index];
				int new_intervals[] = null;
				if(temp > contents[index])
					new_intervals = getIntervals(intervals);
				else if(temp == contents[index])
					new_intervals = shiftArray(intervals, i);

				if(schedule(new_intervals, contents, index+1)){
					//printArray(new_intervals);
					return true;
				}
				else{
					intervals[i] += contents[index];		
					//System.out.println("here ");
					//printArray(intervals);			
				}
			}
		}
		return false;
	}

	private void printArray(int x[]){
		for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
	//Copies array x into new sorted array, without zeroes if any in x
	private int[] getIntervals(int x[]){
		int y[] = new int[x.length];
		for(int i=0;i<x.length;i++)
			y[i] = x[i];
		Arrays.sort(y);
		return y;
	}

	private int[] shiftArray(int x[], int index){
		System.out.println("here: index:"+index);
		int y[] = new int[x.length-1];
		for(int i=0;i<x.length;i++){
			if(i<index)
				y[i]=x[i];
			else if(i==index){}
			else{
				y[i-1] = x[i];
			}
		}
		printArray(y);
		return y;
	}
	
	private boolean hasZero(int x[]){
		for(int i=0;i<x.length;i++)
			if(x[i]==0)
				return true;
		return false;
	}
}

public class SequenceScheduling{
	public static void main(String args[])throws IOException{
		//int intervals[] = {10,11};
		//int contents[] = {11,7,4};
		//ContentScheduling cs = new ContentScheduling();
		//System.out.println(cs.schedule(intervals, contents, 0));
	
		BufferedReader br =  new BufferedReader(new FileReader(new File("input.txt")));
		String str = br.readLine();
		int count=0;
		int loc_id=0;
		ArrayList<Content> contents = new ArrayList<Content>();

		while(str!=null){
			if(count++==0)
				loc_id = Integer.parseInt(str);
			else{
				count++;
				String split_string[] = str.split(" ");
				int cid = Integer.parseInt(split_string[0]);
				int start = Integer.parseInt(split_string[1]);
				int end = Integer.parseInt(split_string[2]);
				Content c = new Content(cid, start, end);
				contents.add(c);
				c.lid = loc_id;	
			} 
			str = br.readLine();
		}
		ArrayList<Interval> interv = new ArrayList<Interval>(); 
		int size = contents.size();
		for(int i=1;i<size;i++){
			Interval inte = new Interval();
			int diff = contents.get(i).start - contents.get(i-1).end;
			int start = contents.get(i-1).end;
			inte.len=diff;
			inte.start = start;
			interv.add(inte);
		}	

		Collections.sort(interv);
		System.out.println(interv);
		
	}
}