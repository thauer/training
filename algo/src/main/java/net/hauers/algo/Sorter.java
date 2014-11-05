package net.hauers.algo;

import java.util.List;
import java.util.ArrayList;

public class Sorter {

  public static void qsort(List<? extends Comparable> list) {
    qsort(list, 0, list.size()-1);
  }

  public static <T extends Comparable<? super T>> void qsort(List<T> list, int start, int end) {

    // int pivot = start;

    // int left = start;
    // int right = end;

    // for(; list.get(left).compareTo(list.get(pivot))<0; left++);
    
    // swap(list, left, pivot);
    // int tmp = pivot
    // int pivot = left
    // int left = tmp

    // for(; list.get(right).compareTo(list.get(pivot))>0; right--);
    
    // swap(list, right, pivot);
    // int tmp = pivot
    // int pivot = right
    // int right = tmp

  }


  public static <T extends Comparable<? super T>> int walkleft(List<T> list, int start, int end) {
    int pivot = start;
    
  }

  public static <T> void swap(List<T> list, int i1, int i2) {
    T temp = list.get(i1);
    list.set(i1, list.get(i2));
    list.set(i2, temp);
  }
}