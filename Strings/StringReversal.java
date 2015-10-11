class StringReversal
{
	public static void main(String args[])
	{
		String s  = "abcdef";
		int len = s.length();
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<=len/2;i++)
		{
			sb.setCharAt(i,s.charAt(len-i-1));
			sb.setCharAt(len-i-1,s.charAt(i));
		}
		System.out.println(sb.toString());
	}
}