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
        int[] a = new int[n];
        for(int i=0;i<a.length;i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.println(m.findans(a,0,-1));
    }
    public int findans(int[] a,int idx,int pre)
    {
        if(idx==a.length)
        {
            return 0;
        }
        int l1=0,l2=0;
        if(pre!=-1)
        {
            if(a[pre]<a[idx])
            {
                l1 = 1+findans(a,idx+1,idx);
                // System.out.println("helo "+ l1);
            }
            l2 = findans(a,idx+1,pre);
            // System.out.println("hello inside " + l1  + " " + l2);
            return Math.max(l1,l2);
        }
        l1 = findans(a,idx+1,idx)+1;
        l2 = findans(a,idx+1,pre);
        return Math.max(l1,l2);
    }
}