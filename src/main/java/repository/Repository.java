 /**
 * Info about this package doing something for package-info.java file.
 */
package repository;

 import entities.Person;
 import ru.home.injector.ExceptionInject;

 import static ru.home.injector.Injector.inject;

 /**
 * The class creates and stores persons.
 * @author Kirill
 * @version 1.0
 */
public class Repository {

     public static void main(String args[]) throws ExceptionInject {

         Person p =  new Person();
         inject(p);



       /*     MyArrayList<Person> u = list.searchBy(i -> i.getId() == 30000);
         for (int i = 0; i < u.size(); i++) {
             System.out.println(u.get(i)+" "+i);
         }*/


    /*MyArrayList<Person> list = parser("C:\\Games\\ss.txt");
         for(int i = 0;i<list.size();i++){
             System.out.println(list.get(i));
         }*/



         //BubbleSort.bubbleSortByName(list);
        // list.sortBy(new ComparateClass());
        /* for (int i = 0; i < list.size(); i++) {
             System.out.println(list.get(i));
         }*/
         //printDivision();

        /*
         BubbleSort.bubbleSortByAge(listOfPersons);
         BubbleSort.bubbleSortByName(listOfPersons);
         InsertionSort.insertionSortByAge(listOfPersons);
         InsertionSort.insertionSortByName(listOfPersons);
         System.out.println( "After sort :" );
         MyArrayList targetList = LinearSearch.linearSearchByName(listOfPersons,"Egor");
         MyArrayList targetList2 = LinearSearch.linearSearchByCity(listOfPersons,"Voronej");
         MyArrayList targetList3=BinarySearch.binarySearchByCity( listOfPersons, "Moscow" );
         */
     }
 }

