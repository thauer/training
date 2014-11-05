package net.hauers.algo;

import java.util.List;
import java.util.ArrayList;

public class Sorter {

  public static void qsort(List<? extends Comparable> list) {
    qsort(list, 0, list.size()-1);
  }

  public static <T extends Comparable<? super T>> void qsort(List<T> list, int start, int end) {
    int left = start;
    int right = end;

    for(;left<right;){
      right = moveright(list, left++, right);
      left = moveleft(list, left, right--);
    }
    
    if(start<right) qsort(list, start, right);
    if(left<end) qsort(list, left, end);
  }

  public static <T extends Comparable<? super T>> int moveright(List<T> list, int start, int end) {
    int i = end;
    for(; list.get(i).compareTo(list.get(start)) > 0; i--);
    if(i > start) swap(list, i, start);
    return i;
  }

  public static <T extends Comparable<? super T>> int moveleft(List<T> list, int start, int end) {
    int i = start;
    for(; list.get(i).compareTo(list.get(end)) < 0; i++);
    if(i < end) swap(list, i, end);
    return i;
  }

  public static <T> void swap(List<T> list, int i1, int i2) {
    T temp = list.get(i1);
    list.set(i1, list.get(i2));
    list.set(i2, temp);
  }
}