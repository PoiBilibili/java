package edu.neu.coe.info6205.sort.simple;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

import edu.neu.coe.info6205.util.Benchmark;

public class SortTime {
	
	private SelectionSort ss = new SelectionSort();
	private ShellSort shs = new ShellSort(3);
	
	public double insertionSortTime(Comparable[] arr, int exptime) {
		InsertionSort is = new InsertionSort();
		Function<Comparable[], Void> insertion = (i) -> {
			is.sort(i);
			return null;
		};
		Benchmark insertionMark = new Benchmark(insertion);
		insertionMark.run(arr, 10);//warm up
		double ret = 0.0;
		for(int i = 0; i<exptime; i++) ret += insertionMark.run(arr, 10);
		return ret/exptime;
	}
	public double selectionSortTime(Comparable[] arr, int exptime) {
		SelectionSort is = new SelectionSort();
		Function<Comparable[], Void> selection = (i) -> {
			is.sort(i);
			return null;
		};
		Benchmark selectionMark = new Benchmark(selection);
		selectionMark.run(arr, 10);//warm up
		double ret = 0.0;
		for(int i = 0; i<exptime; i++) ret += selectionMark.run(arr, 10);
		return ret/exptime;
	}
	public double shellSortTime(Comparable[] arr, int exptime) {
		ShellSort is = new ShellSort(3);
		Function<Comparable[], Void> shell = (i) -> {
			is.sort(i);
			return null;
		};
		Benchmark shellMark = new Benchmark(shell);
		double ret = 0.0;
		for(int i = 0; i<exptime; i++) ret += shellMark.run(arr, 10);
		return ret/exptime;
	}
	public void randomData(int max) {
		for(int size = 1; size<=max; size++) {
			Integer[] arr = new Integer[size];
			Random r = new Random();
			for(int k = 0; k <size; k++) arr[k] = r.nextInt(1000);
			SortTime st = new SortTime();
			System.out.println(size+" "+st.insertionSortTime(arr,10)+" "+st.selectionSortTime(arr,10)+" "
								+st.shellSortTime(arr,10));
		}
	}
	public void orderedData(int max) {
		for(int size = 1; size<=max; size++) {
			Integer[] arr = new Integer[size];
			for(int k = 0; k <size; k++) arr[k] = k;
			SortTime st = new SortTime();
			System.out.println(size+" "+st.insertionSortTime(arr,10)+" "+st.selectionSortTime(arr,10)+" "
								+st.shellSortTime(arr,10));
		}
	}
	public void reversedData(int max) {
		for(int size = 1; size<=max; size++) {
			Integer[] arr = new Integer[size];
			for(int k = 0; k <size; k++) arr[k] = size-k-1;
			SortTime st = new SortTime();
			System.out.println(size+" "+st.insertionSortTime(arr,10)+" "+st.selectionSortTime(arr,10)+" "
								+st.shellSortTime(arr,10));
		}
	}
	public void partiallyOrderedData(int max) {
		for(int size = 1; size<=max; size++) {
			Integer[] arr = new Integer[size];
			Random r = new Random();
			for(int k = 0; k <size; k++) arr[k] = r.nextInt(1000);
			Arrays.sort(arr, size/4, size/2);
			Arrays.sort(arr, 3*size/4, size);
			SortTime st = new SortTime();
			System.out.println(size+" "+st.insertionSortTime(arr,10)+" "+st.selectionSortTime(arr,10)+" "
								+st.shellSortTime(arr,10));
		}
	}
	public static void main(String args[]) {
		SortTime st = new SortTime();
		//st.randomData(600);
		//st.orderedData(600);
		//st.reversedData(600);
		st.partiallyOrderedData(600);
	}
	
}
