package com.flipkart.scrap;

import java.io.*;
import java.util.Collection;
import java.util.Collections;

public class Solution {
	public static void main(String args[]) throws Exception {

		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int[] arryint = new int[100];

		System.out.println("Input count");
		int count = 0;
		String myint = br.readLine();
		count = Integer.parseInt(myint);

		for (int i = 0; i < count; i++) {
			myint = br.readLine();
			arryint[i] = Integer.parseInt(myint);

		}

		int[] arryout = new int[100];
		int pos = 0;

		for (int i = 0; i < count; i++) {
			boolean flag = true;

			for (int j = 2; j <= arryint[i] / 2; j++) {
 				if (arryint[i] % j == 0) {
					flag = false;
				}
				
			}
			 if (arryint[i]==1)
			 {	  flag=false;
			 }
			if (flag == true) {
				arryout[pos] = arryint[i];
				arryint[i] = 0;
				pos++;
			}

		}

		for (int i = 0; i < count; i++) {
			if (arryint[i] > 0) {
				if (arryint[i] % 2 == 0) {
					arryout[pos] = arryint[i];
					arryint[i] = 0;
					pos++;

				}
			}
		}

		for (int i = 0; i < count; i++) {
			if (arryint[i] > 0) {
				arryout[pos] = arryint[i];
				pos++;

			}
		}
		System.out.print("[");

		for (int i = 0; i < count; i++) {
			System.out.print(arryout[i]+",");
		}
		System.out.print("]");

	}
}