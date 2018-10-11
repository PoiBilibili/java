package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement selection sort
    	for(int i = 0; i<xs.length; i++) {
			int min = i;
			for(int j = i+1; j<xs.length; j++)
				if(less(xs[j], xs[min]))
					min = j;
			swap(xs,from,to, i, min);
		}
    }
}
