package com.sf;

import java.util.Random;

public class BaseMethod {

	/**
	 * 简单的int交换，基于int数组。不进行数组越界检查
	 * @param i
	 * @param j
	 * @param array
	 */
	public static void swap(int i, int j, int[] array){
		if (i == j)	// 当i j指向数组里同一个元素时，不交换数据
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 用伪随机数据填充数组
	 * @param array 被填充的数组
	 * @param range 填充值的范围, 需要一个正整数
	 * @return
	 */
	public static void randomIntArray(int[] array, int range){
		// List<Integer> arrayList = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(range);
		}
		System.out.println("size of this array is : " + array.length);
	}
	
	public static void printIntArray(int[] array) {
		System.out.println("begin to print an array.");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",\t");
		}
		System.out.println("print end.");
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[10];
		
		randomIntArray(array, 100);
		
		printIntArray(array);
	}

}
