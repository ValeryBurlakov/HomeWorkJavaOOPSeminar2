package withInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SaveToTxt implements FileSaver {

    private final FamilyTree familyTree;

    public SaveToTxt(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (Map.Entry<PersonInterface, List<PersonInterface>> entry : familyTree.getParentChildMapping().entrySet()) {
                for (PersonInterface child : entry.getValue()) {
                    String line = entry.getKey().getName() + ",PARENT," + child.getName() + "\n";
                    fileWriter.write(line);
                }
            }

            for (Map.Entry<PersonInterface, List<PersonInterface>> entry : familyTree.getSpouseMapping().entrySet()) {
                for (PersonInterface spouse : entry.getValue()) {
                    String line = entry.getKey().getName() + ",SPOUSE," + spouse.getName() + "\n";
                    fileWriter.write(line);
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file: " + e.getMessage());
        }
    }
}
