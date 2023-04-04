package withInterface;

import java.util.ArrayList;
import java.util.List;

public class individual implements PersonInterface, SpouseInterface{
    private String name;
    private String surname;
    private Integer age;
    private Gender gender;
    private List<PersonInterface> spouse;

    public individual(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.spouse = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public Gender getSex() {
        return this.gender;
    }

    @Override
    public void setSex(Gender gender) {

    }
    @Override
    public List<PersonInterface> getSpouse() {
        return this.spouse;
    }

    @Override
    public void setSpouse(List<PersonInterface> spouse) {
        this.spouse = spouse;
    }

    @Override 
    public String toString() {
        return String.format(name, surname, age, gender, spouse);
    }
}

