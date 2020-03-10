package SpreamAPI;

import entities.Person;

import java.util.ArrayList;

import static SpreamAPI.ParserStream.parserStream;

public class StreamAPI3 {
    public static void main(String[] args) {
        ArrayList <Person> list = parserStream( "C:\\Games\\ss.txt" );
        list.stream()
                .filter( p -> p.getFirstName().toLowerCase().contains( "aa" ) )
                .forEach( System.out::println );
    }
}

