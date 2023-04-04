package withInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface FamilyTree {
    void addParent(PersonInterface child, PersonInterface parent);
    void addChild(PersonInterface parent, PersonInterface child);
    void addSpouse(PersonInterface person1, PersonInterface person2);
    List<PersonInterface> getChildren(PersonInterface parent);
    List<PersonInterface> getParents(PersonInterface child);
    List<PersonInterface> getSpouses(PersonInterface person);
    void printFamilyTree(PersonInterface person, HashSet<PersonInterface> printed, int depth);
    Map<PersonInterface, List<PersonInterface>> getSpouseMapping();
    Map<PersonInterface, List<PersonInterface>> getParentChildMapping();
}
