package spreamAPI;

import entities.Person;

import java.util.ArrayList;

import static spreamAPI.ParserStream.parserStream;

public class StreamAPI2 {
    public static void main(String[] args) {
        ArrayList<Person> list = parserStream( "C:\\Games\\ss.txt" );
        list.stream()
                .filter(p-> p.getAge()>30)
                .filter(p-> p.getSalary().intValue()<5000)
                .filter(p-> p.getFirstName().toLowerCase().contains("a"))
                .forEach(System.out::println);
    }
}
