package com.gmail.amator455;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("How much money do you have?");
		double money = sc.nextDouble();
		if (money >= 1000000000.0) {
			System.out.println("It is too much, downscaleing it to 999999999.99$");
			money = 999999999.99;
		}

		numbersInWords(money);

	}

	public static void numbersInWords(double money) {
		
		String result = "";

		String[] onesText = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String[] tenthText = { "twenty-", "thirty-", "forty-", "fifty-", "sixty-", "seventy-", "eighty-", "ninety-" };

		int hundreds = 0;
		int tenth = 0;
		int ones = 0;

		for (int i = 0; i <= 3; i++) {
			if (i == 0 && money >= 1000000.0) {
				// millions part
				hundreds = (int) (money / 100000000.0);
				money -= hundreds * 100000000.0;
				tenth = (int) (money / 10000000.0);
				money -= tenth * 10000000.0;
				ones = (int) (money / 1000000.0);
				money -= ones * 1000000.0;
			} else if (i == 0 && money < 1000000.0) {
				continue;
			}

			if (i == 1 && money >= 1000.0) {
				// thousands part
				hundreds = (int) (money / 100000.0);
				money -= hundreds * 100000.0;
				tenth = (int) (money / 10000.0);
				money -= tenth * 10000.0;
				ones = (int) (money / 1000.0);
				money -= ones * 1000.0;
			} else if (i == 1 && money < 1000.0) {
				continue;
			}

			if (i == 2 && money >= 1.0) {
				// under thousands part
				hundreds = (int) (money / 100.0);
				money -= hundreds * 100.0;
				tenth = (int) (money / 10.0);
				money -= tenth * 10.0;
				ones = (int) money;
				money -= ones;
			} else if (i == 2 && money < 1.0) {
				continue;
			}

			if (i == 3 && money >= 0.01) {
				// cents
				hundreds = 0;
				tenth = (int) (money / 0.1);
				money -= tenth * 0.1 - 0.001;
				ones = (int) (money / 0.01);
			} else if (i == 3 && money < 0.01) {
				continue;
			}

			if (hundreds != 0)
				result += onesText[hundreds - 1] + " hundred ";

			if (tenth != 0 && tenth > 1)
				result += tenthText[tenth - 2] + "";

			if (ones != 0 && (tenth > 1 || tenth == 0)) {
				result += onesText[ones - 1] + " ";
			} else if (ones != 0 && tenth == 1) {
				result += onesText[ones + 9] + " ";
			}

			if (i == 0) {
				result += "million ";
			} else if (i == 1) {
				result += "thousand ";
			} else if (i == 2) {
				result += "dollars ";
			} else {
				result += "cents";
			}
		}

		System.out.println(result);

	}

}
