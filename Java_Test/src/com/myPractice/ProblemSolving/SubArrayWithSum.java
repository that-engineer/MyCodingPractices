package com.myPractice.ProblemSolving;

public class SubArrayWithSum {
	public static void getSubArrayWithSum(int[] arr, int sum) {
		int currSum=arr[0],s=0,e=1,l=arr.length;
		for(int i=1;i<l;i++) {
			while(currSum<sum) {
				currSum+=arr[e];
				e++;
			}
			while(currSum>sum) {
				currSum=currSum-arr[s];
				s++;
			}
			if(currSum==sum) {
				System.out.println("Index "+s+" "+(e-1));
				break;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
		getSubArrayWithSum(arr, 23);
	}

}
