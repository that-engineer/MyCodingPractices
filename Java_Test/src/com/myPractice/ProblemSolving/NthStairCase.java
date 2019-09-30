package com.myPractice.ProblemSolving;

public class NthStairCase {
	private static int numWays(int n, int[] m) {
		int[] total = new int[n+1];
		total[0]=1; total[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j:m) {
				if(i-j>=0) {
					total[i]=total[i]+total[i-j];
				}
			}
		}
		return total[n];
	}
	public static void main(String[] args) {
		int n = 5; int[] m = {1,2};
		System.out.println("No of ways to climb stair case are "+numWays(n,m));
	}

	

}
