package algorithms.Sort;

import myArrayList.MyArrayList;
import entities.Person;

public final class BubbleSort {
    public static void bubbleSortById(MyArrayList<Person>  personList) {
        Person temp;
        for (int i=0; i < personList.size(); i++) {
            for (int j=1; j < personList.size() - i; j++) {
                if (personList.get( j - 1 ).getId() > personList.get( j ).getId()) {
                    temp = personList.get(j - 1);
                    personList.set(j - 1, personList.get(j));
                    personList.set(j, temp);
                }
            }
        }
    }

    public static void bubbleSortByName(MyArrayList<Person>  personList) {
        Person temp;
        for (int i=0; i < personList.size(); i++) {
            for (int j=1; j < personList.size() - i; j++) {
                if (personList.get( j - 1 ).getFirstName().charAt(0) > personList.get( j ).getFirstName().charAt(0)) {
                    temp = personList.get(j - 1);
                    personList.set(j - 1, personList.get(j));
                    personList.set(j, temp);
                }

            }
        }
    }
}
