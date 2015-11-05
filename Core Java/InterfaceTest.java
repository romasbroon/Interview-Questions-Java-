interface I1{
	public abstract void foo();
	public abstract void bar();
}

interface I2{
	public abstract void foo();
	public abstract void pqr();
}

class Test implements I1, I2{
	public void foo(){
		System.out.println("foo1");
	}

	public void bar(){
		System.out.println("bar");
	}

	public void pqr(){
		System.out.println("pqr");
	}

}

class InterfaceTest{
	public static void main(String args[]){
		Test test = new Test();
		test.foo();
		test.bar();
		test.pqr();
	}
}