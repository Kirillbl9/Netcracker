package repository;

import ru.home.MyArrayList;
import entities.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static entities.Division.addDivisionToMap;
import static entities.Division.returnDivision;
import static entities.Person.toGender;

public class Parser {
    public static MyArrayList parser(String filePath) {
        MyArrayList listOfPersons = new MyArrayList();
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner( fr );
        String[] subStr;
        while (scan.hasNext()) {
            subStr = scan.next().split( "\\n" );
            for (int i = 0; i < subStr.length; i++) {
                String[] subStr3;
                subStr3 = subStr[i].split( ";" );
                //add division
                addDivisionToMap(subStr3[4]);
                //date convert
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate localDate = LocalDate.parse(subStr3[3], formatter);
                listOfPersons.add(
                        new Person(
                                Integer.parseInt( subStr3[0] ),
                                subStr3[1],
                                toGender( subStr3[2] ),
                                null,
                                localDate,
                                returnDivision(subStr3[4]),
                                new BigDecimal( subStr3[5] )
                        )
                );
            }
        }
        return listOfPersons;
    }
}
