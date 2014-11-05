package net.hauers.algo;

import java.util.List;
import java.util.ArrayList;

public class Sorter {

  public static void qsort(List<? extends Comparable> list) {
    qsort(list, 0, list.size()-1);
  }

  public static <T extends Comparable<? super T>> void qsort(List<T> list, int start, int end) {
    if(start>=end) {
      return;
    }
    int right = start - 1;
    for(int i = start; i <= end; i++) {
      if(list.get(i).compareTo(list.get(end)) < 0) {
        swap(list, i, ++right);
      }
    }
    swap(list, end, ++right);
    qsort(list, start, right-1);
    qsort(list, right+1, end);
  }

  public static <T> void swap(List<T> list, int i1, int i2) {
    T temp = list.get(i1);
    list.set(i1, list.get(i2));
    list.set(i2, temp);
  }
}

