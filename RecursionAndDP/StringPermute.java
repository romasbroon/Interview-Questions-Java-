import java.util.*;
class StringPermute
{
    public static void main(String args[])
    {
        String s = "hhvv";
        
        ArrayList<Character> init = new ArrayList<Character>();
        for(int i=0;i<s.length();i++)
        {
            init.add(i,(Character)s.charAt(i));
        }
        
        
        ArrayList<String> ans = permute(init);
        //Remove duplicates
        HashSet<String> ret = new HashSet<String>();
        ArrayList<String> finalvals = new ArrayList<String>();


        for(String st : ans)
        	ret.add(st);

        Iterator iterator = ret.iterator(); 
      	
	   // check values
	   while (iterator.hasNext()){
	   		finalvals.add((String)iterator.next());  
	   }
	   Collections.sort(finalvals);

	   for(String st: finalvals)
	   		System.out.println(st);
    }
    
    public static ArrayList<String> permute(ArrayList<Character> set)
    {
        if(set.size()==1)
        {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(Character.toString(set.get(set.size()-1))); 
            return temp;
        }
        
         ArrayList<String> ans = new ArrayList<String>();  
         
         for(int i=0;i<set.size();i++)
         {
            ArrayList<Character> tempset = new ArrayList<Character>();
            char c = (Character)set.get(i);
            for(int j=0;j<set.size();j++)
            {
                if(j!=i){
                	char c_temp = (Character)set.get(j);
                    tempset.add((Character)c_temp);
                }
            }    
             ArrayList<String> substrings = permute(tempset);
             for(String s : substrings)
                 ans.add(c+s);
             
         }   
         return ans;   
    }
}