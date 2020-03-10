package ru.home.injector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import static ru.home.injector.InjectorParser.parserInjector;

public class Injector {
    public static <T> T inject(T object) throws ExceptionInject {
        HashMap<String,String> map = parserInjector("C:\\Games\\inj.txt");
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field f : fields) {
            Annotation a = f.getAnnotation( LabInjector.class );
            f.setAccessible( true );
            if (a != null) {
                String type = f.getType().getSimpleName();
                String cl = map.get(type);
                Class<?> clazz = null;
                try {
                    clazz = Class.forName(cl);
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage()+"Class not found");
                    e.printStackTrace();
                }
                Constructor<?> cons = null;
                try {
                    cons = clazz.getDeclaredConstructor();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage()+"Create constructor error");
                }
                Object obj = null;
                try {
                    obj = cons.newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage()+"Create object eroor");
                }try {
                    f.set( object, obj );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new ExceptionInject(e.getMessage()+" inject error");
                }
            }
        }
        return null;
    }
}


//  Arrays.asList(fields).forEach(System.out::println);
//  object.geClass cl = Class.forName( object.getClass().getName() );
//                Object o = cl.getDeclaredConstructor().newInstance();
//                return (T) o;tClass();

       // System.out.println( object.getClass().getSimpleName() + " 0");
       // System.out.println( f.getClass() + " 1" );
       // System.out.println( object.getClass() + " 2" );
       // System.out.println( f.getType().getSimpleName() + " 3" );
       // System.out.println( f.getName() + " 4" );


// Class <?> cls = object.getClass();
// Field field = cls.getField( f.getName() );

/*

               String type = f.getType().getSimpleName();
               Object newObject = classToInterfaceMap.get( type );
               f.set( object, newObject );
               System.out.println(f.getType()+"- new type");*/
