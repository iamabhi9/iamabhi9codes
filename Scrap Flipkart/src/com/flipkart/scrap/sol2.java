package com.flipkart.scrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class sol2 {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int[] arryint = new int[100];

		int n = 1;
		int d = 0;
		int q = 1;
		int x = 1;

		n = sc.nextInt();

		int[] dArray = new int[n];
		int[][] listArray = new int[500][500];

		for (int i = 0; i < n; i++) {
			dArray[i] = sc.nextInt();

			for (int j = 0; j < dArray[i]; j++) {
				listArray[i][j] = sc.nextInt();

			}

		}

		q = sc.nextInt();
		int[][] xy = new int[q][2];
		for (int i = 0; i < n; i++) {
			xy[i][0] = sc.nextInt();
			xy[i][1] = sc.nextInt();

		}

		for (int i = 0; i < q; i++) {
			try
			{


				if (xy[i][0]>n||xy[i][1]>dArray[xy[i][0] - 1])
				{
					System.out.println("XERROR!");

				}
				else
				{		try
				{if (listArray[xy[i][0] - 1][xy[i][1] - 1] > 0)
					System.out.println(listArray[xy[i][0] - 1][xy[i][1] - 1]);
				else
					System.out.println("YERROR!");

				}
				catch (ArrayIndexOutOfBoundsException e) {
					// TODO: handle exception
					System.out.println("ZERROR!");

				}

				}

			}
			catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("AERROR!");
e.printStackTrace();
			}



		}

	}

}
