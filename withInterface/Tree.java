package withInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
// import java.util.Set;

public class Tree implements FamilyTree{
    private Map<PersonInterface, List<PersonInterface>> parentChildMapping;
    private Map<PersonInterface, List<PersonInterface>> spouseMapping;

    public Tree() {
        parentChildMapping = new HashMap<>();
        spouseMapping = new HashMap<>();
    }


    @Override
    public void addParent(PersonInterface child, PersonInterface parent) {
        List<PersonInterface> children = parentChildMapping.getOrDefault(parent, new ArrayList<>());
        children.add(child);
        parentChildMapping.put(parent, children);
    }

    @Override
    public void addChild(PersonInterface parent, PersonInterface child) {
        List<PersonInterface> children = parentChildMapping.getOrDefault(parent, new ArrayList<>());
        children.add(child);
        parentChildMapping.put(parent, children);
    }

    
    @Override
    public List<PersonInterface> getChildren(PersonInterface parent) {
        return parentChildMapping.get(parent);
    }

    @Override
    public List<PersonInterface> getParents(PersonInterface child) {
        List<PersonInterface> parents = new ArrayList<>();
        for (Map.Entry<PersonInterface, List<PersonInterface>> entry : parentChildMapping.entrySet()) {
            if (entry.getValue().contains(child)) {
                parents.add(entry.getKey());
            }
        }
        return parents;
        }

@Override
public void printFamilyTree(PersonInterface person, HashSet<PersonInterface> printed, int depth) {
    if (printed.contains(person)) { // если этот человек уже был распечатан, пропустить его *
        return;
    }

    printed.add(person);

    String tabs = "";
    for (int i = 0; i < depth; i++) {
        tabs += "\t"; // добавляем табуляцию в зависимости от глубины родства
    }
    
    System.out.println(tabs + person.getName() + " " + person.getAge()); // выводим имя и возраст человека
    if (spouseMapping.get(person) != null) {
        if (person.getSex() == Gender.MALE) {
            System.out.println(tabs + spouseMapping.get(person) + "WIFE");
        } 
        if (person.getSex() == Gender.FEMALE){
            System.out.println(tabs + spouseMapping.get(person) + "HUSBAND");
        }
        
    } else {
        System.out.println(tabs + "no spouse");
    }
    List<PersonInterface> children = getChildren(person);
    if (children != null) {
        for (PersonInterface child : children) {
            printFamilyTree(child, printed, depth + 1); // рекурсия для каждого потомка с увеличением глубины на 1
        }
    }

    List<PersonInterface> parents = getParents(person);
    if (parents != null) {
        for (PersonInterface parent : parents) {
            printFamilyTree(parent, printed, depth - 1); // рекурсия для каждого родителя с уменьшением глубины на 1
        }
    }
}


@Override
public void addSpouse(PersonInterface person1, PersonInterface person2) {
    List<PersonInterface> spouseList1 = spouseMapping.getOrDefault(person1, new ArrayList<>());
    spouseList1.add(person2);

    List<PersonInterface> spouseList2 = spouseMapping.getOrDefault(person2, new ArrayList<>());
    spouseList2.add(person1);

    spouseMapping.put(person1, spouseList1);
    spouseMapping.put(person2, spouseList2);
}


@Override
public List<PersonInterface> getSpouses(PersonInterface person) {
    return spouseMapping.getOrDefault(person, new ArrayList<>());
}


public Map<PersonInterface, List<PersonInterface>> getParentChildMapping() {
    return parentChildMapping;
}

public Map<PersonInterface, List<PersonInterface>> getSpouseMapping() {
    return spouseMapping;
}






}

    

