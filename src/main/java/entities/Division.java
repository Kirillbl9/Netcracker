package entities;

import ru.vsu.lab.entities.IDivision;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Division implements IDivision {
    private Integer id;
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Division(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals( id, division.id ) &&
                Objects.equals( name, division.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name );
    }

    public Division() {
    }

    static Map <String, Division> divisionMap = new HashMap <>();


    public static void addDivisionToMap(String d) {
       /* if (!divisionMap.containsValue(d)) {
            divisionMap.put(d, new Division(d));
        }*/
        divisionMap.putIfAbsent(d, new Division(d));
    }

    public static Division returnDivision(String str){
        Division div = divisionMap.get(str);
        return div;
    }

    public static void printDivision() {
        for (Map.Entry <String, Division> item : divisionMap.entrySet()) {
            System.out.printf(item.getKey() + item.getValue().toString());
        }
    }
}
