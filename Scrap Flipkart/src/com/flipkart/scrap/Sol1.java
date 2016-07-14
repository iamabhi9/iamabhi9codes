package com.flipkart.scrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);

		int count = 0;
		String myst = br.readLine();
		String output = "";
		String temp = "";
		while (count < myst.length()) {
			if (myst.charAt(count) == '(') {
				output = output.concat(String.valueOf(myst.charAt(count)));
				count++;
			} else if (myst.charAt(count) == ')') {
				output = output.concat(new StringBuffer(temp).reverse().toString());
				output = output.concat(String.valueOf(myst.charAt(count)));

				temp = "";
				count++;
			} else {
				temp = temp.concat(String.valueOf(myst.charAt(count)));
				count++;

			}

		}
		output = output.concat(new StringBuffer(temp).reverse().toString());

		System.out.println(output);
	}

}
