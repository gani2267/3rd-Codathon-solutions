import java.util.*;

class Solution
{
    static String temp;
    static ArrayList<String> s1= new ArrayList<>();
    static ArrayList<String> s2= new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();
        temp=str;
        operation(str,"");
        for(int i=0;i<s1.size();i++)
        {
            if(s1.get(i).compareTo(temp)>0)
            {
                s2.add(s1.get(i));
            }
        }
        String arr[]= new String[s2.size()];
        for(int i=0;i<s2.size();i++)
        {
            arr[i]=s2.get(i);
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void operation(String str, String asf)
    {

        if(str.length()==0)
        {
            s1.add(asf);
            return;
        }
        for(int i=0;i<str.length();i++)
        {

            char ch=str.charAt(i);
            String qlpart=str.substring(0,i);
            String qrpart=str.substring(i+1);
            String roq=qlpart+qrpart;
            operation(roq,asf+ch);
        }

    }
}
