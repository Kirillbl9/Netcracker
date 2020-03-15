package algorithms.Search;

import algorithms.Sort.BubbleSort;
import myArrayList.MyArrayList;
import entities.Person;

public final class BinarySearch {
    public static MyArrayList binarySearchByName(MyArrayList<Person>  list, String name) {
        BubbleSort.bubbleSortByName(list);
        int firstIndex = 0;
        int lastIndex = list.size();
        MyArrayList newList = new MyArrayList();
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (list.get( middleIndex ).getFirstName().equals(name)) {
                newList.add(list.get(middleIndex));
                return newList;
            }
            else if (list.get( middleIndex ).getFirstName().charAt(0) < name.charAt(0))
                firstIndex = middleIndex + 1;
            else if (list.get( middleIndex ).getFirstName().charAt(0) >  name.charAt(0))
                lastIndex = middleIndex - 1;
        }
        return null;
    }
    public static MyArrayList binarySearchBySurName(MyArrayList<Person>  list, String surName) {
        int firstIndex = 0;
        int lastIndex = list.size();
        MyArrayList newList = new MyArrayList();
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (list.get( middleIndex ).getLastName().equals(surName)) {
                newList.add(list.get(middleIndex));
                return newList;
            }
            else if (list.get( middleIndex ).getLastName().charAt(0) < surName.charAt(0))
                firstIndex = middleIndex + 1;
            else if (list.get( middleIndex ).getLastName().charAt(0) >  surName.charAt(0))
                lastIndex = middleIndex - 1;
        }
        return null;
    }
}
