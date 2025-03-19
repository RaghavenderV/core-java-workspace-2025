package com.vodapally.logics;
/*
* Author@ Raghavender Vodapally
* Date@ Jun 28, 2018
*/
//asked in Apple client online test
public class WaysOfCollectingDonations {

	public static void main(String[] args) {
		int rupees = 5;
		int houses = 5;
		
		int maxWays = findWays(rupees, houses);
		
		System.out.println("You can collect "+rupees+ "Rs. "+" in "+maxWays+" different ways.");

	}

	public static int findWays(int rupees, int houses) {
		int counter =0; int remain =0; int copy = rupees;
		int temp[][] = new int[houses][rupees];
		
		for (int i = 0; i < houses; i++) {
			for (int j = 0; j < rupees; j++, rupees--) {
				temp[i][j] = rupees;
				if(temp[i][j] == copy) {
					break;
				}
				else {
					
				}
			}
		}
		return counter;
	}

	

}

