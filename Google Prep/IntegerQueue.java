class IntegerQueue{
	public static void main(String args[]){
		IntQueue q = new IntQueue();
		q.enqueue(0);
		System.out.println(q.dequeue());
		q.enqueue(9);
		System.out.println(q.dequeue());
		q.enqueue(0);
		System.out.println(q.dequeue());

		
		//System.out.println(q.dequeue());
		//System.out.println(q.dequeue());
	}


}

class IntQueue{
	int q;
	int pow;

	IntQueue(){
		this.q=0;
		this.pow=-1;
	}

	void enqueue(int x){
		
		if(x!=9)
			this.q = this.q*10 + (x+1);
		else{
			this.q = this.q*100 + (x+1);
			this.pow++; 
		}
		//System.out.println(this.q);
		this.pow++;
	}

	int dequeue(){
		int return_val=0;
		int div = (int)Math.pow(10.0, (double)this.pow);
		return_val = this.q / div;
		this.q = this.q%div;

		if(return_val==1 && div!=1){
			div/=10;
			if(this.q/div==0){
				return_val=10;
				this.pow--;
			}
		}
		this.pow--;
		return --return_val;
	}

}