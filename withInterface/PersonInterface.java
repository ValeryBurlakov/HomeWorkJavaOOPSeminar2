package withInterface;

import java.util.List;

public interface PersonInterface {
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    int getAge();
    void setAge(int age);
    Gender getSex();
    void setSex(Gender gender);
    void setSpouse(List<PersonInterface> spouse);
    List<PersonInterface> getSpouse(); // *
    // void addSpouse(PersonInterface person1, PersonInterface person2);
    // List<PersonInterface> getSpouses(PersonInterface person);
}
