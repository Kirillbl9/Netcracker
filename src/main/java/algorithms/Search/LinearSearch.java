package algorithms.Search;


import myArrayList.MyArrayList;
import entities.Person;

public final class LinearSearch {
    public static MyArrayList linearSearchByName(MyArrayList<Person>  list, String name) {
        MyArrayList<Person>  newList = new MyArrayList();
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equals(name)) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    public static MyArrayList linearSearchBySurName(MyArrayList<Person>  list, String surName) {
        MyArrayList<Person>  newList = new MyArrayList();
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getLastName().equals(surName)) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
