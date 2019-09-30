package com.myPractice.ProblemSolving;
/**
 * 
 * @author Rahul
 * Kadane's Algorithm
 */
public class MaxSubarraySum {
	public static int getMaxSubarraySum(int[] arr) {
		int maxSum=arr[0],minSum=arr[0],maxGlobal=arr[0];
		int l=arr.length;
		for(int i=1;i<l;i++) {
			maxSum=Math.max(maxSum, maxSum+arr[i]);
			//minSum=Math.min(minSum, minSum+arr[i]);
			if(maxSum>maxGlobal) {
				maxGlobal=maxSum;
			}
		}
		return maxGlobal;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,-2,5};
		System.out.println(getMaxSubarraySum(arr));
	}

}
