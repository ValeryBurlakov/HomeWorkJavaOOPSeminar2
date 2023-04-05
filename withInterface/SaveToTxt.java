package withInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SaveToTxt implements FileSaverInterface {

    private final FamilyTree familyTree;

    public SaveToTxt(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String fileName) {
        try {
            // FileWriter fileWriter = new FileWriter(fileName);
            File dir = new File("FamilyTree");
            //проверяем, существует ли такая директория, если нет - создаем
            if (!dir.exists()) {
                dir.mkdir();
            }
            FileWriter fileWriter = new FileWriter(dir.getName() + File.separator + fileName);
            for (Map.Entry<PersonInterface, List<PersonInterface>> entry : familyTree.getParentChildMapping().entrySet()) {
                String parents = entry.getKey().getName() + ", PARENT: ";
                for (PersonInterface child : entry.getValue()) {
                    parents += child.getName() + ", ";
                }
                parents = parents.substring(0, parents.length() - 2);
                parents += "\n";
                fileWriter.write(parents);
            }

            for (Map.Entry<PersonInterface, List<PersonInterface>> entry : familyTree.getSpouseMapping().entrySet()) {
                for (PersonInterface spouse : entry.getValue()) {
                    if (entry.getKey().hashCode() < spouse.hashCode()) {
                        String line;
                        if (entry.getKey().getSex() == Gender.MALE) {
                            line = entry.getKey().getName() + " - HUSBAND: " + spouse.getName() + "\n";
                        } else {
                            line = entry.getKey().getName() + " - WIFE: " + spouse.getName() + "\n";
                        }
                        fileWriter.write(line);
                    }
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file: " + e.getMessage());
        }
    } 
}
