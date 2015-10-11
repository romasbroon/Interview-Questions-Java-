//Given a set of words, to find a word

import java.util.HashSet;
class MaxWordCount
{
	private static HashSet<String> words = new HashSet<String>();//Dictionary of words
	
	public static void main(String args[])
	{
		words.add("mdogfog");
		words.add("fog");
		words.add("form");
		words.add("dog");
		words.add("for");
		words.add("formdogfog");


		int ans = count("dogfog");
		System.out.println(ans);
	}


	public static int count(String s)
	{
		//if(!words.contains(s))
		//	return -1;

		int max=0,os=-1,ns=-1;

		while(true)
		{
			System.out.println("ns="+ns);
			int count=0;
			for(int i=0;i<s.length();i++)
			{
				if(words.contains(s.substring(0,i+1)) && i!=os)
				{
					if(i==s.length()-1)
						return 1;
					int temp = count(s.substring(i+1));
					System.out.println("temp for: "+s.substring(i+1)+" : "+temp);
					if(temp!=0)
					{
						ns=i;
						count=temp+1;
						break; //this iteration of for has done its work.
					}

				}
			}
			max=Math.max(max, count);
			System.out.println("comparing "+os+" and "+ns+" for "+s);
			if(ns==os)
				break;
			os = ns;
			System.out.println("ns at end="+ns);
		}
		return max;

	
	}

}