package com.myPractice.ProblemSolving;

public class ProductOfArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];

		int[] t1 = new int[nums.length];
		int[] t2 = new int[nums.length];

		t1[0] = 1;
		t2[nums.length - 1] = 1;

		// scan from left to right
		for (int i = 0; i < nums.length - 1; i++) {
			t1[i + 1] = nums[i] * t1[i];
		}

		// scan from right to left
		for (int i = nums.length - 1; i > 0; i--) {
			t2[i - 1] = t2[i] * nums[i];
		}
		for (int k : t1) {
			System.out.print(k + " ");
		}
		System.out.println();
		for (int j : t2) {
			System.out.print(j + " ");
		}
		System.out.println();
		// multiply
		for (int i = 0; i < nums.length; i++) {
			result[i] = t1[i] * t2[i];
		}

		return result;
	}

	public static void main(String[] arg) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] res = new int[6];
		res = productExceptSelf(arr);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
