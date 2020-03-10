package SpreamAPI;

import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static SpreamAPI.ParserStream.parserStream;

/*Выдать год рождения и сколько людей было рождено в этот год(создать мапу или лист)*/
public class StreamAPI4 {
    public static void main(String[] args) {
        ArrayList<Person> list = parserStream( "C:\\Games\\ss.txt" );
        List <Group> group = new ArrayList <>();
        for (int i = 0; i < list.size(); i++) {
            group.add(new Group(list.get(i).getBirthdate().getYear(),1));
        }

        Map<Integer, Long> map3 = group.stream()
                .collect( Collectors.groupingBy(Group::getDate, Collectors.counting()));
        map3.forEach( (k, v) -> System.out.println( k + " - " + v ) );
    }
    static class Group{
        Integer date;
        Integer people;

        public Group(Integer date, Integer people) {
            this.date = date;
            this.people = people;
        }

        public Integer getDate() {
            return date;
        }

        public void setDate(Integer date) {
            this.date = date;
        }

        public Integer getPeople() {
            return people;
        }

        public void setPeople(Integer people) {
            this.people = people;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "date=" + date +
                    ", people=" + people +
                    '}';
        }
    }
}


