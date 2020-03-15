package algorithms.Sort;

import myArrayList.MyArrayList;
import entities.Person;

public final class InsertionSort {
    public static void insertionSortById(MyArrayList<Person>  list) {
        for (int i = 1; i < list.size(); i++) {
            Person temp = list.get(i);
            int j = i - 1;
            while(j >= 0 && temp.getId() < list.get(j).getId()) {
                    list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,temp);
        }
    }

    public static void insertionSortByName(MyArrayList<Person>  list) {
        for (int i = 1; i < list.size(); i++) {
            Person temp = list.get(i);
            int j = i - 1;
            while(j >= 0 && temp.getFirstName().charAt(0) < list.get(j).getFirstName().charAt(0)) {
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,temp);
        }
    }
}
