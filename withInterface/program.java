package withInterface;
import java.util.HashSet;
// import java.util.List;

// import withInterface.individual;
public class program {
    // individual individual = new individual();
    public static void main(String[] args) {
        Integer level = 0;

        individual Oleg = new individual("Oleg", "Brown", 70, Gender.MALE);
        individual Olga = new individual("Olga", "Brown", 70, Gender.FEMALE);
        // individual Jane = new individual("Jane", "Brown", 50, Gender.FEMALE);
        individual Mike = new individual("Mike", "String", 30, Gender.MALE);
        individual David = new individual("David", "String", 30, Gender.MALE);
        individual anna = new individual("Anna", null, 30, Gender.FEMALE);
        individual billianna = new individual("Billianna", null, 62, Gender.FEMALE);
        individual charlie = new individual("Charlie", null, 8, Gender.MALE);
        individual david = new individual("David", null, 5, Gender.MALE);

        FamilyTree treeOne = new Tree();
        
        treeOne.addParent(anna, billianna); // bill родитель анны
        treeOne.addParent(anna, Oleg);

        treeOne.addChild(anna, David);
        treeOne.addChild(anna, charlie);
        treeOne.addChild(charlie, david);

        treeOne.addSpouse(anna, Mike);
        treeOne.addSpouse(billianna, Oleg);

        treeOne.printFamilyTree(billianna, new HashSet<>(), level);
        treeOne.printFamilyTree(Mike, new HashSet<>(), level);
        
    // создание комода
    Commode firstCommode = new Commode(01, "black");
    Commode twoCommode = new Commode(02, "white");
    
    // действия персонажей с комодом
    OpenDrawer open1 = new OpenDrawer(anna, Drawers.one, firstCommode);
    OpenDrawer open2 = new OpenDrawer(Olga, Drawers.two, firstCommode);
    OpenDrawer open3 = new OpenDrawer(Oleg, Drawers.three, twoCommode);

    // взаиодействие с ящиками
    System.out.println(open1); 
    System.out.println(open2);
    System.out.println(open3);

    // сохранение в файл семейных связей
    FileSaverInterface fileSaver = new SaveToTxt(treeOne);
    // String fileName = "family-tree.txt";
    fileSaver.saveToFile("family-tree.txt");

    }
    
}
