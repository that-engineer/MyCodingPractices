package com.myPractice.ProblemSolving;

import java.util.Arrays;

public class CoinChangeProblemOptimized {
	public static void main(String[] args) {
		int value=10;
		int[] coinSet = {2, 5, 3, 6};
		System.out.println(getAllCombinationsOpt(coinSet,value));
	}

	private static long getAllCombinationsOpt(int[] coinSet, int value) {
		int m = coinSet.length;
		long[] table = new long[value+1];
		Arrays.fill(table, 0);
		
		table[0]=1;
		for(int i=0;i<m;i++) {
			for(int j=coinSet[i];j<=value;j++) {
				table[j]+=table[j-coinSet[i]];
			}
		}
		return table[value];
	}
}
