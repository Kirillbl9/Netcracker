package myArrayList;

import ru.vsu.lab.repository.IRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * The class implements array list.
 */
public final class MyArrayList<T> implements IRepository<T> {
        //implements IRepository
    /**
     * initial array size.
     */
    private static final int CAPACITY = 10;

    /**
     * initial list size.
     */

    private int size = 0;
    /**
     * array of person type.
     */
     private Object personStore[] = new Object[CAPACITY];
/*

     */
/**
     * Constructor for create list type person.
     *//*

    public MyArrayList() {
        personStore = new Object[CAPACITY];
    }
*/

     /**
     * The method return size of list.
     *
     * @return size of list
     */
    public int size() {
        return size;
    }

    /**
     * The method add a new person to list.
     *
     * @param e which add to list
     */
    public void add(T e) {
        if (size == personStore.length) {
            growCapacity();
        }
        personStore[size++] = e;
    }

    /**
     * The method add a new person to list.
     * @param index of position
     * @param e which add to list
     */
    public void add(int index, T e) {
        if (size == personStore.length) {
            growCapacity();
        }
        for (int i = size; i > index; i--) {
            personStore[i] = personStore[i - 1];
        }
        personStore[index] = e;
        size++;
    }

    /**
     * The method set person on index
     * @param index of position
     * @param e which set to list
     */
    public T set(int index, T e) {
        personStore[index] = e;
        return e;
    }

     /**
     * The method create new list and copy then elements from.
     * old if need bigger capacity of the list
     */

    private void growCapacity() {
        int newSize = personStore.length + 1;
        personStore = Arrays.copyOf(personStore, newSize);
    }

    /**
     * The method to gets person from list by his index.
     *
     * @param index of the person
     * @return person
     */
    public T get(int index) {
        if(personStore[index] == null)
            return null;
        if (index < size) {
            return (T) personStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * The method to remove person from list.
     *
     * @param index of the person
     * @return person
     * @throws ArrayIndexOutOfBoundsException If index more then size
     */

    public T delete(int index) {
        if (index < size) {
            T person =(T) personStore[index];
            personStore[index] = null;
            int tmp = index;
            while (tmp < size) {
                personStore[tmp] = personStore[tmp + 1];
                personStore[tmp + 1] = null;
                tmp++;
            }
            size--;
            return person;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * The method remake array to list.
     * @return list
     */
    public List<T> toList() {
        List<T> list = Arrays.asList((T)personStore);
        return list;
    }
    public void sortBy(Comparator<T> comparator){
        for(int i =0;i< personStore.length-1;i++){
            for(int j =0;j< personStore.length-1-i;j++) {
                if (comparator.compare((T) personStore[j],(T) personStore[j + 1] ) > 0) {
                    T temp = (T)personStore[j];
                    personStore[j] = personStore[j + 1];
                    personStore[j + 1] = temp;
                }
            }
        }
    }

    public MyArrayList searchBy(Predicate <T> predicate) {
        MyArrayList<T> myList = new MyArrayList<>();
        for (int i = 0;i<personStore.length;i++) {
            if (predicate.test((T)personStore[i])) {
                myList.add((T)personStore[i]);
            }
        }
        return myList;
    }
}
