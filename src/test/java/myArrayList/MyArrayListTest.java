package myArrayList;

import entities.Division;
import entities.Person;
import org.junit.Test;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class MyArrayListTest {

    @Test
    public void size() {

        MyArrayList<Person>  listOfPersons = new MyArrayList();
        int startSize=listOfPersons.size();

        listOfPersons.add(
                new Person(1,
                        "Petr",
                        Gender.MALE,
                        "null",
                        null,
                        new Division("J"),
                        new BigDecimal(2352)
                )
        );
        assertTrue(startSize == listOfPersons.size() - 1);
    }

    @Test
    public void add() {
        MyArrayList<Person> listOfPersons = new MyArrayList();

        listOfPersons.add(
                new Person(1,
                        "Petr",
                        Gender.MALE,
                        "null",
                        null,
                        new Division("J"),
                        new BigDecimal(2352)
                )
        );
        assertEquals( "Petr", listOfPersons.get( 0 ).getFirstName() );
        assertTrue( listOfPersons.size() != 0 );
        System.out.println("nice");
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void get() {
        MyArrayList<Person>  listOfPersons = new MyArrayList();
        listOfPersons.get(-1);
    }

    @Test
    public void delete() {
        MyArrayList<Person>  listOfPersons = new MyArrayList<>();

        listOfPersons.add(
                new Person(1,
                        "Petr",
                        Gender.MALE,
                        "null",
                        null,
                        new Division("J"),
                        new BigDecimal(2352)
                )
        );


        listOfPersons.add(
                new Person(1,
                        "Petr",
                        Gender.MALE,
                        "null",
                        null,
                        new Division("J"),
                        new BigDecimal(2352)
                )
        );
        assertEquals( listOfPersons.size(), 2 );
        listOfPersons.delete( 1 );
        assertEquals( listOfPersons.size(), 1 );
    }
}