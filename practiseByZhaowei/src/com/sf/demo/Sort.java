package com.sf.demo;

import com.sf.BaseMethod;

public class Sort {

	/**
	 * 冒泡排序
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		/*
		 * for (int i = 0; i < array.length - 1; i++) { for (int j = 0; j <
		 * array.length - 1; j++) { if (array[j] > array[j + 1])
		 * BaseMethod.swap(j, j + 1, array); } }
		 */
		for (int out = array.length - 1; out > -1; out--) {
			for (int in = 0; in < out; in++) {
				if (array[in] > array[in + 1])
					BaseMethod.swap(in, in + 1, array);
			}
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		int in, out, min;
		for (out = 0; out < array.length - 1; out++) {
			min = out;
			for (in = out + 1; in < array.length; in++) {
				if (array[in] < array[min])
					min = in;
			}
			BaseMethod.swap(out, min, array);
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param array
	 */
	public static void insertSort(int[] array) {
		for (int out = 1; out < array.length; out++) {
			int temp = array[out];
			int in = out;
			while (in > 0 && array[in - 1] >= temp) {
				array[in] = array[in - 1];
				--in;
			}
			array[in] = temp;
		}
	}

	/**
	 * 合并排序
	 * 
	 * @param i
	 *            数组起始(0)
	 * @param j
	 *            数组结束(array.length-1)
	 * @param array
	 * @param temp
	 *            临时工作区(same size of array)
	 */
	public static void mergeSort(int i, int j, int[] array, int temp[]) {
		int mid = (i + j) / 2;
		if (i < mid)
			mergeSort(i, mid, array, temp);

		if (mid + 1 < j)
			mergeSort(mid + 1, j, array, temp);

		mergeArrays(i, j, array, temp);
	}

	/**
	 * 合并排序的合并方法
	 * 
	 * @param i
	 *            数组起始(0)
	 * @param j
	 *            数组结束(array.length-1)
	 * @param array
	 * @param temp
	 *            临时工作区(same size of array)
	 */
	public static void mergeArrays(int i, int j, int[] array, int[] temp) {
		int tp = 0;
		int lp = i;
		int mid = (i + j) / 2;
		int hp = mid + 1;
		int n = j - i + 1;

		while (lp <= mid && hp <= j)
			if (array[lp] <= array[hp])
				temp[tp++] = array[lp++];
			else
				temp[tp++] = array[hp++];

		while (lp <= mid)
			temp[tp++] = array[lp++];

		while (hp <= j)
			temp[tp++] = array[hp++];

		for (int x = 0; x < n; x++)
			array[i + x] = temp[x];

	}

	/**
	 * 希尔排序
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array) {
		int in, out, temp;

		int h = 1;
		while (h <= array.length / 3)
			h = h * 3 + 1;

		while (h > 0) {
			for (out = h; out < array.length; out++) {
				temp = array[out];
				in = out;
				while (in > h - 1 && array[in - h] > temp) {
					array[in] = array[in - h];
					in -= h;
				}
				array[in] = temp;
			}
			h = (h - 1) / 3;
		}
	}

	// ////////////////////////
	/**
	 * 快速排序
	 * 
	 * @param array
	 * @return
	 */
	public static void quickSort(int[] array) {
		recQuickSort(0, array.length - 1, array);
	}

	public static void recQuickSort(int i, int j, int[] array) {
		int size = j - i + 1;
		if (size <= 3)
			manualSort(i, j, array);
		else {
			int privot = middleOfQS3(i, j, array);
			int patition = patitionIt(i, j, privot, array);
			recQuickSort(i, patition - 1, array);
			recQuickSort(patition + 1, j, array);
		}
	}

	/**
	 * 防止快速排序出现极端的执行效率O(N^2) 预先给出一个不太可能是极端极（数组中的最大或是最小值）做为中值
	 * 
	 * @param i
	 * @param j
	 * @param array
	 * @return
	 */
	public static int middleOfQS3(int i, int j, int[] array) {
		int m = (i + j) / 2;

		if (array[i] > array[m])
			BaseMethod.swap(i, m, array);
		if (array[i] > array[j])
			BaseMethod.swap(i, j, array);
		if (array[m] > array[j])
			BaseMethod.swap(j, m, array);

		BaseMethod.swap(m, j - 1, array);

		return array[j - 1];
	}

	/**
	 * 分治思想
	 * 
	 * @param i
	 * @param j
	 * @param privot
	 * @param array
	 * @return
	 */
	public static int patitionIt(int i, int j, int privot, int[] array) {
		int lp = i;
		int rp = j - 1;
		while (true) {
			while (array[++lp] < privot)
				;

			while (array[--rp] > privot)
				;

			if (lp >= rp)
				break;
			else
				BaseMethod.swap(lp, rp, array);
		}
		BaseMethod.swap(lp, j - 1, array);
		return lp;
	}

	public static void manualSort(int i, int j, int[] array) {
		int size = j - i + 1;
		if (size == 1)
			return;
		if (size == 2) {
			if (array[i] > array[j])
				BaseMethod.swap(i, j, array);
			return;
		}
		if (size == 3) {
			if (array[i] > array[i + 1])
				BaseMethod.swap(i, i + 1, array);
			if (array[i + 1] > array[j])
				BaseMethod.swap(i + 1, j, array);
			if (array[i] > array[j])
				BaseMethod.swap(i, j, array);
		}
	}

	// ///////////////////////////////////////////////////////////////////////////
	public static void compareSort() {
		int size = 9999999;
		int range = 9999999;
		int[] array = new int[size];
		long startat;
		
		/*BaseMethod.randomIntArray(array, range);
		startat = System.currentTimeMillis();
		bubbleSort(array);
		System.out.println("popUpSort spand " + (System.currentTimeMillis() - startat) + "ms.");

		BaseMethod.randomIntArray(array, range);
		startat = System.currentTimeMillis();
		selectSort(array);
		System.out.println("selectSort spand " + (System.currentTimeMillis() - startat) + "ms.");*/

		/*BaseMethod.randomIntArray(array, range);
		startat = System.currentTimeMillis();
		insertSort(array);
		System.out.println("insertSort spand " + (System.currentTimeMillis() - startat) + "ms.");

		BaseMethod.randomIntArray(array, range);
		startat = System.currentTimeMillis();
		mergeSort(0, size - 1, array, new int[size]);
		System.out.println("mergeSort spand " + (System.currentTimeMillis() - startat) + "ms.");*/
		// BaseMethod.printIntArray(array);

		BaseMethod.randomIntArray(array, range);
		startat = System.currentTimeMillis();
		shellSort(array);
		System.out.println("shellSort spand " + (System.currentTimeMillis() - startat) + "ms.");
		// BaseMethod.printIntArray(array);
		
		BaseMethod.randomIntArray(array, range);
		startat = System.currentTimeMillis();
		quickSort(array);
		System.out.println("quickSort spand " + (System.currentTimeMillis() - startat) + "ms.");
		// BaseMethod.printIntArray(array);
	}

	public static void test() {
		int size = 20;
		int range = 100;
		int[] array = new int[size];
		BaseMethod.randomIntArray(array, range);
		BaseMethod.printIntArray(array);
		quickSort(array);
		BaseMethod.printIntArray(array);
	}

	public static void main(String[] args) {
//		 test();
		compareSort();
	}

}