import java.util.ArrayList;

class ValidParan
{
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String args[])
	{
		int n=4;
		char s[]=new char[2*n];
		gen(s,0,n,n);

		for(String str : list)
			System.out.println(str);
	}

	public static void gen(char[] s, int index, int lr, int rr)
	{
	    if(lr==0 && rr==0)
	    {
	        list.add(new String(s));
	        return;
	    }    
	    
	    
	    if(lr>rr)
	        return;
	    
	    if(lr==rr)    
	    {
	        s[index] = '(';
	        gen(s,index+1,lr-1,rr);
	    }
	    if(lr<rr)
	    {
	        if(lr!=0)
	        {
	            s[index]='(';
	            gen(s,index+1,lr-1,rr);    
	        }
	        s[index]=')';
	        gen(s,index+1,lr,rr-1);
	    }

	}
}