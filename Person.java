import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name;
    private String surname;
    private int age;
    private int idPerson;
    private Gender gender;
    private Person mother;
    private Person father;
    private Person husband;
    private Person wife;
    private Person spouse;
    private List<Person> children;
    private List<Person> siblings;
    private List<Person> parents;



    public Person(Integer idPerson, String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.idPerson = idPerson;
        this.spouse = null;
        this.children = new ArrayList<Person>();
        this.siblings = new ArrayList<Person>();
        this.parents = new ArrayList<Person>();
    }

    public void addChild(Person child) {
        children.add(child);
        if (gender == Gender.MALE) {
            child.setFather(this);
            
            // if (wife != null) { // автоматическое добавление второго родителя, но это некорректно
            //     child.setMother(wife); // у одного из родителей могут быть дети от пред брака

            // }
        } else {
            child.setMother(this);
            // if (husband != null) {
            //     child.setFather(husband);

            // }
        }
    }

    public void addFather(Person father) {
        this.father = father;
        father.addChild(this);
        
    }

    public void addMother(Person mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public void setMother(Person mother) {
        this.mother = mother;
        parents.add(mother);
    }

    public void setFather(Person father) {
        this.father = father;
        parents.add(father);
    }

    public Set<Person> getParents() {
        Set<Person> parents = new HashSet<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }

    public Set<Person> getChildren() {
        return new HashSet<>(children);
    }
    
    public void addSpouse(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
        spouse.setPartner(spouse.spouse);
        spouse.spouse.setPartner(spouse);
    }
    
    public void setPartner(Person partner) {
        if (partner.getGender() == Gender.FEMALE) {
            siblings.add(partner);
            partner.getSiblings().add(this);
            wife = partner;
        } else {
            siblings.add(partner);
            partner.getSiblings().add(this);
            husband = partner;
        }
    }

    private Gender getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person getPartner() {
        Set<Person> partner = new HashSet<>();
        if (husband != null && husband.getGender() == Gender.MALE) {
            partner.add(husband);
            return husband;
        } else if (wife != null && wife.getGender() == Gender.FEMALE) {
            partner.add(wife);
            return wife;
        } else {
            return null;
        }
    }

    // public Person getHusband() {
    //     if (gender == Gender.FEMALE) {
    //         return getPartner();
    //     } else {
    //         return husband;
    //     }
    // }

    // public void setHusband(Person husband) {
    //     this.husband = husband;
    //     if (husband != null) {
    //         husband.setWife(this);
    //     }
    // }

    // public Person getWife() {
    //     if (gender == Gender.MALE) {
    //         return getPartner();
    //     } else {
    //         return wife;
    //     }
    // }

    // public void setWife(Person wife) {
    //     this.wife = wife;
    //     if (wife != null) {
    //         wife.setWife(this);
    //     }
    // }

    public Integer getId() {
        return idPerson;
    }
    
    @Override 
    public String toString() {
        return String.format(name, surname, age);
    }

}