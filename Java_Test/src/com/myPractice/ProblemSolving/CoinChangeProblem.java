package com.myPractice.ProblemSolving;

public class CoinChangeProblem {
	public static int getAllCombinations(int[] coinSet,int value) {
		int row=coinSet.length+1;
		int col=value+1;
		int[][] combArr= new int[row][col];
		for(int i=0;i<row;i++) {
			combArr[i][0]= 1;
		}
		for(int i=1;i<col;i++) {
			combArr[0][i]= 0;
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(i>j) {
					combArr[i][j]=combArr[i-1][j];
				}else {
					combArr[i][j]=combArr[i-1][j]+combArr[i][j-i];
				}
			}
		}
		//print2DArray(combArr);
		return combArr[row-1][col-1];
	}
	private static void print2DArray(int[][] combArr) {
		int col=combArr[0].length;
		int row = combArr.length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(combArr[i][j]);
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		int value=4;
		int[] coinSet = {1,2,3};
		System.out.println(getAllCombinations(coinSet,value));
	}
}
