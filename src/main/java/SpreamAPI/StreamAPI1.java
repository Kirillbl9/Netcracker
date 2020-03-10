package SpreamAPI;

import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static SpreamAPI.ParserStream.parserStream;

public class StreamAPI1 {
    public static void main(String[] args) {
        ArrayList<Person> list = parserStream( "C:\\Games\\ss.txt" );
        List <Div> div = new ArrayList <>();
        for (int i = 0; i < list.size(); i++) {
                div.add( new Div(list.get(i).getDivision().getName(), list.get(i).getSalary().intValue() ));
        }
            Map<String, Integer> map = div.stream()
                    .collect(
                            Collectors.groupingBy(Div::getName,
                            Collectors.summingInt(Div::getSalary)));
        map.forEach( (k, v) -> System.out.println( k + " - " + v ) );

    }
    static class Div{
        String name;
        Integer salary;

        public Div(String name, Integer salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Integer getSalary() {
            return salary;
        }
    }
}








 /* ArrayList <Person> list = parserStream( "C:\\Games\\ss.txt" );

        Map <String, Integer> map = new HashMap <>();
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i).getDivision().toString());
            if (!map.containsKey( list.get( i ).getDivision().getName() )) {
                map.put( list.get( i ).getDivision().getName(), 0 );
            } else {
                map.put(
                        list.get( i ).getDivision().getName(),
                        map.get( list.get( i ).getDivision().getName() ) + list.get( i ).getSalary().intValue()
                );
            }
        }
        map.forEach( (k, v) -> System.out.println( k + " - " + v ) );



    //   Stream<Person> streamFromCollection = list.stream();

      //  System.out.println(streamFromCollection.count());
*/






