import java.io.*;
import java.util.ArrayList;
class DataStreamMedian{
	public static void main(String args[])throws IOException{
		MedianFinder medianfinder = new MedianFinder();
		int x[] ={1,2,6,100,3,2,1};
		for(int i=0;i<x.length;i++){
			medianfinder.addNum(x[i]);
			System.out.println("Median: "+medianfinder.findMedian());				
		}

	}//main

	public static int[] getInputs(String filename)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String str = br.readLine();
		StringBuffer output_string = new StringBuffer();
		while(str!=null){
			output_string.append(str);
			str = br.readLine();
		}
		
		String output = output_string.toString();
		String outputs[] = output.split(",");
		int n = outputs.length;
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(outputs[i].contains("addNum")){
				inputs.add(Integer.parseInt(outputs[i].substring(7,outputs[i].length()-1)));
			}
		}
		int arr[] = new int[inputs.size()];
		int count=0;
		for(int i : inputs){
			arr[count++] = i;
		}
		return arr;
	}
}//end of class



class MedianFinder{
	MinHeap minheap = null;
	MaxHeap maxheap = null;

	MedianFinder(){
		minheap = new MinHeap();
		maxheap = new MaxHeap();
	}

	public void addNum(int num){
		if(maxheap.size()==0 || minheap.size()==0){
			if(maxheap.size()==0)
				maxheap.insert(num);
			else{
				if(num >= maxheap.root())
					minheap.insert(num);
				else{
					int maxheap_root = maxheap.extractMax();
					minheap.insert(maxheap_root);
					maxheap.insert(num);
				}
			}
		}
		else{
			if(maxheap.size() == minheap.size()){
				//System.out.println("MAX: "+maxheap.size()+" MIN: "+minheap.size());
				
				//System.out.println("Max root: "+maxheap.root()+" Min root: "+minheap.root());
				if(num <= minheap.root()){
					maxheap.insert(num);
					//System.out.println("Inserted into maxheap");
					//System.out.println("Maxheap size: "+maxheap.size()+" Minheap size: "+minheap.size());
					//System.out.println("Maxheap root: "+maxheap.root());
				}
				else{
					//System.out.println("Inserted into minheap");
					minheap.insert(num);
				}
			}
			else if(maxheap.size() < minheap.size()){
				if(num <= minheap.root())
					maxheap.insert(num);
				else{
					int minheap_root = minheap.extractMin();
					maxheap.insert(minheap_root);
					minheap.insert(num);
				}
			}
			else{
				if(num >= maxheap.root())
					minheap.insert(num);
				else{
					int maxheap_root = maxheap.extractMax();
					minheap.insert(maxheap_root);
					maxheap.insert(num);
				}
			}
		}
		//printHeaps();
	}

	public double findMedian(){
		if(maxheap.size() == minheap.size())
			return ((double)maxheap.root() + (double)minheap.root())/2.0;
		else{
			return maxheap.size() > minheap.size() ? (double)maxheap.root() : (double)minheap.root();
		}
	}

	public void printHeaps(){
		System.out.println("Maxheap contents: "+" size="+maxheap.size());
		//maxheap.print();
		System.out.println("Minheap contents: "+" size="+minheap.size());
		//minheap.print();
	}
}