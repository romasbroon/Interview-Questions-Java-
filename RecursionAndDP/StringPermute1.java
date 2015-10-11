import java.util.*;
class StringPermute1
{
    public static void main(String args[])
    {
        String s = "HHHHHVVVVV";
        
       
        
        ArrayList<String> ans = permute(s);
       

      
	   Collections.sort(ans);
    }
    
    public static ArrayList<String> permute(String s)
    {
        ArrayList<String> fans = new ArrayList<String>();
        int hc=0,vc=0;
        int n = s.length();
        for(int i=0;i<n;i++){
          if(s.charAt(i)=='H')
            hc++;
          else
            vc++;

        }

        int tot = (int)Math.pow(2.0, (double)n);
        tot-=1;
        for(int i=0;i<tot;i++)
        {
            String binary = Integer.toBinaryString(i);
            int len = binary.length();
            int diff = n-len;
            String temp="";
            for(int j=0;j<diff;j++)
                temp+='0';
            binary=temp+binary;
            
            String str = "";
            int thc=0, tvc=0;
            for(int j=0;j<n;j++){
                if(binary.charAt(j)=='0'){
                  str+="H";
                  thc++;
                }
                else{
                  str+="V";
                  tvc++;
                }
            }
            if(thc==hc){
              String temp1 = "";
              for(int t1=0;t1<n;t1++){
                if(binary.charAt(t1)=='0')
                  temp1+="H";
                else
                  temp1+="V";
              }

              fans.add(temp1);
            }  
        }



        return fans;
    }
}