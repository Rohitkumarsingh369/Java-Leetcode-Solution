// { Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}// } Driver Code Ends


class GfG {
    int convertfive(int num) {
        // Your code here
        int digit=0,p=1,result=0;
        int temp=num;
        while(temp>0){
            digit=temp%10;
            if(digit==0)
                digit=5;
            
            result=digit*p+result;
            temp=temp/10;
            p*=10;
            
        }
        if(num==0)
            return 5;
            
        return result;
    }
}