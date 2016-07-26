package com.flipkart.scrap;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bela {

    public static void main(String[] args) {
       int num=0;
        int n,a,b,sum=0;
        Scanner scanner= new Scanner(System.in);
        num=scanner.nextInt();

        for(int j=1;j<=num;j++)
            {
           sum=0;a=0;b=0;n=0;
        a=scanner.nextInt();
        b=scanner.nextInt();
        n=scanner.nextInt();
        for(int i=1;i<=n;i++)
        {
            if(i==1)
                sum=sum+a+b;
        else
        sum=sum+(int)(a+Math.pow(2,(int)i-1)*b);
          System.out.print(sum+" ");      
}
            System.out.println();
        }
        
    }}