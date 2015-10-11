import java.util.*;
class StringPermute2
{

    //static String ans="";
    public static void main(String args[])
    {
        String s = "HHHHHHHHHVVVVVVVV";
        int k=1000011111;
        System.out.println("Final ans: "+fun(s, k+1));
        
    }//main


    public static String fun(String s, int k){
      
      System.out.println("Function called: "+s+" "+k);

      //Base case
      if(k==1)
        return s;

      int hc = ccount(s, 'H');
      int vc = ccount(s, 'V');  
     
      char c = s.charAt(0);
      int w = ways(s.substring(1));
      if(w >= k) //Contained inside
      {
        return (c+fun(s.substring(1), k));
      }
      else//Not contained inside, swap
      {
        String newstring=null;
        if(c=='H'){
          newstring = construct(hc, vc-1);
          return 'V'+fun(newstring, k-w);
        }
        else{
          newstring = construct(hc-1, vc);
          return 'H'+fun(newstring, k-w);
        }  

      }

    }//fun()

    public static int ccount(String s, char c){
      int cnt=0;
      for(int i=0;i<s.length();i++){
        if(s.charAt(i)==c)
          cnt++;
      }

      return cnt;  
    }
    
    public static String construct(int h, int v){
      String s="";
      for(int i=0;i<h;i++)
        s+="H";
      for(int i=0;i<v;i++)
        s+="V";      
      return s;
    }

    public static int ways(String s){
       if(s.length()==1)
        return 1; 

      int h=0, v=0;
      for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='V')
          v++;
        else
          h++;
      }
      return (fact(h+v)/fact(v))/fact(h);

    }//ways

    public static int fact(int n){
      if(n==0)
        return 1;
      else{
        int ans = 1;
        int i=2;
        while(i<=n){
          ans*=i;
          i++;
        }
        return ans;
      }
    }//fact()

}