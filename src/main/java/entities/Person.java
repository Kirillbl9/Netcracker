package entities;

import ru.home.injector.LabInjector;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
/**
 * The class describes entity person.
 */
public class Person implements IPerson {
    @LabInjector
    IPerson iPerson;

    /**
     * The id of person.
     */
    public Integer id;
    /**
     * The name of person.
     */
    private String firstName;
    /**
     * The gender of person.
     */
    private Gender gender;
    /**
     * The surname of person.
     */
    private String lastName;
    /**
     * The birthday of person.
     */
    private LocalDate birthdate;
    /**
     * Person's division
     */
    private IDivision division;
    /**
     * Person's salary
     */
    private BigDecimal salary;

    /**
     * empty constructor person's class.
     */
    public Person() {
    }

    /**
     * constructor for create person with params.
     *
     * @param id       of person
     * @param name     person name
     * @param gender   person gender
     * @param surName  person surname
     * @param birthdate person birthdate
     * @param division person division
     * @param salary   person salary
     */

    public Person(
            Integer id,
            String name,
            Gender gender,
            String surName,
            LocalDate birthdate,
            Division division,
            BigDecimal salary) {
        this.id = id;
        this.firstName = name;
        this.lastName = surName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
    }

    /**
     * Method for get name.
     *
     * @return person name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method for get surname.
     *
     * @return person surname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method for get birthday.
     *
     * @return person birthday
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Method for get gender.
     *
     * @return person gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method for set name.
     *
     * @param firstName person name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method for set city.
     *
     * @param lastName person surname
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method for set birthday.
     *
     * @param birthdate person birthday
     */
    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Method for set gender.
     *
     * @param gender person gender
     */
    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    /**
     * Method for set id.
     *
     * @param id person id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Method for get id.
     *
     * @return person id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Method for get division.
     *
     * @return person division
     */
    public IDivision getDivision() {
        return division;
    }

    /**
     * Method for get salary.
     *
     * @return person salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Method for set devision.
     *
     * @param division person division
     */
    public void setDivision(IDivision division) {
        this.division = division;
    }

    /**
     * Method for set salary.
     *
     * @param salary person salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", surName='" + lastName + '\'' +
                ", birthday=" + birthdate +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }

    /**
     * determines the age of a person by date of birth.
     *
     * @return age of the person
     */
    public Integer getAge() {
        LocalDate currentTime = LocalDate.now();
        return currentTime.getYear() - this.getBirthdate().getYear();
    }

    /**
     * remake gender as string to enum
     *
     * @param genderAsString gender as string
     * @return gender
     */
    public static Gender toGender(String genderAsString) {
        if ("Male".equals( genderAsString )) {
            return Gender.MALE;
        } else
            return Gender.FEMALE;
    }

   public static class ComparateClass implements Comparator<Person>{
        public int compare(Person obj1, Person obj2) {
            return obj1.getFirstName().compareTo( obj2.getFirstName() );
        }
    }
}
