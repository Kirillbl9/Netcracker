package injector;

import entities.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Person p = new Person(  );
       //  System.out.println( p.getClass().getSimpleName() + " 0");
        // System.out.println( p.getClass() + " 1" );
     //    System.out.println( p.getType().getSimpleName() + " 3" );
       //  System.out.println( p.getName() + " 4" );
        HashMap<String,String> map = new HashMap <>();
        FileReader fr = null;
        try {
            fr = new FileReader( "C:\\Games\\inj.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner( fr );
        String[] subStr;
        while (scan.hasNext()) {
            subStr = scan.next().split( "\\n" );
            for (int i = 0; i < subStr.length; i++) {
                String[] subStr3 = subStr[i].split( ";" );
                map.put( subStr3[0], subStr3[1] );
            }
        }
        map.forEach( (k, v) -> System.out.println( k + " - " + v ) );

    }

}
