interface Schedulable{
	long start_time;
	long end_time;

	Schedulable(long sched_start, long sched_end){
		this.start_time = sched_start;
		this.end_time = sched_end;
	}

	
}

class Item extends Schedulable{
	private int item_id;
	
	Item(int item_id){
		this.item_id = item_id;
	}

	Item(int item_id, long start_time, long end_time){
		Item(item_id);
		super(start_time, end_time);
	}

	getId(){
		return item_id;
	}
} 

class Location{
	private int location_id;
	ArrayList<Item> scheduled_items;
	getId(){
		return item_id;
	}	

	Location(int id){
		this.location_id=id;
		scheduled_items = new ArrayList<Item>();
	}
}


class ItemScheduling{
	public static void main(String args[]){

	}

	private static void parseInput(String filename, Location loc){
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String str = br.readLine();
		while(str!=null){
			String split_str = str.split(" ");
			int id = Integer.parseInt(split_str[0]);
			long start = Long.parseLong(split_str[1]);
			long end = Long.parseLong(split_str[2]);
			Item item = new Item(id, start, end);
			loc.scheduled_items.add(item);
			str = br.readLine();
		}
	}

}