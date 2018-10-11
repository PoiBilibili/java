package edu.neu.coe.info6205.sort.simple;

import java.util.Arrays;

public class QuickSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        //TODO do shuffle in X[] xs
    	quickSort(xs,from, to);
    }
    private void quickSort(X[] xs, int from, int to) {
    	if(from >= to) return;
    	int j = partitioning(xs, from, to);
    	quickSort(xs,from, j-1);
    	quickSort(xs, j+1, to);
    }
    private int partitioning(X[] xs, int from, int to) {
    	int i = from, j =to+1;
    	while(true) {
    		while(Helper.less(xs[++i], xs[from]))
    			if(i>=to) break;
    		while(Helper.less(xs[from], xs[--j]))
    			if(j<=0) break;
    		if(i>=j) break;
    		Helper.swap(xs, from, to, i, j);
    	}
    	Helper.swap(xs, from, to, from, j);
    	return j;
    }
}

