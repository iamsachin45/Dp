import java.io.*; 
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.IOException;
import java.math.BigInteger;
public class Main
{ 
    public static void main(String[] args) throws IOException
    {
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } 
        catch (Exception e) 
        {
            System.err.println("Error");
        }
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        int n = sc.nextInt();
        int max = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i=0;i<n;i++)
        {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        System.out.println(m.vacation(w,v,max,n-1));
    }
    public int vacation(int[] w,int[] v,int max,int idx)
    {
        if(idx==0)
        {
            if(w[idx]<=max)
            {
                return v[idx];
            }
            return 0;
        }
        // recursion 
        // not pick
        int notpick = vacation(w,v,max,idx-1);
        int pick = 0;
        if(max>=w[idx])
        {
            pick = v[idx] + vacation(w,v,max-w[idx],idx-1);
        }
        return Math.max(pick,notpick);
        
    }
}