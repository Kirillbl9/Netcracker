package injector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class InjectorParser {

    public static HashMap <String, String> parserInjector(String filePath) {
        HashMap <String, String> map = new HashMap <>();
        FileReader fr = null;
        try {
            fr = new FileReader( filePath );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
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
        return map;
    }
}



